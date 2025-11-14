package com.turnos.sistema_turnos.persistencie.repository.interfaces;

import com.turnos.sistema_turnos.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Cliente crear(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    Optional<Cliente> recuperar(Long cliente_id);
    void eliminar(Long cliente_id);
}
