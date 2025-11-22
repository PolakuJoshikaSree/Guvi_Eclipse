package com.bezkoder.jpa.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private boolean published;
    
    @OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
    
    // Constructors
    public Tutorial() {}
    
    public Tutorial(String title, String description) {
        this.title = title;
        this.description = description;
        this.published = false;
    }
    
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public boolean isPublished() { return published; }
    public void setPublished(boolean published) { this.published = published; }
    
    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
    
    // Helper method
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setTutorial(this);
    }
}