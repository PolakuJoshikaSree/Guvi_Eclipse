package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Tutorial;
import com.example.webfluxdemo.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    private final TutorialService service;

    public TutorialController(TutorialService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Tutorial> create(@RequestBody Tutorial tutorial) {
        return service.createTutorial(tutorial);
    }

    @GetMapping
    public Flux<Tutorial> getAll(@RequestParam(required = false) String title) {
        if (title != null) {
            return service.findByTitleContaining(title);
        }
        return service.getAllTutorials();
    }

    @GetMapping("/{id}")
    public Mono<Tutorial> getById(@PathVariable Integer id) {
        return service.getTutorialById(id);
    }

    @PutMapping("/{id}")
    public Mono<Tutorial> update(@PathVariable Integer id, @RequestBody Tutorial tutorial) {
        return service.updateTutorial(id, tutorial);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Integer id) {
        return service.deleteTutorial(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAll() {
        return service.deleteAllTutorials();
    }

    @GetMapping("/published")
    public Flux<Tutorial> findByPublished() {
        return service.findByPublished(true);
    }
}
