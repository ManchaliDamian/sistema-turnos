package com.turnos.sistema_turnos.persistencie.DAOs;

import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalDAO extends JpaRepository<ProfesionalJPA, Long> {
}
