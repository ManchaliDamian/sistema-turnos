package com.turnos.sistema_turnos.model;

import com.turnos.sistema_turnos.model.enums.EstadoTurno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class Turno {
    private Long id;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_fin;
    private EstadoTurno estado;
    private Cliente cliente;
    private Profesional profesional;
    private Servicio servicio;
    private String observaciones;
    private Instant createdAt;
    private Instant updatedAt;
    private Long version;

    public Turno(LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_fin, Cliente cliente, Profesional profesional, Servicio servicio, String observaciones) {
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.cliente = cliente;
        this.profesional = profesional;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoTurno.PENDIENTE;
    }

}
