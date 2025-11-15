package com.turnos.sistema_turnos.model;

import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Servicio {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion_minutos;
    private BigDecimal precio;
    private Set<ProfesionalJPA> profesionales;
    private boolean activo = true;
    private Instant created_at;
    private Instant update_at;

    public Servicio(String nombre, String descripcion, int duracion_minutos, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.precio = precio;
        this.profesionales = new HashSet<>();
    }

}
