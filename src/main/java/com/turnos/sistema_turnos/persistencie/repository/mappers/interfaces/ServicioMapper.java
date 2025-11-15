package com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces;

import com.turnos.sistema_turnos.model.Servicio;
import com.turnos.sistema_turnos.persistencie.entity.ServicioJPA;

public interface ServicioMapper {
    ServicioJPA toJPA(Servicio servicio);
    Servicio toModel(ServicioJPA servicioJPA);
}

