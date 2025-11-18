package com.turnos.sistema_turnos.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Profesional extends Persona{
    private String especialidad;
    private Set<Servicio> servicios;
    private Set<Turno> turnos;

    public Profesional(String nombre, String apellido, String email, String tel, String especialidad) {
        super(nombre, apellido, email, tel);
        this.setEspecialidad(especialidad);
        this.setActivo(true);
        this.servicios = new HashSet<>();
        this.turnos = new HashSet<>();
    }
}
