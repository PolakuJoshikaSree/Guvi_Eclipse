package com.bezkoder.jpa.demo.repository;

import com.bezkoder.jpa.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTutorialId(Long tutorialId);
}