package com.turnos.sistema_turnos.service.interfaces;

import com.turnos.sistema_turnos.model.Servicio;
import java.util.Optional;
import java.util.List;

public interface ServicioService {
    Servicio crear(Servicio servicio);
    Servicio actualizar(Servicio servicio);
    Optional<Servicio> recuperar(Long servicio_id);
    List<Servicio> recuperarTodos();
    void eliminar(Long servicio_id);
}

