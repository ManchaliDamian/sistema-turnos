package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DiscriminatorValue("USUARIO")
@Table( name = "Usuario",
        indexes = {@Index(name = "idx_email",  columnList="email", unique = true)})
public class ClienteJPA extends PersonaJPA {



    public ClienteJPA(String nombre, String apellido, String email, String tel) {
        super(nombre, apellido, email, tel);

    }
}
