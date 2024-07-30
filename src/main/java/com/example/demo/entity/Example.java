package com.example.demo.entity;


import com.example.demo.dto.ExampleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "example")
@Table(name = "example")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String solutionIcon;

    @Column(name = "acceptance")
    private Double acceptance;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(name = "frequency")
    private Boolean frequency;
    public Example(ExampleDto exampleAddDto){
        this.solutionIcon="code";
        this.acceptance=0.0d;
        this.title= exampleAddDto.title();
        this.difficulty=exampleAddDto.difficulty();
        this.frequency=false;
    }

}
