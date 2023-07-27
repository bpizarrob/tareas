package com.desafio.fullstack.tareas.controller;

import com.desafio.fullstack.tareas.entity.Tarea;
import com.desafio.fullstack.tareas.service.impl.TareaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTareaTest {

    // Anotación para inyectar los mocks en el controlador
    @InjectMocks
    private ControllerTarea tareaController;

    // Mock del servicio de Tarea
    @Mock
    private TareaServiceImpl tareaServiceImpl;

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

        // Configure the mock behavior
        when(tareaServiceImpl.listarTareas()).thenReturn(mockedListaTareas);


        // llamar al metodo que esta bajo prueba
        ResponseEntity<?> response = tareaController.consultarTarea();

        // Verificar los resultados
        assertEquals("200 OK", response.getStatusCode().toString());
        List<Tarea> responseTareas = (List<Tarea>) response.getBody();
        assertEquals(mockedListaTareas.size(), responseTareas.size());

    }


}



