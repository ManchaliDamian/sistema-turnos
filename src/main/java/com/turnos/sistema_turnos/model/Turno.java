package com.turnos.sistema_turnos.model;

import com.turnos.sistema_turnos.model.enums.EstadoTurno;

import java.time.Instant;
import java.time.LocalDateTime;

public class Turno {
    private Long id;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_fin;
    private EstadoTurno estado;
    private Usuario usuario;
    private Profesional profesional;
    private Servicio servicio;
    private String observaciones;
    private Instant createdAt;
    private Instant updatedAt;
    private Long version;

    public Turno(LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_fin, Usuario usuario, Profesional profesional, Servicio servicio, String observaciones) {
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.usuario = usuario;
        this.profesional = profesional;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoTurno.PENDIENTE;
    }

}
