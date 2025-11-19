package com.turnos.sistema_turnos.persistencie.entity;

import com.turnos.sistema_turnos.model.enums.EstadoTurno;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Representa la entidad de un turno en la base de datos.
 * Un turno es la reserva de un {@link ServicioJPA} por un {@link ClienteJPA} con un {@link ProfesionalJPA}
 * en una fecha y hora específicas.
 */
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
    /**
     * Identificador único del turno.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha y hora de inicio del turno. No puede ser nulo.
     */
    @Column(nullable = false)
    private LocalDateTime fecha_hora_inicio;

    /**
     * Fecha y hora de finalización del turno. No puede ser nulo.
     * Se calcula a partir de la fecha de inicio y la duración del servicio.
     */
    @Column(nullable = false)
    private  LocalDateTime fecha_hora_fin;

    /**
     * Estado actual del turno (PENDIENTE, CONFIRMADO, CANCELADO, etc.).
     * No puede ser nulo. El valor por defecto es PENDIENTE.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTurno estado = EstadoTurno.PENDIENTE;

    /**
     * El cliente que ha reservado el turno.
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private ClienteJPA cliente;

    /**
     * El profesional que atenderá el turno.
     */
    @ManyToOne
    @JoinColumn(name = "profesional_id", nullable = false)
    private ProfesionalJPA profesional;

    /**
     * El servicio que se realizará en el turno.
     */
    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private ServicioJPA servicio;

    /**
     * Observaciones o notas adicionales sobre el turno.
     * Tiene un límite de 1000 caracteres.
     */
    @Column(length = 1000)
    private String observaciones;


    /**
     * Constructor para crear una nueva instancia de TurnoJPA.
     *
     * @param fecha_hora_inicio La fecha y hora de inicio del turno.
     * @param fecha_hora_fin La fecha y hora de finalización del turno.
     * @param cliente El cliente que reserva el turno.
     * @param profesional El profesional que atenderá el turno.
     * @param servicio El servicio a realizar.
     * @param observaciones Notas adicionales sobre el turno.
     */
    public TurnoJPA (LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_fin, ClienteJPA cliente, ProfesionalJPA profesional, ServicioJPA servicio, String observaciones) {
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.cliente = cliente;
        this.profesional = profesional;
        this.servicio = servicio;
        this.observaciones = observaciones;
    }

}
