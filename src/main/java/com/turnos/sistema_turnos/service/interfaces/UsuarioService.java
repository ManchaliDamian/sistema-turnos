package com.turnos.sistema_turnos.service.interfaces;

import com.turnos.sistema_turnos.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    Optional<Usuario> recuperar(Long usuario_id);
    void eliminar(Long usuario_id);
}
