package com.turnos.sistema_turnos.service.interfaces;

import com.turnos.sistema_turnos.model.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    // CREATE
    Turno crear(Turno turno);

    // READ
    Optional<Turno> obtenerPorId(Long id);
    List<Turno> obtenerTodos();

    // UPDATE
    Turno actualizar(Long id, Turno turno);

    // DELETE
    void eliminar(Long id);
}
