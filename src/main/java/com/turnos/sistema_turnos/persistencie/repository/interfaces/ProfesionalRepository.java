package com.turnos.sistema_turnos.persistencie.repository.interfaces;

import com.turnos.sistema_turnos.model.Profesional;

import java.util.Optional;

public interface ProfesionalRepository {
    Profesional crear(Profesional profesional);
    Profesional actualizar(Profesional profesional);
    Optional<Profesional> recuperar(Long profesional_id);
    void eliminar(Long profesional_id);
}
