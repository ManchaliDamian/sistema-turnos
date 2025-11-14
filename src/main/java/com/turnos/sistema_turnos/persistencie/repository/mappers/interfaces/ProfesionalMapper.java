package com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;

public interface ProfesionalMapper {

    ProfesionalJPA toJPA(Profesional profesionalJPA);
    Profesional toModel(ProfesionalJPA profesionalJPA);
}
