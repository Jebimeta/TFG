package com.tfg.tfg.service.question;

import com.tfg.tfg.model.Question;
import com.tfg.tfg.model.enums.Theme;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAll();

    Optional<Question> findById(Long id);

    Optional<Question> findByQuestion(String question);

    Optional<Question> findByTheme(Theme theme);

    Question save(Question question);

    Question update(Question question);

    void delete(Long id);
}
