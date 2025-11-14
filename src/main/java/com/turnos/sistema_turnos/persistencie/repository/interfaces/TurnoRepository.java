package com.turnos.sistema_turnos.persistencie.repository.interfaces;

import com.turnos.sistema_turnos.model.Turno;

import java.util.Optional;

public interface TurnoRepository {
    Turno crear(Turno turno);
    Turno actualizar(Turno turno);
    Optional<Turno> recuperar(Long turno_id);
    void eliminar(Long turno_id);

}
