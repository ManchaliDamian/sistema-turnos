package com.turnos.sistema_turnos.model;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona {

    public Cliente(String nombre, String apellido, String email, String tel) {
        super(nombre,apellido,email,tel);
        this.setActivo(true);
    }
}
