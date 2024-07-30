package com.example.demo.controller;

import com.example.demo.repo.ExampleRepository;
import com.example.demo.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.demo.entity.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final ExampleService exampleService;

    @GetMapping("/enter")
    public String getTable(Model example) {
        List<Example> items =  exampleService.getAllExamples();

        example.addAttribute("items",items);
        return "index";
    }
}
