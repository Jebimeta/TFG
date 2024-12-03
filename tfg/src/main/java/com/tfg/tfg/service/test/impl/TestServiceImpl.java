package com.tfg.tfg.service.test.impl;

import com.tfg.tfg.model.Test;
import com.tfg.tfg.repository.TestRepository;
import com.tfg.tfg.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public Test findByName(String name) {
        return (Test) testRepository.findByName(name).orElse(null);
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test update(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void delete(Long id) {
        testRepository.deleteById(id);
    }
}
