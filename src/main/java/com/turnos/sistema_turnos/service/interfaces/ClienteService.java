package com.turnos.sistema_turnos.service.interfaces;

import com.turnos.sistema_turnos.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    Cliente crear(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    Optional<Cliente> recuperar(Long usuario_id);
    void eliminar(Long usuario_id);
}
