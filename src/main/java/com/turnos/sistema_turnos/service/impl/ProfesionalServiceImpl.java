package com.turnos.sistema_turnos.service.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ProfesionalRepository;
import com.turnos.sistema_turnos.service.interfaces.ProfesionalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {
    private final ProfesionalRepository profesionalRepository;

    public ProfesionalServiceImpl(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }


    @Override
    public Profesional crear(Profesional profesional) {
        return profesionalRepository.crear(profesional);
    }

    @Override
    public Profesional actualizar(Profesional profesional) {
        return profesionalRepository.actualizar(profesional);
    }

    @Override
    public Optional<Profesional> recuperar(Long profesional_id) {
        return profesionalRepository.recuperar(profesional_id);
    }

    @Override
    public void eliminar(Long profesional_id) {
        profesionalRepository.eliminar(profesional_id);
    }
}
