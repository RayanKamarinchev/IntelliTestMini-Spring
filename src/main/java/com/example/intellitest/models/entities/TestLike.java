package com.example.intellitest.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TestLikes")
public class TestLike extends BaseEntity{
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Test test;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Test getTest() {
        return test;
    }
    
    public void setTest(Test test) {
        this.test = test;
    }
}
