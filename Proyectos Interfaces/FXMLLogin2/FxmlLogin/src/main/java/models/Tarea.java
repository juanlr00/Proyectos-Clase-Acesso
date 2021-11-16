/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class Tarea implements Serializable {
    
    private Long id;
    private String nombre;
    private String prioridad;
    
    private Usuario usuario;

    public Tarea() {
    }

    public Tarea(Long id, String nombre, String prioridad, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", prioridad=" + prioridad + ", usuario=" + usuario.getUsername() + '}';
    }
        
    
}
