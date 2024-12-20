package com.tfg.tfg.model;

import com.tfg.tfg.model.enums.Option;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Option optionA;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Option optionB;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Option optionC;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Option optionD;

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

    public boolean checkAnswer(Option selectedOption) {
        return selectedOption.name().equals(this.answer);
    }
}