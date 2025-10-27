package com.turnos.sistema_turnos.services;

import com.turnos.sistema_turnos.model.Usuario;
import com.turnos.sistema_turnos.service.interfaces.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;
    private Usuario damian;

    @BeforeEach
    void setUp() {
        damian = new Usuario( "Damian", "Manchali", "dami@gmail.com", "123456789");
    }
    @Test
    void testCrearUsuario_cuandoDatosSonValidos_debeRetornarUsuarioGuardado() {
        // Given: Preparamos los datos de prueba
        Usuario usuarioGuardado = usuarioService.crear(damian);

        assertNotNull(usuarioGuardado, "El usuario guardado no debería ser nulo");
        assertNotNull(usuarioGuardado.getId(), "El usuario guardado debería tener un ID asignado");
        assertEquals("Damian", usuarioGuardado.getNombre(), "El nombre del usuario no coincide");
        assertEquals("dami@gmail.com", usuarioGuardado.getEmail(), "El email del usuario no coincide");
        assertFalse(usuarioGuardado.isActivo(), "El usuario debería crearse como inactivo por defecto");
        assertNotNull(usuarioGuardado.getCreated_at(), "La fecha de creación no debería ser nula");
    }
}
