package com.turnos.sistema_turnos.persistencie.repository.interfaces;

import com.turnos.sistema_turnos.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario crear(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    Optional<Usuario> recuperar(Long usuario_id);
    void eliminar(Long usuario_id);
}
