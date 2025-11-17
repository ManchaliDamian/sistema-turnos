package com.turnos.sistema_turnos.services;

import com.turnos.sistema_turnos.persistencie.repository.interfaces.ClienteRepository;
import com.turnos.sistema_turnos.persistencie.repository.interfaces.ProfesionalRepository;
import com.turnos.sistema_turnos.service.interfaces.DataService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DataServiceImpl implements DataService {

    private final ClienteRepository clienteRepository;

    public DataServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void eliminarTodo() {
        clienteRepository.deleteAll();
    }
}
