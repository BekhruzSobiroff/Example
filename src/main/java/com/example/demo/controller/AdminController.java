package com.example.demo.controller;

import com.example.demo.dto.ExampleDto;
import com.example.demo.entity.Difficulty;
import com.example.demo.entity.Example;
import com.example.demo.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ExampleService exampleService;



    @GetMapping
    public String admin1() {

        return "admin";
    }

    @PostMapping
    public String admin1(@RequestParam(name = "title") String title, @RequestParam(name = "difficulty") String difficulty) {
        Difficulty difficulty1 = Enum.valueOf(Difficulty.class, difficulty);
        Example example = new Example(new ExampleDto(title, difficulty1));
        exampleService.addExample(example.getAcceptance(),example.getFrequency(),example.getDifficulty().name(),example.getSolutionIcon(),example.getTitle());
        return "redirect:/admin";
    }
}
