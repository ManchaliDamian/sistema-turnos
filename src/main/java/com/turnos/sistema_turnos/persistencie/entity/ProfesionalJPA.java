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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@DiscriminatorValue("PROFESIONAL")
@Table
public class ProfesionalJPA extends PersonaJPA {

    @Size(max=100)
    private String especialidad;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicioJPA> servicios = new HashSet<>();


   public ProfesionalJPA(String nombre, String apellido, String email, String tel, String especialidad ) {
       super(nombre,apellido, email, tel );
       this.especialidad = especialidad;
       this.setActivo(true);
   }
}
