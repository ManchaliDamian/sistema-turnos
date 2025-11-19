package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa un servicio ofrecido en el sistema.
 * Cada servicio tiene un nombre, descripción, duración, y precio, y puede ser ofrecido
 * por uno o más profesionales.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table( name = "Servicio",
        indexes = {@Index( name = "idx_nombre",  columnList="nombre")})
public class ServicioJPA {
    /**
     * Identificador único del servicio.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long servicioId;

    /**
     * Nombre del servicio. Es obligatorio y tiene un tamaño máximo de 150 caracteres.
     */
    @NotBlank
    @Size(max=150)
    private String nombre;

    /**
     * Descripción detallada del servicio. Es obligatoria y tiene un tamaño máximo de 500 caracteres.
     */
    @NotBlank @Size(max = 500)
    private String descripcion;

    /**
     * Duración del servicio en minutos. Es un campo obligatorio.
     */
    @NotBlank
    private int duracion_minutos;

    /**
     * Precio del servicio. Puede ser nulo y su valor por defecto es 0.
     */
    @Column(nullable = true)
    @ColumnDefault("0")
    private BigDecimal precio;

    /**
     * Conjunto de profesionales que ofrecen este servicio.
     * La relación es de muchos a muchos y se gestiona a través de una tabla intermedia "Profesional_Servicio".
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Profesional_Servicio",
            joinColumns =  @JoinColumn(
                    name = "servicio_id",
                    referencedColumnName = "servicioId"
            ),
            inverseJoinColumns = @JoinColumn(
                name = "profesional_id",
                referencedColumnName = "id")

    )
    private Set<ProfesionalJPA> profesionales;

    /**
     * Conjunto de turnos asociados a este servicio.
     * La relación está configurada para que las operaciones de persistencia se propaguen
     * a los turnos asociados y se eliminen los turnos huérfanos.
     */
    @OneToMany(
            mappedBy = "servicio",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<TurnoJPA> turnos = new HashSet<>();

    /**
     * Indica si el servicio está activo y disponible para ser reservado.
     * Por defecto, su valor es 'true'.
     */
    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean activo = true;

    /**
     * Constructor para crear una nueva instancia de ServicioJPA.
     *
     * @param nombre El nombre del servicio.
     * @param descripcion La descripción del servicio.
     * @param duracion_minutos La duración del servicio en minutos.
     * @param precio El precio del servicio.
     */
    public ServicioJPA (String nombre, String descripcion, int duracion_minutos, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.precio = precio;
        this.activo = true;

        this.profesionales = new HashSet<>();
    }
}
