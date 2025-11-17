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
        return turnoRepository.crear(turno);
    }

    @Override
    public Optional<Turno> obtenerPorId(Long id) {
        return turnoRepository.recuperar(id);
    }

    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepository.obtenerTodos();
    }

    @Override
    public Turno actualizar(Long id, Turno turno) {
        // La responsabilidad del servicio es asegurar que el ID esté en el objeto
        turno.setId(id);
        return turnoRepository.actualizar(turno);
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.eliminar(id);
    }
}
