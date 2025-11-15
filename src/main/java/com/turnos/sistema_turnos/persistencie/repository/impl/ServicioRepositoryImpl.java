package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Servicio;
import com.turnos.sistema_turnos.model.exceptions.ServicioNoEncontrado;
import com.turnos.sistema_turnos.persistencie.DAOs.ServicioDAO;
import com.turnos.sistema_turnos.persistencie.entity.ServicioJPA;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ServicioRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ServicioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ServicioRepositoryImpl implements ServicioRepository {
    private final ServicioDAO servicioDAO;
    private final ServicioMapper servicioMapper;

    public ServicioRepositoryImpl(ServicioDAO servicioDAO, ServicioMapper servicioMapper) {
        this.servicioDAO = servicioDAO;
        this.servicioMapper = servicioMapper;
    }

    @Override
    public Servicio crear(Servicio servicio) {
        ServicioJPA servicioJPA = servicioMapper.toJPA(servicio);
        servicioJPA = servicioDAO.save(servicioJPA);
        return servicioMapper.toModel(servicioJPA);
    }

    @Override
    public Servicio actualizar(Servicio servicio) {
        if (servicio.getId() == null || !servicioDAO.existsById(servicio.getId())) {
            throw new ServicioNoEncontrado(servicio.getId());
        }
        ServicioJPA servicioJPA = servicioMapper.toJPA(servicio);
        servicioJPA = servicioDAO.save(servicioJPA);
        return servicioMapper.toModel(servicioJPA);
    }

    @Override
    public Optional<Servicio> recuperar(Long servicio_id) {
        return servicioDAO.findById(servicio_id)
            .map(servicioMapper::toModel);
    }

    @Override
    public List<Servicio> recuperarTodos() {
        return servicioDAO.findAll()
            .stream()
            .map(servicioMapper::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long servicio_id) {
        if (!servicioDAO.existsById(servicio_id)) {
            throw new ServicioNoEncontrado(servicio_id);
        }
        servicioDAO.deleteById(servicio_id);
    }
}

