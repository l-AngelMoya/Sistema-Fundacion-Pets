/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

import java.time.LocalDate;

/**
 * Esta clase define un objeto Voluntario.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Voluntario {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private LocalDate fechaInicio;

    /**
     *Constructor por defecto vacio.
     */
    public Voluntario() {
    
    }

    /**
     *Constructor
     * @param nombre tipo String, es el nombre del Voluntario.
     * @param apellido tipo String, es el apellido del Voluntario.
     * @param correo tipo String, es el correo del Voluntario.
     * @param telefono tipo String, es el telefono del Voluntario.
     * @param direccion tipo String, es la direccion del Voluntario.
     * @param fechaInicio tipo LocalDate, es la fecha en la que el Voluntario empieza a ayudar en la fundacion.
     */
    public Voluntario(String nombre, String apellido, String correo, String telefono, String direccion, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaInicio = fechaInicio;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo nombre.
     * @return nombre, tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Metodo que me reemplaza el estado del atributo nombre.
     * @param nombre tipo String, es el nuevo nombre que deseo guardar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo apellido.
     * @return apellido, tipo String.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *Metodo que me reemplaza el estado del atributo apellido.
     * @param apellido tipo String, es el nuevo apellido que deseo guardar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo correo.
     * @return correo, tipo String.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *Metodo que me reemplaza el estado del atributo correo.
     * @param correo tipo String, es el nuevo correo electronico que deseo guardar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo telefono.
     * @return telefono, tipo String.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *Metodo que me reemplaza el estado del atributo telefono.
     * @param telefono tipo String, es el nuevo telefono que deseo guardar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo direccion.
     * @return direccion, tipo String.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *Metodo que me reemplaza el estado del atributo direccion.
     * @param direccion tipo String, es la nueva direccion que deseo guardar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo fechaInicio.
     * @return fechaInicio, tipo LocalDate.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     *Metodo que me reemplaza el estado del atributo fechaInicio.
     * @param fechaInicio tipo LocalDate, es la nueva fecha de  que deseo guardar.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public String toString(){
        return("Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo 
                + ", Telefono: " + telefono + ", Direccion: " + direccion + ", Fecha de inicio: " + fechaInicio);
    }
    
}
