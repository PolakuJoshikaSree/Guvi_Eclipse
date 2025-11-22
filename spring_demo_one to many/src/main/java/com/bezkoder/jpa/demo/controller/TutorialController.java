package com.bezkoder.jpa.demo.controller;

import com.bezkoder.jpa.demo.model.Tutorial;
import com.bezkoder.jpa.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    
    @Autowired
    private TutorialRepository tutorialRepo;
    
    @GetMapping
    public List<Tutorial> getAll() {
        return tutorialRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Tutorial getById(@PathVariable Long id) {
        return tutorialRepo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Tutorial create(@RequestBody Tutorial tutorial) {
        return tutorialRepo.save(tutorial);
    }
    
    @PutMapping("/{id}")
    public Tutorial update(@PathVariable Long id, @RequestBody Tutorial tutorial) {
        tutorial.setId(id);
        return tutorialRepo.save(tutorial);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tutorialRepo.deleteById(id);
    }
    
    @GetMapping("/published")
    public List<Tutorial> getPublished() {
        return tutorialRepo.findByPublished(true);
    }
}