package com.turnos.sistema_turnos.service.interfaces;

import com.turnos.sistema_turnos.model.Profesional;

import java.util.Optional;

public interface ProfesionalService {
    Profesional crear(Profesional profesional);
    Profesional actualizar(Profesional profesional);
    Optional<Profesional> recuperar(Long profesional_id);
    void eliminar(Long profesional_id);
}
