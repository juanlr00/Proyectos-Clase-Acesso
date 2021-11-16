/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class Tarea {
    
    private Integer id;
    private String nombre;
    private String prioridad;
    private String responsable;

    public Tarea(String nombre, String prioridad, String responsable) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.responsable = responsable;
    }

    public Tarea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", prioridad=" + prioridad + ", responsable=" + responsable + '}';
    }    
    
}
