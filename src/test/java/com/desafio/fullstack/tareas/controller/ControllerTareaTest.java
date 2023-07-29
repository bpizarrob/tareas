package com.desafio.fullstack.tareas.controller;

import com.desafio.fullstack.tareas.entity.Tarea;
import com.desafio.fullstack.tareas.service.impl.TareaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerTareaTest {

    // Anotación para inyectar los mocks en el controlador
    @InjectMocks
    private ControllerTarea tareaController;

    // Mock del servicio de Tarea
    @Mock
    private TareaServiceImpl tareaServiceImpl;

    @Mock
    Tarea tarea;

    @Test
    public void testConsultarTarea() {

        List<Tarea> mockedListaTareas = new ArrayList<>();

        Tarea tarea1 = mock(Tarea.class);
        tarea1.setDescripcion("Tarea 1");
        tarea1.setFecha_creacion("2023-07-26 12:00:00");
        tarea1.setVigente(true);
        mockedListaTareas.add(tarea1);

        Tarea tarea2 = mock(Tarea.class);
        tarea2.setDescripcion("Tarea 2");
        tarea2.setFecha_creacion("2023-07-26 13:00:00");
        tarea2.setVigente(false);
        mockedListaTareas.add(tarea2);

        // Cuando se llame al servicio de listar tareas, simularemos que devuelva el mock creado
        when(tareaServiceImpl.listarTareas()).thenReturn(mockedListaTareas);

        // llamar al metodo que esta bajo prueba
        ResponseEntity<?> response = tareaController.consultarTarea();

        // Verificar los resultados
        assertEquals("200 OK", response.getStatusCode().toString());
        List<Tarea> responseTareas = (List<Tarea>) response.getBody();
        assertEquals(mockedListaTareas.size(), responseTareas.size());

    }

    @Test
    public void testAgregarTarea() {

        Tarea tarea = mock(Tarea.class);

        // Mockear el comportamiento del servicio
        when(tareaServiceImpl.agregarTarea(any(Tarea.class))).thenReturn(tarea);

        // Ejecutar el método del controlador que queremos probar
        ResponseEntity<?> response = tareaController.agregarTarea(tarea);

        // Verificar que se devuelva un código de estado 201
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificar que la tarea devuelta en el cuerpo de la respuesta es la misma que la que se mockeó en el servicio
        assertEquals(tarea, response.getBody());

    }


    @Test
    public void testModificarTarea() {

        Tarea tarea = mock(Tarea.class);

        // Mockear el comportamiento del servicio
        when(tareaServiceImpl.editarTarea(any(Tarea.class))).thenReturn(tarea);

        // Ejecutar el método del controlador que queremos probar
        ResponseEntity<?> response = tareaController.modificarTarea(tarea);

        // Verificar que se devuelva un código de estado 201
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificar que la tarea devuelta en el cuerpo de la respuesta es la misma que la que se mockeó en el servicio
        assertEquals(tarea, response.getBody());

    }

    @Test
    public void testEliminarTarea() {
        int tareaId = 1; // Id de la tarea a eliminar

        // Ejecutar el método del controlador que queremos probar
        ResponseEntity<?> response = tareaController.eliminarTarea(tareaId);

        // Verificar que se devuelva un código de estado 200 (OK)
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar que el método de servicio para remover la tarea fue invocado con el id correcto
        verify(tareaServiceImpl).removerTarea(tareaId);
    }
}



