package com.turnos.sistema_turnos.services;

import com.turnos.sistema_turnos.model.Cliente;
import com.turnos.sistema_turnos.service.interfaces.ClienteService;
import com.turnos.sistema_turnos.service.interfaces.DataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private DataService dataService;
    private Cliente damian;

    @BeforeEach
    void setUp() {
        damian = new Cliente( "Damian", "Manchali", "dami@gmail.com", "123456789");
        damian = clienteService.crear(damian);
    }
    @Test
    void testCrearUsuario_cuandoDatosSonValidos_debeRetornarUsuarioGuardado() {
        // When: Ejecutamos la acción a probar


        // Then: Verificamos los resultados
        assertNotNull(damian, "El usuario guardado no debería ser nulo");
        assertNotNull(damian.getId(), "El usuario guardado debería tener un ID asignado");
        assertEquals("Damian", damian.getNombre(), "El nombre del usuario no coincide");
        assertEquals("dami@gmail.com", damian.getEmail(), "El email del usuario no coincide");
        assertTrue(damian.isActivo(), "El usuario debería crearse como activo por defecto");
    }

    @Test
    void testObtenerPorId_cuandoIdExiste_debeRetornarCliente() {
        // Given: Un cliente ya guardado en la BD

        // When: Buscamos el cliente por su ID
        Optional<Cliente> clienteRecuperadoOpt = clienteService.recuperar(damian.getId());

        // Then: Verificamos que el cliente fue encontrado y sus datos son correctos
        assertTrue(clienteRecuperadoOpt.isPresent(), "Se debería encontrar un cliente con el ID proporcionado");
        Cliente clienteRecuperado = clienteRecuperadoOpt.get();
        assertEquals(damian.getId(), clienteRecuperado.getId());
        assertEquals("Damian", clienteRecuperado.getNombre());
    }

    @Test
    void testObtenerPorId_cuandoIdNoExiste_debeRetornarOptionalVacio() {
        // When: Buscamos un cliente con un ID que no existe
        Optional<Cliente> clienteRecuperadoOpt = clienteService.recuperar(999L);

        // Then: Verificamos que el Optional está vacío
        assertFalse(clienteRecuperadoOpt.isPresent(), "No se debería encontrar un cliente con un ID inexistente");
    }

    @Test
    void testActualizarCliente_cuandoDatosSonValidos_debeRetornarClienteActualizado() {
        // Given: Un cliente guardado
        // When: Modificamos sus datos y llamamos a actualizar
        damian.setApellido("Manchali Actualizado");
        damian.setTel("987654321");
        Cliente clienteActualizado = clienteService.actualizar(damian);

        // Then: Verificamos que los datos se actualizaron correctamente
        assertNotNull(clienteActualizado);
        assertEquals("Manchali Actualizado", clienteActualizado.getApellido());
        assertEquals("987654321", clienteActualizado.getTel());
    }

    @Test
    void testEliminarCliente_cuandoIdExiste_debeEliminarloCorrectamente() {
        // Given: Un cliente guardado

        // When: Eliminamos el cliente
        clienteService.eliminar(damian.getId());

        // Then: Verificamos que ya no se puede recuperar
        Optional<Cliente> clienteRecuperadoOpt = clienteService.recuperar(damian.getId());
        assertFalse(clienteRecuperadoOpt.isPresent(), "El cliente debería haber sido eliminado");
    }
    @AfterEach
    void cleanup() {
        dataService.eliminarTodo();
    }
}
