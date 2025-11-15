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

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PERSONA_BASE")
public abstract class PersonaJPA {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long personaId;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max=100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max=100)
    private String apellido;

    @Email(message = "El formato del email es inválido.")
    @Size(max=150)
    @Column(unique = true, length = 150)
    private String email;

    @Size(max=30)
    private String tel;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean activo = false;


    public PersonaJPA(String nombre, String apellido, String email, String tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tel = tel;
    }
}
