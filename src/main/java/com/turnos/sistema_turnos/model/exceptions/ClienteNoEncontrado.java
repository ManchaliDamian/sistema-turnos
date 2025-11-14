package com.turnos.sistema_turnos.model.exceptions;

public class ClienteNoEncontrado extends RuntimeException {
    public ClienteNoEncontrado(Long id) {
        super("Usuario con ID " + id + " no encontrado.");
    }
}
