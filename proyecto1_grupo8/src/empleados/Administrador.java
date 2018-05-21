/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

import fundacion.Veterinario;
import fundacion.Voluntario;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase define un objeto Administrador que hereda de Empleado
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Administrador extends Empleado{
        
    /**
     *Constructor por defecto vacio.
     */
    public Administrador() {
        
    }

    /**
     *Constructor 
     * @param nombres tipo String, es el nombre del empleado de tipo Administrador.
     * @param apellidos tipo String, es el apellido del empleado de tipo Administrador.
     * @param direccion tipo String, es la direccion del empleado de tipo Administrador.
     * @param telefono tipo String, es el numero de telefono del empleado de tipo Administrador.
     * @param correo tipo String, es el correo electronico del empleado de tipo Administrador.
     * @param fechaInicio tipo LocalDate, es la fecha en la que el empleado de tipo Administrador empezo a laborar con la fundacion.
     * @param sueldo tipo double, es el sueldo del empleado de tipo Administrador.
     * @param privilegio tipo TipoEmpleado, es el tipo del empleado.
     * @param userName tipo String, es el usuario del empleado de tipo Administrador.
     * @param contraseña tipo String, es la contraseña del empleado de tipo Administrador.
     */
    public Administrador(String nombres, String apellidos, String direccion, String telefono, String correo, LocalDate fechaInicio, double sueldo, TipoPrivilegio privilegio, String userName, String contraseña) {
        super(nombres, apellidos, direccion, telefono, correo, fechaInicio, sueldo, privilegio, userName, contraseña);
    }
    
    /**
     * metodo que permite crear a un nuevo objeto del tipo veterinario
     * @param nombre tipo string es el nombre del veterinario
     * @param apellido tipo string es el apellido del veterinario
     * @param direccion tipo string es la direccion del veterinario
     * @param telefono tipo String es el telefono del veterinario
     * @param id tipo string es el tlfn
     * @param correo tipo string es el correo del veterinaario
     * @param sueldoHora tipo double lo que cobre cualquiera de los veterinarios
     * @param horasTabajar las horas que traba ya tiene forma
     * @param vetLista una lista ordenadas de los veterinarios 
     */
    public static void registrarVeterinario(String nombre, String apellido, String direccion, String telefono, String id, String correo, double sueldoHora, int horasTabajar, ArrayList<Veterinario> vetLista){
        Veterinario vet = new Veterinario(id, nombre, apellido, correo, direccion, telefono, sueldoHora, horasTabajar); 
        vetLista.add(vet);
        System.out.println("\nVeterinario registrado con exito.");
    }
    
    /**
     * Método que permite así como en los anteriores crear un nuevo empleado a partir de sus parametros y colocarlo en una actividad
     * @param nombre de tipo String es el nombre del epleado
     * @param apellido del tipo String es el apellido del empleado
     * @param direccion del tipo String es la dirección del empleado
     * @param telefono el tlfn de tipo String
     * @param correo de tipo String es el correo del empleado
     * @param fechaInicio LocalDate de la fecha donde inició a trabajar
     * @param sueldo el salario del cual se descuenta el 10%
     * @param usuario el usuario de quien me hirió no lo se
     * @param contraseña es la contraseña del empleado  del tipo string
     * @param isAdministrador boolean para saber que privilegio tiene el empleado
     * @param privilegio es muy parecido 
     * @param empLista del tipo ArrayList
     */
    public static void registrarEmpleado(String nombre, String apellido, String direccion, String telefono, String correo, LocalDate fechaInicio, double sueldo, String usuario, String contraseña, boolean isAdministrador, TipoPrivilegio privilegio, ArrayList<Empleado> empLista){
        Empleado e = new Empleado(nombre, apellido, direccion, telefono, correo, fechaInicio, sueldo, privilegio, usuario, contraseña);   
        empLista.add(e);
        System.out.println("\nEmpleado registrado con exito.");

    }
    
    /**
   * metodo que permite crear a un voluntario
   * @param nombre tipo string nombre del voluntario
   * @param apellido tipo string apellido del voluntatio
   * @param direccion tipo string direccion del lugar
   * @param telefono tipo string tlfn del observador
   * @param correo tipo string es el correo del voluntario
   * @param fechaInicio localDate de cuando entro a lafundacion
   * @param volLista lista dd los voluntarios
   */
    public static void registrarVoluntario(String nombre, String apellido, String direccion, String telefono, String correo, LocalDate fechaInicio, ArrayList<Voluntario> volLista){
        Voluntario vol = new Voluntario(nombre, apellido, correo, telefono, direccion, fechaInicio);
        volLista.add(vol);
        System.out.println("\nVoluntario registrado con exito.");

    }

}
