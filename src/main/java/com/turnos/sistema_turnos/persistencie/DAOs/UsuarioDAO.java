package com.turnos.sistema_turnos.persistencie.DAOs;

import com.turnos.sistema_turnos.persistencie.entity.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuarioJPA, Long> {

}
