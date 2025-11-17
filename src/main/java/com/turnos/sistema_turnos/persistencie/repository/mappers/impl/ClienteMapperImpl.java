package com.turnos.sistema_turnos.persistencie.repository.mappers.impl;

import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.persistencie.entity.ClienteJPA;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ClienteMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {
    @Override
    public ClienteJPA toJPA(Cliente cliente) {
         ClienteJPA clienteJPA = new ClienteJPA(cliente.getNombre(), cliente.getApellido(), cliente.getEmail(), cliente.getTel());
         clienteJPA.setActivo(cliente.isActivo());
        clienteJPA.setId(cliente.getId());

        return clienteJPA;
    }

    @Override
    public Cliente toModel(ClienteJPA clienteJPA) {
        Cliente cliente = new Cliente(clienteJPA.getNombre(), clienteJPA.getApellido(), clienteJPA.getEmail(), clienteJPA.getTel());
        cliente.setId(clienteJPA.getId());
        cliente.setActivo(clienteJPA.isActivo());
        return cliente;
    }
}
