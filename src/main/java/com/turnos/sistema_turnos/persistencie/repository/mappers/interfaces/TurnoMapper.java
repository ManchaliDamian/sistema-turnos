package com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces;

import com.turnos.sistema_turnos.model.Turno;
import com.turnos.sistema_turnos.persistencie.entity.TurnoJPA;

public interface TurnoMapper {
    TurnoJPA toJPA(Turno turno);
    Turno toModel(TurnoJPA turnoJPA);
}
