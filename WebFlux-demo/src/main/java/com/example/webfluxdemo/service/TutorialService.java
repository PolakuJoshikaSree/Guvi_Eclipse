package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Tutorial;
import com.example.webfluxdemo.repository.TutorialRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialService {
    private final TutorialRepository repository;

    public TutorialService(TutorialRepository repository) {
        this.repository = repository;
    }

    public Mono<Tutorial> createTutorial(Tutorial tutorial) {
        return repository.save(tutorial);
    }

    public Flux<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

    public Mono<Tutorial> getTutorialById(Integer id) {
        return repository.findById(id);
    }

    public Flux<Tutorial> findByPublished(Boolean published) {
        return repository.findByPublished(published);
    }

    public Flux<Tutorial> findByTitleContaining(String title) {
        return repository.findByTitleContaining(title);
    }

    public Mono<Tutorial> updateTutorial(Integer id, Tutorial tutorial) {
        return repository.findById(id)
            .flatMap(existing -> {
                existing.setTitle(tutorial.getTitle());
                existing.setDescription(tutorial.getDescription());
                existing.setPublished(tutorial.getPublished());
                return repository.save(existing);
            });
    }

    public Mono<Void> deleteTutorial(Integer id) {
        return repository.deleteById(id);
    }

    public Mono<Void> deleteAllTutorials() {
        return repository.deleteAll();
    }
}
