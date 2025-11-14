package com.turnos.sistema_turnos.services;

import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.service.interfaces.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;
    private Cliente damian;

    @BeforeEach
    void setUp() {
        damian = new Cliente( "Damian", "Manchali", "dami@gmail.com", "123456789");
    }
    @Test
    void testCrearUsuario_cuandoDatosSonValidos_debeRetornarUsuarioGuardado() {
        // Given: Preparamos los datos de prueba
        Cliente clienteGuardado = clienteService.crear(damian);

        assertNotNull(clienteGuardado, "El usuario guardado no debería ser nulo");
        assertNotNull(clienteGuardado.getId(), "El usuario guardado debería tener un ID asignado");
        assertEquals("Damian", clienteGuardado.getNombre(), "El nombre del usuario no coincide");
        assertEquals("dami@gmail.com", clienteGuardado.getEmail(), "El email del usuario no coincide");
        assertFalse(clienteGuardado.isActivo(), "El usuario debería crearse como inactivo por defecto");
        assertNotNull(clienteGuardado.getCreated_at(), "La fecha de creación no debería ser nula");
    }
}
