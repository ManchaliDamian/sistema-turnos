package com.turnos.sistema_turnos.persistencie.repository.impl;

import com.turnos.sistema_turnos.model.exceptions.ClienteNoEncontrado;
import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.persistencie.DAOs.ClienteDAO;
import com.turnos.sistema_turnos.persistencie.entity.ClienteJPA;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ClienteRepository;
import com.turnos.sistema_turnos.persistencie.repository.mappers.interfaces.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteDAO clienteDAO;
    private final ClienteMapper clienteMapper;
    public ClienteRepositoryImpl(ClienteDAO clienteDAO, ClienteMapper clienteMapper) {
        this.clienteDAO = clienteDAO;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        ClienteJPA clienteJPA = clienteMapper.toJPA(cliente);
        clienteJPA = clienteDAO.save(clienteJPA);

        return clienteMapper.toModel(clienteJPA);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        if (cliente.getId() == null || !clienteDAO.existsById(cliente.getId())) {
            throw new ClienteNoEncontrado(cliente.getId());
        }
        return clienteMapper.toModel(clienteDAO.save(clienteMapper.toJPA(cliente)));
    }

    @Override
    public Optional<Cliente> recuperar(Long cliente_id) {
        return clienteDAO.findById(cliente_id).map(clienteMapper::toModel);
    }

    @Override
    public void eliminar(Long cliente_id) {
        clienteDAO.deleteById(cliente_id);
    }
}
