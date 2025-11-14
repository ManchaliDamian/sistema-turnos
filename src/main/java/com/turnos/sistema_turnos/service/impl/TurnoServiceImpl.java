package com.turnos.sistema_turnos.service.impl;

import com.turnos.sistema_turnos.model.Turno;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.TurnoRepository;
import com.turnos.sistema_turnos.service.interfaces.TurnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Turno crear(Turno turno) {
        return null;
    }

    @Override
    public Optional<Turno> obtenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Turno> obtenerTodos() {
        return List.of();
    }

    @Override
    public Turno actualizar(Long id, Turno turno) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
