package com.turnos.sistema_turnos.model.exceptions;

public class TurnoNoEncontrado extends RuntimeException {
    public TurnoNoEncontrado(Long id) {
        super("No se encontró el turno con id: " + id);
    }
}
