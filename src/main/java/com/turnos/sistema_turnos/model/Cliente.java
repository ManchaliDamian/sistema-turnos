package com.turnos.sistema_turnos.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona {

    private Set<Turno> turnos = new HashSet<>();
    public Cliente(String nombre, String apellido, String email, String tel) {
        super(nombre,apellido,email,tel);
        this.setActivo(true);
    }
}
