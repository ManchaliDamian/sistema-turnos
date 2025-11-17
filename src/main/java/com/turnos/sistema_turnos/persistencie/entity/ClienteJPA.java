package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CLIENTE")
public class ClienteJPA extends PersonaJPA {


    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<TurnoJPA> turnos = new HashSet<>();

    public ClienteJPA(String nombre, String apellido, String email, String tel) {
        super(nombre, apellido, email, tel);
    }
}