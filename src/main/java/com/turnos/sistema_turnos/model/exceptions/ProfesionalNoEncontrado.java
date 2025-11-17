package com.turnos.sistema_turnos.model.exceptions;

public class ProfesionalNoEncontrado extends RuntimeException {
    public ProfesionalNoEncontrado(Long id) {
        super("No se encontró el profesional con id: " + id);
    }
}
