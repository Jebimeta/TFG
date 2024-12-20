package com.tfg.tfg.model;

import com.tfg.tfg.model.enums.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre no se puede quedar vacío")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Los apellidos no se puede quedar vacío")
    @Column(name = "last_names", nullable = false)
    private String lastNames;

    @NotBlank(message = "El DNI no se puede quedar vacío")
    @Column(name = "dni", nullable = false)
    private String dni;

    @NotBlank(message = "El Email no se puede quedar vacío")
    @Column(name = "email", nullable = false)
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@$!%*?&^#_+=])[A-Za-z\\\\d@$!%*?&^#_+=]{8,}$\n", message = "El Password debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número, un carácter especial y no puede tener más de dos números seguidos")
    @NotBlank(message = "El Password no se puede quedar vacío")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone", nullable = true)
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Rol role;
}
