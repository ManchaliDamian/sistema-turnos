package com.turnos.sistema_turnos.persistencie.DAOs;

import com.turnos.sistema_turnos.persistencie.entity.ServicioJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioDAO extends JpaRepository<ServicioJPA, Long> {
}

