package com.desafio.fullstack.tareas.service;

import com.desafio.fullstack.tareas.entity.Tarea;

import java.util.List;

/**
 * The interface Tarea service.
 */
public interface TareaService {

    /**
     * Listar tareas list.
     *
     * @return the list
     */
    public List<Tarea> listarTareas();

    /**
     * Agregar tarea tarea.
     *
     * @param tarea the tarea
     * @return the tarea
     */
    public Tarea agregarTarea(Tarea tarea);

    /**
     * Remover tarea.
     *
     * @param id the id
     */
    public void removerTarea(int id);

    /**
     * Editar tarea tarea.
     *
     * @param tarea the tarea
     * @return the tarea
     */
    public Tarea editarTarea(Tarea tarea);
}
