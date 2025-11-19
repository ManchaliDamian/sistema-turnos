package com.turnos.sistema_turnos.persistencie.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa a un cliente en el sistema.
 * Esta clase extiende de {@link PersonaJPA} y se utiliza para diferenciar a los clientes
 * de otros tipos de personas en la base de datos a través de una estrategia de herencia.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CLIENTE")
public class ClienteJPA extends PersonaJPA {

    /**
     * Conjunto de turnos asociados a este cliente.
     * La relación está configurada para que las operaciones de persistencia se propaguen
     * a los turnos asociados y se eliminen los turnos huérfanos.
     */
    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<TurnoJPA> turnos = new HashSet<>();

    /**
     * Constructor para crear una nueva instancia de ClienteJPA.
     *
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param email El correo electrónico del cliente.
     * @param tel El número de teléfono del cliente.
     */
    public ClienteJPA(String nombre, String apellido, String email, String tel) {
        super(nombre, apellido, email, tel);
    }
}
