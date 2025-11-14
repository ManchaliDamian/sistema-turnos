package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Turno;
import com.turnos.sistema_turnos.persistencie.DAOs.ProfesionalDAO;
import com.turnos.sistema_turnos.persistencie.DAOs.TurnoDAO;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.TurnoRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.TurnoMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TurnoRepositoryImpl implements TurnoRepository {

    private final TurnoDAO turnoDAO;
    private final TurnoMapper turnoMapper;

    public TurnoRepositoryImpl (TurnoDAO turnoDAO, TurnoMapper turnoMapper) {
        this.turnoDAO = turnoDAO;
        this.turnoMapper = turnoMapper;
    }
    @Override
    public Turno crear(Turno turno) {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

    @Override
    public Optional<Turno> recuperar(Long turno_id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long turno_id) {

    }
}
