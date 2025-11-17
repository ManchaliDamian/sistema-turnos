package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.Profesional;
import com.turnos.sistema_turnos.model.exceptions.ProfesionalNoEncontrado;
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

        if (profesional.getId() == null || !profesionalDAO.existsById(profesional.getId())) {
            throw new ProfesionalNoEncontrado(profesional.getId());
        }
        ProfesionalJPA profesionalAActualizar = profesionalMapper.toJPA(profesional);
        profesionalAActualizar = profesionalDAO.save(profesionalAActualizar);
        return profesionalMapper.toModel(profesionalAActualizar);
    }

    @Override
    public Optional<Profesional> recuperar(Long profesional_id) {

        return profesionalDAO.findById(profesional_id)
                .map(profesionalMapper::toModel);
    }

    @Override
    public void eliminar(Long profesional_id) {
        profesionalDAO.deleteById(profesional_id);
    }
}
