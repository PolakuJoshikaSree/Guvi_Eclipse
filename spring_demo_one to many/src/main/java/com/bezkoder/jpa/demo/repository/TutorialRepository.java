package com.bezkoder.jpa.demo.repository;

import com.bezkoder.jpa.demo.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
}