package com.turnos.sistema_turnos.model.exceptions;

public class ServicioNoEncontrado extends RuntimeException {
    public ServicioNoEncontrado(Long id) {
        super("Servicio con ID " + id + " no encontrado.");
    }
}
