package com.turnos.sistema_turnos.service.impl;

import com.turnos.sistema_turnos.model.Usuario;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.UsuarioRepository;
import com.turnos.sistema_turnos.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioServiceImpl  implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl( UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.crear(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    @Override
    public Optional<Usuario> recuperar(Long usuario_id) {
        return usuarioRepository.recuperar(usuario_id);
    }

    @Override
    public void eliminar(Long usuario_id) {
        usuarioRepository.eliminar(usuario_id);
    }
}
