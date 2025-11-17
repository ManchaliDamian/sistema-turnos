package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Turno;
import com.turnos.sistema_turnos.model.exceptions.TurnoNoEncontrado;
import com.turnos.sistema_turnos.persistencie.DAOs.TurnoDAO;
import com.turnos.sistema_turnos.persistencie.entity.TurnoJPA;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.TurnoRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.TurnoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        TurnoJPA turnoJPA = turnoMapper.toJPA(turno);
        turnoJPA = turnoDAO.save(turnoJPA);
        return turnoMapper.toModel(turnoJPA);
    }

    @Override
    public Turno actualizar(Turno turno) {
        // Verificamos que el turno exista antes de intentar actualizarlo.
        if (turno.getId() == null || !turnoDAO.existsById(turno.getId())) {
            throw new TurnoNoEncontrado(turno.getId());
        }
        TurnoJPA turnoAActualizar = turnoMapper.toJPA(turno);
        turnoAActualizar = turnoDAO.save(turnoAActualizar);
        return turnoMapper.toModel(turnoAActualizar);
    }

    @Override
    public Optional<Turno> recuperar(Long turno_id) {
        // Usamos findById que devuelve un Optional<TurnoJPA>
        // y lo mapeamos a Optional<Turno>
        return turnoDAO.findById(turno_id)
                .map(turnoMapper::toModel);
    }

    @Override
    public void eliminar(Long turno_id) {
        turnoDAO.deleteById(turno_id);
    }

    @Override
    public List<Turno> obtenerTodos() {
        return turnoDAO.findAll().stream()
                .map(turnoMapper::toModel)
                .toList();
    }
}
