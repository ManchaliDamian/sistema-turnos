package com.turnos.sistema_turnos.service.impl;

import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ClienteRepository;
import com.turnos.sistema_turnos.service.interfaces.ClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.crear(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.actualizar(cliente);
    }

    @Override
    public Optional<Cliente> recuperar(Long cliente_id) {
        return clienteRepository.recuperar(cliente_id);
    }

    @Override
    public void eliminar(Long cliente_id) {
        clienteRepository.eliminar(cliente_id);
    }
}
