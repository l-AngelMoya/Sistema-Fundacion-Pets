/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

import animal.Animal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase define un objeto Veterinario.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Veterinario {
    
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private int numeroAnimales; //Cantidad de animales que atiende cada veterinario
    private double sueldoHora;
    private int horasTrabajo;
    private ArrayList<Animal> animalesCuidar; //Lista de animales enfermos por atender por el veterinario
    private ArrayList<Animal> animalesMarcadosSanos; //Lista de animales enfermos que ya fueron atendidos por el veterinario
    
    /**
     *Constructor por defecto vacio
     */
    public Veterinario(){
        
    }

    /**
     *Constructor
     * @param id tipo String, es el numero de identificacion del veterinario.
     * @param nombre tipo String, es el nombre del veterinario.
     * @param apellido tipo String, es el apellido del veterinario.
     * @param correo tipo String, es el correo electronico del veterinario.
     * @param direccion tipo String, es la direccion del veterinario.
     * @param telefono tipo String, es el telefono del veterinario.
     * @param sueldoHora tipo double, es el sueldo por hora del veterinario.
     * @param horasTrabajo tipo int, es las horas de trabajo que tiene un veterinario.
     */
    public Veterinario(String id, String nombre, String apellido, String correo, String direccion, String telefono, double sueldoHora, int horasTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.sueldoHora = sueldoHora;
        this.horasTrabajo = horasTrabajo;
        this.numeroAnimales = 0; //Al iniciar un veterinario este no cuida ningun animal
        animalesCuidar = new ArrayList<>();
        animalesMarcadosSanos = new ArrayList<>();
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
    public void setNombreCompleto(String nombre) {
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
     *Metodo que me retorna el estado que posee el atributo telefono.
     * @return telefono, tipo String.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *Metodo que me reemplaza el estado del atributo telefono.
     * @param telefono tipo String, es el nuevo numero de telefono que deseo guardar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo numeroAnimales.
     * @return numeroAnimales, tipo int.
     */
    public int getNumeroAnimales() {
        return numeroAnimales;
    }

    /**
     *Metodo que me reemplaza el estado del atributo numeroAnimales.
     * @param numeroAnimales tipo int, es la nueva cantidad de animales que deseo guardar.
     */
    public void setNumeroAnimales(int numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo sueldoHora.
     * @return sueldoHora, tipo double.
     */
    public double getSueldoHora() {
        return sueldoHora;
    }

    /**
     *Metodo que me reemplaza el estado del atributo sueldoHora.
     * @param sueldoHora tipo double, es el nuevo sueldo por hora que deseo guardar.
     */
    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo horasTrabajo.
     * @return horasTrabajo, tipo int.
     */
    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    /**
     *Metodo que me reemplaza el estado del atributo horasTrabajo.
     * @param horasTrabajo tipo int, es el nuevo numero de horas que deseo guardar.
     */
    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
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
     * @param direccion tipo String, es la nueva dureccion que deseo guardar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     *Metodo que me retorna el estado que posee el atributo animalesCuidar.
     * @return animalesCuidar, tipo ArrayList.
     */
    public ArrayList<Animal> getAnimalesCuidar() {
        return animalesCuidar;
    }

    /**
     *Metodo que me reemplaza el estado del atributo animalesCuidar.
     * @param animalesCuidar tipo ArrayList, es el nuevo arreglo de animales a cuidar que deseo guardar.
     */
    public void setAnimalesCuidar(ArrayList<Animal> animalesCuidar) {
        this.animalesCuidar = animalesCuidar;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo animalesMarcadosSanos.
     * @return animalesMarcadosSanos, tipo ArrayList.
     */
    public ArrayList<Animal> getAnimalesMarcadosSanos() {
        return animalesMarcadosSanos;
    }

    /**
     *Metodo que me reemplaza el estado del atributo animalesMarcadosSanos.
     * @param animalesMarcadosSanos tipo ArrayList, es el nuevo arreglo de animales sanos que deseo guardar.
     */
    public void setAnimalesMarcadosSanos(ArrayList<Animal> animalesMarcadosSanos) {
        this.animalesMarcadosSanos = animalesMarcadosSanos;
    }
    
    /**
     * Metodo que mostrara el listado de los pacientes, enfermos o ya sanos, de un veterinario.
     */
    public void listadoPacientes(){
        
        ArrayList<Animal> actuales = new ArrayList<>();
        ArrayList<Animal> pasados = new ArrayList<>();
        
        for(Animal paciente: this.animalesCuidar){
            if(paciente.isEnfermo()){
                actuales.add(paciente);
            }
        }
        
        for(Animal pacienteAnterior: this.animalesMarcadosSanos){
            if(pacienteAnterior.isEnfermo() == false){
                pasados.add(pacienteAnterior);
            }
        }
        
        System.out.println("\nPacientes pasados");
        Iterator it = pasados.iterator(); 
        while (it.hasNext()) { 
            Object objeto = it.next(); 
            Animal pasado = (Animal)objeto; 
            System.out.println(pasado); 
        } 
        
        System.out.println("\nPacientes actuales");
        Iterator present = actuales.iterator(); 
        while (present.hasNext()) { 
            Object objeto = present.next(); 
            Animal presente = (Animal)objeto; 
            System.out.println(presente); 
        } 
        
    }
     
    
    @Override
    public String toString(){
        return("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo 
                + ", Telefono: " + telefono + ", Direccion: " + direccion + ", Sueldo por hora: " + sueldoHora 
                + ", Horas de trabajo: " + horasTrabajo + ", Cantidad de animales a cuidar: " + numeroAnimales);
    }
    
    /**
     * Metodo que mostrara solo los datos mas importantes o relevantes del veterinario
     * @return datos importantes
     */
    public String datosPrincipales(){
        return("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Telefono: " + telefono 
                + ", Cantidad de animales a cuidar: " + numeroAnimales);
    }
    
}
