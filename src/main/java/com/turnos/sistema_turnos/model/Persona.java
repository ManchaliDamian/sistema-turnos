package com.turnos.sistema_turnos.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public abstract class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String tel;
    private boolean activo = false;


    public Persona(String nombre, String apellido, String email, String tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tel = tel;
    }
}
