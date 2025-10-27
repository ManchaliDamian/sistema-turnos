package com.turnos.sistema_turnos.model;

import com.turnos.sistema_turnos.model.enums.Role;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona {


    private Role rol = Role.ROLE_USER;


    public Usuario(String nombre, String apellido, String email, String tel) {
        super(nombre,apellido,email,tel);
    }
}
