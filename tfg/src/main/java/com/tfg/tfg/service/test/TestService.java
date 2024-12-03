package com.tfg.tfg.service.test;

import com.tfg.tfg.model.Test;

import java.util.List;

public interface TestService {

    List<Test> findAll();

    Test findById(Long id);

    Test findByName(String name);

    Test save(Test test);

    Test update(Test test);

    void delete(Long id);
}
