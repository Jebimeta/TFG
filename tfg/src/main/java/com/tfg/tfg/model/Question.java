package com.tfg.tfg.model;

import com.tfg.tfg.model.enums.Theme;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "questions", nullable = false)
    private String questionStatement;

    @NotBlank
    @Column(nullable = false)
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    @NotBlank
    @Column(nullable = false)
    private String answer;

    @NotBlank
    @Column(nullable = false)
    private String explanation;

    @Enumerated(EnumType.STRING)
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false, unique = true)
    private Test test;
}