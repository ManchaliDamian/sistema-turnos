package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.persistencie.DAOs.ProfesionalDAO;
import com.turnos.sistema_turnos.persistencie.entity.ProfesionalJPA;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ProfesionalRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ProfesionalMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ProfesionalRepositoryImpl implements ProfesionalRepository {
    private final ProfesionalDAO profesionalDAO;
    private final ProfesionalMapper profesionalMapper;

    public ProfesionalRepositoryImpl (ProfesionalDAO profesionalDAO, ProfesionalMapper profesionalMapper) {
        this.profesionalDAO = profesionalDAO;
        this.profesionalMapper = profesionalMapper;
    }
    @Override
    public Profesional crear(Profesional profesional) {
        ProfesionalJPA profesionalCreado = profesionalMapper.toJPA(profesional);
        profesionalCreado = profesionalDAO.save(profesionalCreado);
        return profesionalMapper.toModel(profesionalCreado);
    }

    @Override
    public Profesional actualizar(Profesional profesional) {
        return null;
    }

    @Override
    public Optional<Profesional> recuperar(Long profesional_id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long profesional_id) {

    }
}
