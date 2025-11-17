package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Turno;
import com.turnos.sistema_turnos.persistencie.entity.TurnoJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ClienteMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ServicioMapper;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.TurnoMapper;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapperImpl implements TurnoMapper {

    private final ClienteMapper clienteMapper;
    private final ProfesionalMapper profesionalMapper;
    private final ServicioMapper servicioMapper;

    public TurnoMapperImpl(ClienteMapper clienteMapper, ProfesionalMapper profesionalMapper, ServicioMapper servicioMapper) {
        this.clienteMapper = clienteMapper;
        this.profesionalMapper = profesionalMapper;
        this.servicioMapper = servicioMapper;
    }

    @Override
    public TurnoJPA toJPA(Turno turno) {
        if (turno == null) {
            return null;
        }

        TurnoJPA turnoJPA = new TurnoJPA(
                turno.getFecha_hora_inicio(),
                turno.getFecha_hora_fin(),
                clienteMapper.toJPA(turno.getCliente()),
                profesionalMapper.toJPA(turno.getProfesional()),
                servicioMapper.toJPA(turno.getServicio()),
                turno.getObservaciones()
        );

        turnoJPA.setId(turno.getId());
        turnoJPA.setEstado(turno.getEstado());

        return turnoJPA;
    }

    @Override
    public Turno toModel(TurnoJPA turnoJPA) {
        if (turnoJPA == null) {
            return null;
        }

        Turno turno = new Turno();
        turno.setId(turnoJPA.getId());
        turno.setFecha_hora_inicio(turnoJPA.getFecha_hora_inicio());
        turno.setFecha_hora_fin(turnoJPA.getFecha_hora_fin());
        turno.setEstado(turnoJPA.getEstado());
        turno.setObservaciones(turnoJPA.getObservaciones());
        turno.setCliente(clienteMapper.toModel(turnoJPA.getCliente()));
        turno.setProfesional(profesionalMapper.toModel(turnoJPA.getProfesional()));
        turno.setServicio(servicioMapper.toModel(turnoJPA.getServicio()));

        return turno;
    }
}
