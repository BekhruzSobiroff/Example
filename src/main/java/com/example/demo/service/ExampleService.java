package com.example.demo.service;

import com.example.demo.entity.Example;
import com.example.demo.repo.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    // Example ma'lumotlarini olish
    public List<Example> getAllExamples() {
        return exampleRepository.findAll();
    }

    // Yangi Example qo'shish
    public void addExample(Double acceptance, Boolean frequency, String difficulty, String solutionIcon, String title) {
        exampleRepository.saveAllExample(title,solutionIcon,acceptance,difficulty,frequency);

    }
}
