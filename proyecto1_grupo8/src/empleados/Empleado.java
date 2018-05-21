/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase define un objeto Empleado la cual sera la clase padre para la clase Funcionario e Administrador.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Empleado {
    
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private LocalDate fechaInicio;
    private Double sueldo;
    private TipoPrivilegio privilegio; //Cargo del empleado
    private String userName;
    private String contraseña;

    /**
     *Constructor por defecto vacio.
     */
    public Empleado() {
        
    }

    /**
     *Constructor 
     * @param nombres tipo String, es el nombre del empleado.
     * @param apellidos tipo String, es el apellido del empleado.
     * @param direccion tipo String, es la direccion del empleado.
     * @param telefono tipo String, es el numero de telefono del empleador.
     * @param correo tipo String, es el correo electronico del empleado.
     * @param fechaInicio tipo LocalDate, es la fecha en la que el empleadoA empezo a laborar con la fundacion.
     * @param sueldo tipo double, es el sueldo del empleado.
     * @param privilegio tipo TipoEmpleado, es el tipo del empleado.
     * @param userName tipo String, es el usuario del empleado.
     * @param contraseña tipo String, es la contraseña del empleado.
     */
    public Empleado(String nombres, String apellidos, String direccion, String telefono, String correo, LocalDate fechaInicio, double sueldo, TipoPrivilegio privilegio, String userName, String contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.privilegio = privilegio;
        this.userName = userName;
        this.contraseña = contraseña;
    }
    
    /**
     *Metodo que me retorna el estado que posee el atributo nombre.
     * @return nombre, tipo String.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *Metodo que me reemplaza el estado del atributo nombre.
     * @param nombres tipo String, es el nuevo nombre que deseo guardar.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo apellido.
     * @return apellido, tipo String.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *Metodo que me reemplaza el estado del atributo apellido.
     * @param apellidos tipo String, es el nuevo apellido que deseo guardar.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
     *Metodo que me retorna el estado que posee el atributo fechaInicio.
     * @return fechaInicio, tipo LocalDate.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     *Metodo que me reemplaza el estado del atributo fechaInicio.
     * @param fechaInicio tipo LocalDate, es la nueva fecha que deseo guardar.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo sueldo.
     * @return sueldo, tipo double.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     *Metodo que me reemplaza el estado del atributo sueldo.
     * @param sueldo tipo double, es el nuevo sueldo que deseo guardar.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo privilegio.
     * @return privilegio, tipo TipoPrivilegio.
     */
    public TipoPrivilegio getPrivilegio() {
        return privilegio;
    }

    /**
     *Metodo que me reemplaza el estado del atributo privilegio.
     * @param privilegio tipo TipoPrivilegio, es el nuevo privilegio que deseo guardar.
     */
    public void setPrivilegio(TipoPrivilegio privilegio) {
        this.privilegio = privilegio;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo userName.
     * @return userName, tipo String.
     */
    public String getUserName() {
        return userName;
    }

    /**
     *Metodo que me reemplaza el estado del atributo userName.
     * @param userName tipo String, es el nuevo usuario que deseo guardar.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *Metodo que me retorna el estado que posee el atributo contraseña.
     * @return contraseña, tipo String.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     *Metodo que me reemplaza el estado del atributo contraseña.
     * @param contraseña tipo String, es la nueva contraseña que deseo guardar.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    /**
     *Metodo que calcula el sueldo total de todos los empleados.
     * @param empleados tipo ArrayList, contendra objetos de tipo Empleados los cuales seran Administradores o Funcionarios.
     * @return gastosAd, tipo double, retorna el sueldo total de todos los empleados.
     */
    public static double gastosAdministrativos(ArrayList<Empleado> empleados) { 
        double gastosAd = 0;
        for (int i = 0; i < empleados.size(); i++) {
            gastosAd = gastosAd + empleados.get(i).getSueldo();
        }
       return gastosAd;
    }
    
    @Override
    public String toString(){
        return("Nombre: " + nombres + ", Apellidos: " + apellidos + ", Usuario: " + userName 
                + ", Contraseña: " + contraseña + ", Direccion: " + direccion + ", Telefono: " + telefono 
                + ", Correo: " + correo + ", Fecha de inicio: " + fechaInicio + ", Sueldo: " + sueldo 
                + ", Cargo: " + privilegio);
    }
    
}
