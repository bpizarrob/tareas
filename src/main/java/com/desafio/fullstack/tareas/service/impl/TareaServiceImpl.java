package com.desafio.fullstack.tareas.service.impl;

import com.desafio.fullstack.tareas.entity.Tarea;
import com.desafio.fullstack.tareas.repository.TareaRepo;
import com.desafio.fullstack.tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Tarea service.
 */
@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepo repo;

    @Override
    public List<Tarea> listarTareas() {
        return (List<Tarea>) this.repo.findAll();
    }

    @Override
    public Tarea agregarTarea(Tarea tarea) {
        tarea.setDescripcion(tarea.getDescripcion());
        return this.repo.save(tarea);
    }

    @Override
    public void removerTarea(int id) {
        this.repo.deleteById(id);
    }

    @Override
    public Tarea editarTarea(Tarea tarea) {
        return this.repo.save(tarea);
    }
}
