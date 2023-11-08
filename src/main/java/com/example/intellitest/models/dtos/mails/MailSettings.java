package com.example.intellitest.models.dtos.mails;

public class MailSettings {
    private String DisplayName;
    private String From;
    private String UserName;
    private String Password;
    private String Host;
    private int Port;
    private boolean UseSSL;
    private boolean UseStartTls;
    
    public String getDisplayName() {
        return DisplayName;
    }
    
    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }
    
    public String getFrom() {
        return From;
    }
    
    public void setFrom(String from) {
        From = from;
    }
    
    public String getUserName() {
        return UserName;
    }
    
    public void setUserName(String userName) {
        UserName = userName;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String password) {
        Password = password;
    }
    
    public String getHost() {
        return Host;
    }
    
    public void setHost(String host) {
        Host = host;
    }
    
    public int getPort() {
        return Port;
    }
    
    public void setPort(int port) {
        Port = port;
    }
    
    public boolean isUseSSL() {
        return UseSSL;
    }
    
    public void setUseSSL(boolean useSSL) {
        UseSSL = useSSL;
    }
    
    public boolean isUseStartTls() {
        return UseStartTls;
    }
    
    public void setUseStartTls(boolean useStartTls) {
        UseStartTls = useStartTls;
    }
}
