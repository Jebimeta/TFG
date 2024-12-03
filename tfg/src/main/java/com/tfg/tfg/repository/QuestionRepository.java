package com.tfg.tfg.repository;

import com.tfg.tfg.model.Question;
import com.tfg.tfg.model.enums.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestion(String question);

    Optional<Question> findByTheme(Theme theme);
}
