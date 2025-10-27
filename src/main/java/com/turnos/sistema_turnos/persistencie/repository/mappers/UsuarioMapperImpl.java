package com.turnos.sistema_turnos.persistencie.repository.mappers;

import com.turnos.sistema_turnos.model.Usuario;
import com.turnos.sistema_turnos.persistencie.entity.UsuarioJPA;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper{
    @Override
    public UsuarioJPA toJPA(Usuario usuario) {
         UsuarioJPA usuarioJPA = new UsuarioJPA(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getTel());
         usuarioJPA.setActivo(usuario.isActivo());
         usuarioJPA.setRol(usuario.getRol());

        return usuarioJPA;
    }

    @Override
    public Usuario toModel(UsuarioJPA usuarioJPA) {
        Usuario usuario = new Usuario(usuarioJPA.getNombre(), usuarioJPA.getApellido(), usuarioJPA.getEmail(), usuarioJPA.getTel());
        usuario.setId(usuarioJPA.getId());
        usuario.setActivo(usuarioJPA.isActivo());
        usuario.setRol(usuarioJPA.getRol());
        usuario.setCreated_at(usuarioJPA.getCreated_at());
        usuario.setUpdate_at(usuarioJPA.getUpdate_at());
        return usuario;
    }
}
