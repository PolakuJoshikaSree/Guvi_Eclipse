package com.bezkoder.jpa.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;
    
    // Constructors
    public Comment() {}
    
    public Comment(String content) {
        this.content = content;
    }
    
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public Tutorial getTutorial() { return tutorial; }
    public void setTutorial(Tutorial tutorial) { this.tutorial = tutorial; }
}