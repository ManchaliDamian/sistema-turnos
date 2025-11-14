package com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces;

import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.persistencie.entity.ClienteJPA;

public interface ClienteMapper {
    ClienteJPA toJPA(Cliente cliente);
    Cliente toModel(ClienteJPA clienteJPA);
}
