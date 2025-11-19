package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa a un profesional en el sistema.
 * Esta clase extiende de {@link PersonaJPA} y se utiliza para diferenciar a los profesionales
 * de otros tipos de personas en la base de datos. Un profesional ofrece servicios y atiende turnos.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PROFESIONAL")
public class ProfesionalJPA extends PersonaJPA {

    /**
     * La especialidad del profesional (ej. "Peluquería", "Masajes").
     * Tiene un tamaño máximo de 100 caracteres.
     */
    @Size(max=100)
    private String especialidad;

    /**
     * Conjunto de servicios que este profesional puede ofrecer.
     * La relación es de muchos a muchos y es propiedad de la entidad {@link ServicioJPA}.
     */
    @ManyToMany(mappedBy = "profesionales")
    private Set<ServicioJPA> servicios = new HashSet<>();

    /**
     * Conjunto de turnos asignados a este profesional.
     * La relación está configurada para que las operaciones de persistencia se propaguen
     * a los turnos asociados y se eliminen los turnos huérfanos.
     */
    @OneToMany(
            mappedBy = "profesional",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<TurnoJPA> turnos = new HashSet<>();

    /**
     * Constructor para crear una nueva instancia de ProfesionalJPA.
     *
     * @param nombre El nombre del profesional.
     * @param apellido El apellido del profesional.
     * @param email El correo electrónico del profesional.
     * @param tel El número de teléfono del profesional.
     * @param especialidad La especialidad del profesional.
     */
   public ProfesionalJPA(String nombre, String apellido, String email, String tel, String especialidad ) {
       super(nombre,apellido, email, tel );
       this.especialidad = especialidad;
       this.setActivo(true);
   }

    /**
     * Constructor por defecto requerido por JPA.
     */
    public ProfesionalJPA() {
        super();
    }
}
