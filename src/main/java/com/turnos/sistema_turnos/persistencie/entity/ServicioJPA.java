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
    private Long id;

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

    @ManyToMany(mappedBy = "servicios", cascade = CascadeType.ALL)
    private Set<ProfesionalJPA> profesionales;

    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean activo = true;

    // Auditoria
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant update_at;

    public ServicioJPA (String nombre, String descripcion, int duracion_minutos, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.precio = precio;
        this.activo = true;

        this.profesionales = new HashSet<>();
    }
}
