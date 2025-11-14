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
         clienteJPA.setRol(cliente.getRol());

        return clienteJPA;
    }

    @Override
    public Cliente toModel(ClienteJPA clienteJPA) {
        Cliente cliente = new Cliente(clienteJPA.getNombre(), clienteJPA.getApellido(), clienteJPA.getEmail(), clienteJPA.getTel());
        cliente.setId(clienteJPA.getId());
        cliente.setActivo(clienteJPA.isActivo());
        cliente.setRol(clienteJPA.getRol());
        cliente.setCreated_at(clienteJPA.getCreated_at());
        cliente.setUpdate_at(clienteJPA.getUpdate_at());
        return cliente;
    }
}
