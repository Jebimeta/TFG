package com.tfg.tfg.service.question.impl;

import com.tfg.tfg.model.Question;
import com.tfg.tfg.model.enums.Theme;
import com.tfg.tfg.repository.QuestionRepository;
import com.tfg.tfg.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Optional<Question> findByQuestion(String question) {
        return questionRepository.findByQuestion(question);
    }

    @Override
    public Optional<Question> findByTheme(Theme theme) {
        return questionRepository.findByTheme(theme);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}