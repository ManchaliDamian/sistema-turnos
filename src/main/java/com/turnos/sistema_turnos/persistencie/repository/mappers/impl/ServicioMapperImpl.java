package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Servicio;
import com.turnos.sistema_turnos.persistencie.entity.ServicioJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ServicioMapper;
import org.springframework.stereotype.Component;

@Component
public class ServicioMapperImpl implements ServicioMapper {

    @Override
    public ServicioJPA toJPA(Servicio servicio) {
        if (servicio == null) {
            return null;
        }

        ServicioJPA servicioJPA = new ServicioJPA(
            servicio.getNombre(),
            servicio.getDescripcion(),
            servicio.getDuracion_minutos(),
            servicio.getPrecio()
        );
        servicioJPA.setId(servicio.getId());
        servicioJPA.setActivo(servicio.isActivo());
        // mapper de profesionales
        // servicioJPA.setProfesionales(servicio.getProfesionales());
        return servicioJPA;
    }

    @Override
    public Servicio toModel(ServicioJPA servicioJPA) {
        if (servicioJPA == null) {
            return null;
        }

        Servicio servicio = new Servicio(
            servicioJPA.getNombre(),
            servicioJPA.getDescripcion(),
            servicioJPA.getDuracion_minutos(),
            servicioJPA.getPrecio()
        );
        servicio.setId(servicioJPA.getId());
        servicio.setActivo(servicioJPA.isActivo());
        return servicio;
    }
}

