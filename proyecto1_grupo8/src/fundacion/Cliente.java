/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

import animal.Animal;
import java.util.ArrayList;

/**
 * Esta clase define un objeto Cliente.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Cliente {
    
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private ArrayList<Animal> animales = new ArrayList<>();

    /**
     *Contructor pro defecto vacio.
     */
    public Cliente() {
        
    }

    /**
     * Constructor
     * @param id tipo String, es el numero de identificacion del cliente.
     * @param nombre tipo String, es el nombre del cliente.
     * @param apellido tipo String, es el apellido del cliente.
     * @param correo tipo String, es el correo electronico del cliente.
     * @param telefono tipo String, es el telefono del cliente.
     * @param direccion tipo String, es la direccion del cliente.
     */
    public Cliente(String id, String nombre, String apellido, String correo, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    /**
     *Metodo que me retorna el estado que posee el atributo Id.
     * @return id, tipo String.
     */
    public String getId() {
        return id;
    }

    /**
     *Metodo que me reemplaza el estado del atributo id.
     * @param id tipo String, es el nuevo id que deseo guardar.
     */
    public void setId(String id) {
        this.id = id;
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
     * @param correo tipo String, es el nuevo correo que deseo guardar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo correo.
     * @return correo, tipo String.
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
     *Metodo que me retorna el estado que posee el atributo animales.
     * @return id, tipo String.
     */
    public ArrayList<Animal> getAnimales() {
        return animales;
    }
    
    @Override
    public String toString(){
        return("ID Cliente: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo 
                + ", Telefono: " + telefono + ", Direccion: " + direccion );
    }    
    
    /**
     *  Metodo que permite imprimir todos los estados de los atributos del Cliente 
     * @return datos de tipo String.
     */
    public String toStringDet(){
        return("ID Cliente: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Numero de animales Adoptados: " + animales.size());
    }    

}
