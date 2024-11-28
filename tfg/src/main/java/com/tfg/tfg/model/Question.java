package com.tfg.tfg.model;

import jakarta.persistence.*;
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

    @Column(name = "questions", nullable = false)
    private String questionStatement;

    @Column(nullable = false)
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private String explanation;

    @Enumerated(EnumType.STRING)
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false, unique = true)
    private Test test;
}