package com.example.intellitest.mappers;

import com.example.intellitest.models.dtos.users.EditUser;
import com.example.intellitest.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
//    @Mapping(source = "eventTime", target = "occurrence")
    UserEntity mapEditUserToEntity(EditUser dto);
    
//    @Mapping(source = "occurrence", target = "eventTime")
    EditUser mapEntityToEdiTUser(UserEntity entity);
}