package com.example.intellitest.models.dtos.users;

public class UserChatModel {
    private String UserName;
    private String FullName;
    private String Avatar;
    private String CurrentRoom;
    
    public String getUserName() {
        return UserName;
    }
    
    public void setUserName(String userName) {
        UserName = userName;
    }
    
    public String getFullName() {
        return FullName;
    }
    
    public void setFullName(String fullName) {
        FullName = fullName;
    }
    
    public String getAvatar() {
        return Avatar;
    }
    
    public void setAvatar(String avatar) {
        Avatar = avatar;
    }
    
    public String getCurrentRoom() {
        return CurrentRoom;
    }
    
    public void setCurrentRoom(String currentRoom) {
        CurrentRoom = currentRoom;
    }
}
