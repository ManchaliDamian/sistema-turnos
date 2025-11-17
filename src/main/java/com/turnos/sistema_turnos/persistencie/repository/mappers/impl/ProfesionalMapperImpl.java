package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfesionalMapperImpl implements ProfesionalMapper {
    @Override
    public ProfesionalJPA toJPA(Profesional profesional) {
        ProfesionalJPA profesionalJPA = new ProfesionalJPA(profesional.getNombre(), profesional.getApellido(), profesional.getEmail(), profesional.getTel(), profesional.getEspecialidad());
        profesionalJPA.setId(profesional.getId());
        profesionalJPA.setActivo(profesional.isActivo());
        // TODO: Mapear la lista de servicios cuando se inyecte el ServicioMapper
        // if (profesional.getServicios() != null) {
        //     profesionalJPA.setServicios(profesional.getServicios().stream().map(servicioMapper::toJPA).collect(Collectors.toSet()));
        // }
        return profesionalJPA;
    }

    @Override
    public Profesional toModel(ProfesionalJPA profesionalJPA) {
        Profesional profesional = new Profesional(profesionalJPA.getNombre(), profesionalJPA.getApellido(), profesionalJPA.getEmail(), profesionalJPA.getTel(), profesionalJPA.getEspecialidad());
        profesional.setId(profesionalJPA.getId());
        return profesional;
    }
}
