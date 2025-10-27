package com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces;

import com.turnos.sistema_turnos.model.Usuario;
import com.turnos.sistema_turnos.persistencie.entity.UsuarioJPA;

public interface UsuarioMapper {
    UsuarioJPA toJPA(Usuario usuario);
    Usuario toModel(UsuarioJPA usuarioJPA);
}
