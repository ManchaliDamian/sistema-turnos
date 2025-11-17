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
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table( name = "Servicio",
        indexes = {@Index( name = "idx_nombre",  columnList="nombre")})
public class ServicioJPA {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long servicioId;

    @NotBlank
    @Size(max=150)
    private String nombre;

    @NotBlank @Size(max = 500)
    private String descripcion;

    @NotBlank
    private int duracion_minutos;

    @Column(nullable = true)
    @ColumnDefault("0")
    private BigDecimal precio;

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

    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean activo = true;


    public ServicioJPA (String nombre, String descripcion, int duracion_minutos, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.precio = precio;
        this.activo = true;

        this.profesionales = new HashSet<>();
    }
}
