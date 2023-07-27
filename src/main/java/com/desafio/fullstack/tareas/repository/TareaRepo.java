package com.desafio.fullstack.tareas.repository;

import com.desafio.fullstack.tareas.entity.Tarea;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Tarea repo.
 */
public interface TareaRepo extends CrudRepository<Tarea, Integer> {


}
