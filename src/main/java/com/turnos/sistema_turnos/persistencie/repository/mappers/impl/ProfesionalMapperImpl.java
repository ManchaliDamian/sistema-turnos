package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;

public class ProfesionalMapperImpl implements ProfesionalMapper {
    @Override
    public ProfesionalJPA toJPA(Profesional profesional) {
        ProfesionalJPA profesionalJPA = new ProfesionalJPA(profesional.getNombre(), profesional.getApellido(), profesional.getEmail(), profesional.getTel(), profesional.getEspecialidad());
        profesionalJPA.setId(profesional.getId());
        profesionalJPA.setActivo(profesional.isActivo());
        // mapper de servicios
        // profesionalJPA.setServicios(profesional.getServicios());
        return null;
    }

    @Override
    public Profesional toModel(ProfesionalJPA profesionalJPA) {
        Profesional profesional = new Profesional(profesionalJPA.getNombre(), profesionalJPA.getApellido(), profesionalJPA.getEmail(), profesionalJPA.getTel(), profesionalJPA.getEspecialidad());
        profesional.setId(profesionalJPA.getId());
        return profesional;
    }
}
