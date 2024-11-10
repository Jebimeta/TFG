package com.tfg.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false) // Nombre de columna para clave foránea
    private User user;

    @Column(name = "total_questions", nullable = false)
    private int totalQuestions;

    @Column(name = "sucesses", nullable = false)
    private int sucesses;

    @Column(name = "errors", nullable = false)
    private int errors;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
}
