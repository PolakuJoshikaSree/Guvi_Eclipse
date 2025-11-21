package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Tutorial;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface TutorialRepository extends R2dbcRepository<Tutorial, Integer> {
    Flux<Tutorial> findByPublished(Boolean published);
    Flux<Tutorial> findByTitleContaining(String title);
}
