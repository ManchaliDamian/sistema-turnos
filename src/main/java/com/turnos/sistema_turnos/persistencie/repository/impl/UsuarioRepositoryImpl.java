package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Usuario;
import com.turnos.sistema_turnos.persistencie.DAOs.UsuarioDAO;
import com.turnos.sistema_turnos.persistencie.entity.UsuarioJPA;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.UsuarioRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.UsuarioMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioDAO usuarioDAO;
    private final UsuarioMapper usuarioMapper;
    public UsuarioRepositoryImpl(UsuarioDAO usuarioDAO, UsuarioMapper usuarioMapper) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        UsuarioJPA usuarioJPA = usuarioMapper.toJPA(usuario);
        usuarioJPA = usuarioDAO.save(usuarioJPA);

        return usuarioMapper.toModel(usuarioJPA);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        // preguntar si existe el usuario
        return usuarioMapper.toModel(usuarioDAO.save(usuarioMapper.toJPA(usuario)));
    }

    @Override
    public Optional<Usuario> recuperar(Long usuario_id) {
        return usuarioDAO.findById(usuario_id).map(usuarioMapper::toModel);
    }

    @Override
    public void eliminar(Long usuario_id) {
        usuarioDAO.deleteById(usuario_id);
    }
}
