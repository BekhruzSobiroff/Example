package com.example.demo.dto;

import com.example.demo.entity.Difficulty;
import com.example.demo.entity.Example;

import java.io.Serializable;

/**
 * DTO for {@link Example}
 */
public record ExampleDto(String title, Difficulty difficulty) implements Serializable {
}