package com.turnos.sistema_turnos.persistencie.DAOs;

import com.turnos.sistema_turnos.persistencie.entity.ClienteJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository<ClienteJPA, Long> {

}
