package com.turnos.sistema_turnos.persistencie.entity;

import com.turnos.sistema_turnos.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@DiscriminatorValue("USUARIO")
@Table( name = "Usuario",
        indexes = {@Index(name = "idx_email",  columnList="email", unique = true)})
public class UsuarioJPA extends PersonaJPA {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'ROLE_USER'")
    private Role rol = Role.ROLE_USER;


    public UsuarioJPA(String nombre, String apellido, String email, String tel) {
        super(nombre, apellido, email, tel);

    }
}
