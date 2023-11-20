package com.example.intellitest.services;

import com.example.intellitest.mappers.UserMapper;
import com.example.intellitest.models.dtos.users.EditUser;
import com.example.intellitest.models.dtos.users.RegisterViewModel;
import com.example.intellitest.models.dtos.users.RoleInfo;
import com.example.intellitest.models.entities.Role;
import com.example.intellitest.models.entities.Student;
import com.example.intellitest.models.entities.Teacher;
import com.example.intellitest.models.entities.UserEntity;
import com.example.intellitest.repositories.RoleRepository;
import com.example.intellitest.repositories.StudentRepository;
import com.example.intellitest.repositories.TeacherRepository;
import com.example.intellitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final FileService fileService;
    
    
    @Autowired
    public UserService(UserRepository userRepository,
                       StudentRepository studentRepository, TeacherRepository teacherRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, FileService fileService) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.fileService = fileService;
    }
    
    public void registerUser(RegisterViewModel registrationDTO) {
        if (userRepository.getByEmail(registrationDTO.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        UserEntity userEntity = new UserEntity().
                setFirstName(registrationDTO.getFirstName()).
                setLastName(registrationDTO.getLastName()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword()))
                .setIsDeleted(false);
        
        userRepository.save(userEntity);
    }
    
    private User map(UserEntity user) {
        
        List<GrantedAuthority> authorities = user.
                getRoles().
                stream().
                map(r -> new SimpleGrantedAuthority(r.getRole())).
                collect(Collectors.toList());
        
        org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword() != null ? user.getPassword() : "",
                authorities);
        
        if (user.getPassword() == null){
            result.eraseCredentials();
        }
        
        return result;
    }
    
    public UserDetails getUserByEmail(String email) throws UsernameNotFoundException {
        
        Optional<UserEntity> userOpt = userRepository
                .getByEmail(email);
        
        return userOpt.map(this::map).orElse(null);
    }
    
    public Optional<Long> getStudentId(Long userId){
        Optional<Student> student = studentRepository.findTopByUserId(userId);
        if(student == null){
            return null;
        }
        return Optional.ofNullable(student.get().getId());
    }
    public Optional<Long> getTeacherId(Long userId){
        Optional<Teacher> student = teacherRepository.findTopByUserId(userId);
        if(student == null){
            return null;
        }
        return Optional.ofNullable(student.get().getId());
    }
    
    public UserEntity getUserById(Long id) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        
        return userOpt.orElse(null);
    }
    
    public EditUser getEditUserById(Long userId){
        UserEntity userEntity = getUserById(userId);
        if (userEntity == null){
            return null;
        }
        EditUser dto = UserMapper.INSTANCE.mapEntityToEdiTUser(userEntity);
        return dto;
    }
    
    public RoleInfo updateUser(EditUser model, boolean isStudent, boolean isTeacher) throws IOException {
        UserEntity user = userRepository.getById(model.getUserId());
        RoleInfo roleInfo = null;
        if (model.getImage() != null && model.getImage().getContentType().startsWith("image")){
            String folder = model.getImagePath();
            if (folder == null || folder == ""){
                String randId = UUID.randomUUID().toString();
                folder =
                        model.getImageFolderPath() + randId + "_" + model.getImage().getOriginalFilename();
            }
            String fileUpload = fileService.saveFile(model.getImage());
            user.setImagePath(fileUpload);
        }
        else{
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            if (model.getPassword() != null && passwordEncoder.matches(model.getPassword(), user.getPassword())){
                user.setEmail(model.getEmail());
            }
            if (!isStudent && !isTeacher){
                if (!model.getIsStudent()){
                    Collection<SimpleGrantedAuthority> roles =
                                            (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
                                    roles.add(new SimpleGrantedAuthority("Teacher"));
                    Teacher teacher = new Teacher();
                    teacher.setUser(user);
                    teacherRepository.save(teacher);
                    roleInfo =  new RoleInfo("Teacher", teacher.getId());
                    Role role = new Role(model.getUserId(), "Teacher");
                    roleRepository.save(role);
                }
                else{
                    Student student = new Student().setSchool(model.getSchool());
                    student.setUser(user);
                    studentRepository.save(student);
                    roleInfo =  new RoleInfo("Student", student.getId());
                    Role role = new Role(model.getUserId(), "Student");
                    roleRepository.save(role);
                }
            }
        }
        userRepository.save(user);
        return roleInfo;
    }
}
