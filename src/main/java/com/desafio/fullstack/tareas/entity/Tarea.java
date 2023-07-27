package com.desafio.fullstack.tareas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The type Tarea.
 */
@Entity
@Table(name="tarea")
@Setter
@Getter
public class Tarea {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "identificador")
    private int identificador;

    @Column(name = "descripcion")
    @NotNull(message = "Campo 'descripcion' no debe ser nula.")
    @NotBlank(message = "Campo 'descripcion' en blanco.")
    private String descripcion;

    @Column(name = "fecha_creacion")
    @NotNull(message = "Campo 'fecha_creacion' no debe ser nula.")
    @NotBlank(message = "Campo 'fecha_creacion' en blanco.")
    private String fecha_creacion;

    @Column(name = "vigente")
    @NotNull(message = "Campo 'vigente' no debe ser nulo.")
    private boolean vigente;
}
