package com.bezkoder.jpa.demo.controller;

import com.bezkoder.jpa.demo.model.Comment;
import com.bezkoder.jpa.demo.repository.CommentRepository;
import com.bezkoder.jpa.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Autowired
    private CommentRepository commentRepo;
    
    @Autowired
    private TutorialRepository tutorialRepo;
    
    @GetMapping("/tutorial/{tutorialId}")
    public List<Comment> getByTutorial(@PathVariable Long tutorialId) {
        return commentRepo.findByTutorialId(tutorialId);
    }
    
    @PostMapping("/tutorial/{tutorialId}")
    public Comment addComment(@PathVariable Long tutorialId, @RequestBody Comment comment) {
        tutorialRepo.findById(tutorialId).ifPresent(comment::setTutorial);
        return commentRepo.save(comment);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentRepo.deleteById(id);
    }
}