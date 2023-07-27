package com.desafio.fullstack.tareas.controller;

import com.desafio.fullstack.tareas.entity.Tarea;
import com.desafio.fullstack.tareas.service.impl.TareaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Controller tarea.
 */
@RestController
@RequestMapping("tareas")
public class ControllerTarea {

    @Autowired
    private TareaServiceImpl tareaServiceImpl;

    /**
     * Consultar tarea response entity.
     *
     * @return the response entity
     */
    @GetMapping
    @RequestMapping(value = "consultar", method = RequestMethod.GET)
    public ResponseEntity<?> consultarTarea(){
        List<Tarea> listaTareas = this.tareaServiceImpl.listarTareas();
        return ResponseEntity.ok(listaTareas);
    }

    /**
     * Agregar tarea response entity.
     *
     * @param tarea the tarea
     * @return the response entity
     */
    @PostMapping
    @RequestMapping(value = "agregar", method = RequestMethod.POST)
    public ResponseEntity<?> agregarTarea(@Valid  @RequestBody Tarea tarea) {

        Tarea crearTarea = this.tareaServiceImpl.agregarTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearTarea);
    }

    /**
     * Modificar tarea response entity.
     *
     * @param tarea the tarea
     * @return the response entity
     */
    @PutMapping
    @RequestMapping(value = "modificar", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarTarea(@Valid @RequestBody Tarea tarea) {

        Tarea modificarTarea = this.tareaServiceImpl.editarTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(modificarTarea);
    }

    /**
     * Eliminar tarea response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping
    @RequestMapping(value = "eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarTarea(@PathVariable int id) {
        this.tareaServiceImpl.removerTarea(id);
        return ResponseEntity.ok().build();
    }
}
