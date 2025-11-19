package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

/**
 * Clase base abstracta para entidades de personas en el sistema.
 * Utiliza una estrategia de herencia de tabla única para mapear las subclases
 * a una sola tabla en la base de datos, diferenciadas por la columna 'tipo_persona'.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PERSONA_BASE")
public abstract class PersonaJPA {
    /**
     * Identificador único de la persona.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * Nombre de la persona. Es obligatorio y tiene un tamaño máximo de 100 caracteres.
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max=100)
    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Apellido de la persona. Tiene un tamaño máximo de 100 caracteres.
     */
    @Size(max=100)
    private String apellido;

    /**
     * Correo electrónico de la persona. Debe ser único y tener un formato de email válido.
     * Tiene un tamaño máximo de 150 caracteres.
     */
    @Email(message = "El formato del email es inválido.")
    @Size(max=150)
    @Column(unique = true, length = 150)
    private String email;

    /**
     * Número de teléfono de la persona. Tiene un tamaño máximo de 30 caracteres.
     */
    @Size(max=30)
    private String tel;

    /**
     * Indica si la persona está activa en el sistema.
     * Por defecto, su valor es 'false'.
     */
    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean activo = false;

    /**
     * Constructor para crear una nueva instancia de PersonaJPA.
     *
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param email El correo electrónico de la persona.
     * @param tel El número de teléfono de la persona.
     */
    public PersonaJPA(String nombre, String apellido, String email, String tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tel = tel;
    }
}
