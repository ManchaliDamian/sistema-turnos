package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ServicioMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.TurnoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfesionalMapperImpl implements ProfesionalMapper {
    private final TurnoMapper turnoMapper;
    private final ServicioMapper servicioMapper;

    public ProfesionalMapperImpl(TurnoMapper turnoMapper, ServicioMapper servicioMapper) {
        this.servicioMapper
                = servicioMapper;
        this.turnoMapper = turnoMapper;
    }
    @Override
    public ProfesionalJPA toJPA(Profesional profesional) {
        ProfesionalJPA profesionalJPA = new ProfesionalJPA(profesional.getNombre(), profesional.getApellido(), profesional.getEmail(), profesional.getTel(), profesional.getEspecialidad());
        profesionalJPA.setId(profesional.getId());
        profesionalJPA.setActivo(profesional.isActivo());
        // JPASimple para evitar recursividad
        if (profesional.getServicios() != null) {
            profesionalJPA.setServicios(profesional.getServicios().stream().map(servicioMapper::toJPA).collect(Collectors.toSet()));
        }
        // jpaSimple para evitar recursividad
        profesionalJPA.setTurnos(profesional.getTurnos().stream().map(turnoMapper::toJPA).collect(Collectors.toSet()));
        return profesionalJPA;
    }

    @Override
    public Profesional toModel(ProfesionalJPA profesionalJPA) {
        Profesional profesional = new Profesional(profesionalJPA.getNombre(), profesionalJPA.getApellido(), profesionalJPA.getEmail(), profesionalJPA.getTel(), profesionalJPA.getEspecialidad());
        profesional.setId(profesionalJPA.getId());
        // modelSimple
        profesional.setServicios(profesionalJPA.getServicios().stream().map(servicioMapper::toModel).collect(Collectors.toSet()));
        //modelSimple para evitar recursividad
        profesional.setTurnos(profesionalJPA.getTurnos().stream().map(turnoMapper::toModel).collect(Collectors.toSet()));

        return profesional;
    }
}
