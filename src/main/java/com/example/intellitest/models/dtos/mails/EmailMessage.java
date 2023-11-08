package com.example.intellitest.models.dtos.mails;

public class EmailMessage {
    public String to;
    public String subject;
    public String body;
    
    public EmailMessage(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
