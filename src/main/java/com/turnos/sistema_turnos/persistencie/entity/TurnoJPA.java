package com.turnos.sistema_turnos.persistencie.entity;

import com.turnos.sistema_turnos.model.enums.EstadoTurno;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "turno",
       indexes = {
               @Index(name = "idx_turno_profesional_fechas", columnList = "profesional_id, fecha_hora_inicio, fecha_hora_fin"),
               @Index(name = "idx_turno_usuario", columnList = "usuario_id")
      })
public class TurnoJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha_hora_inicio;

    @Column(nullable = false)
    private  LocalDateTime fecha_hora_fin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTurno estado = EstadoTurno.PENDIENTE;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private ClienteJPA cliente;

    @ManyToOne
    @JoinColumn(name = "profesional_id", nullable = false)
    private ProfesionalJPA profesional;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private ServicioJPA servicio;

    @Column(length = 1000)
    private String observaciones;


    public TurnoJPA (LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_fin, ClienteJPA cliente, ProfesionalJPA profesional, ServicioJPA servicio, String observaciones) {
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.cliente = cliente;
        this.profesional = profesional;
        this.servicio = servicio;
        this.observaciones = observaciones;
    }

}
