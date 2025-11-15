package com.turnos.sistema_turnos.service.impl;

import com.turnos.sistema_turnos.model.Servicio;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ServicioRepository;
import com.turnos.sistema_turnos.service.interfaces.ServicioService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio crear(Servicio servicio) {
        return servicioRepository.crear(servicio);
    }

    @Override
    public Servicio actualizar(Servicio servicio) {
        return servicioRepository.actualizar(servicio);
    }

    @Override
    public Optional<Servicio> recuperar(Long servicio_id) {
        return servicioRepository.recuperar(servicio_id);
    }

    @Override
    public List<Servicio> recuperarTodos() {
        return servicioRepository.recuperarTodos();
    }

    @Override
    public void eliminar(Long servicio_id) {
        servicioRepository.eliminar(servicio_id);
    }
}

