/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.time.LocalDate;
import fundacion.Cliente;
import fundacion.Veterinario;

/**
 * Esta clase define un objeto Animal
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Animal {
    
    private LocalDate fechaIngreso;
    private LocalDate fechaAdopcion;
    private String color;
    private String raza;
    private String sexo;
    private double peso;
    private int edad;
    private boolean castrado;
    private boolean enfermo; //Enfermo o no el animal (inicializa con false)
    private boolean adoptado;
    private int codigo; //O numero del perro al ser ingresado
    private double costoComidaKilo; //Valor de la comida de los animales por kilo
    private double mesComidaKilo; //Cantidad de kg de comida mensuales
    private Veterinario veterinario;
    private String salidaAnimal;
    private boolean tieneVeterinario;
    private Cliente cliente;    

    /**
     *Constructor por defecto (vacio) de Animal.
     */
    public Animal() {
    
    }    

    /**
     *Constructor de animal el cual ayudara a crear un objeto con los siguientes estados:
     * @param color tipo String, color que tiene el animal.
     * @param raza tipo String, raza del animal.
     * @param sexo tipo String, Sexo del animal (Macho - Hembra)
     * @param peso tipo double, peso que tiene el animal al momento de ser ingresado
     * @param edad tipo int, edad del animal.
     * @param castrado tipo boolean, me define si un animal esta castrado o no.
     * @param enfermo tipo boolean, me define si un animal esta enfermo o no.
     * @param codigo tipo int, codigo de referencia que tendra un animal.
     */
    public Animal(String color, String raza, String sexo, double peso, int edad, boolean castrado, boolean enfermo, int codigo) {
        this.fechaIngreso = LocalDate.now();
        this.fechaAdopcion=null;
        this.color = color;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.castrado = castrado;
        this.enfermo = enfermo;
        this.codigo = codigo;
        this.adoptado = false; //Al ingresar el animal al sistema este no estara adoptado
        this.tieneVeterinario = false; //Al ingresar el animal al sistema este aun no tiene una cita con un veterinario
        cliente=null;
    }

    /**
     *Metodo que me permite obtener la fecha de ingreso de un animal.
     * @return FechaIngreso, tipo LocalDate.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     *Metodo que remplaza el valor del el atributo FechaIngreso.
     * @param fechaIngreso, tipo LocalDate, sera la nueva fecha que reemplazara a la anterior.
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     *metodo que me permite obtener el color de un animal.
     * @return Color, tipo String, tiene el estado del color de un animal.
     */
    public String getColor() {
        return color;
    }

    /**
     *Metodo que reemplaza el valor del atributo Color
     * @param color tipo String, sera el nuevo color que reemplazara a la anterior.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *metodo que me permite obtener la raza de un animal.
     * @return Raza, tipo String, tiene el estado de la raza de un animal.
     */
    public String getRaza() {
        return raza;
    }

    /**
     *Metodo que reemplaza el valor del atributo raza
     * @param raza tipo String, sera la nuevo raza que remplazara a la anterior.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

     /**
     *metodo que me permite obtener el sexo de un animal.
     * @return Sexo, tipo String, tiene el estado del sexo de un animal.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *Metodo que reemplaza el valor del atributo sexo.
     * @param sexo tipo String, sera el nuevo sexo que reemplazara a la anterior.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

     /**
     *metodo que me permite obtener el peso de un animal.
     * @return Peso, tipo String, tiene el estado del peso de un animal.
     */
    public double getPeso() {
        return peso;
    }

    /**
     *Metodo que reemplaza el valor del atributo peso.
     * @param peso tipo doubloe, sera el nuevo peso que reemplazara a la anterior.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

     /**
     *metodo que me permite obtener la edad de un animal.
     * @return Edad, tipo String, tiene el estado de la edad de un animal.
     */
    public int getEdad() {
        return edad;
    }

    /**
     *Metodo que reemplaza el valor del atributo edad
     * @param edad tipo int, sera la nuevo edad que reemplazara a la anterior.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

     /**
     *metodo que me permite saber si un animal esta castrado o no.
     * @return Castrado, tipo boolean.
     */
    public boolean isCastrado() {
        return castrado;
    }

    /**
     *Metodo que reemplaza el valor del atributo castrado
     * @param castrado tipo boolean, sera la nuevo castrado que reemplazara a la anterior.
     */
    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    /**
     *metodo que me permite saber si un animal esta enfermo o no.
     * @return Castrado, tipo boolean.
     */
    public boolean isEnfermo() {
        return enfermo;
    }

    /**
     *Metodo que reemplaza el valor del atributo enfermo.
     * @param enfermo tipo boolean, sera el nuevo estado de enfermo que reemplazara a la anterior.
     */
    public void setEnfermo(boolean enfermo) {
        this.enfermo = enfermo;
    }

     /**
     *metodo que me permite obtener el codigo de un animal.
     * @return codigo, tipo int, tiene el estado del codigo de un animal.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *Metodo que reemplaza el valor del atributo codigo
     * @param codigo tipo int, sera el nuevo codigo que remplazara a la anterior.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

     /**
     *metodo que me permite obtener el costo de comida por kilo de un animal.
     * @return costoComidaKilo, tipo double , tiene el estado del costo por comida de un animal.
     */
    public double getCostoComidaKilo() {
        return costoComidaKilo;
    }

    /**
     *Metodo que reemplaza el valor del atributo costoComidaKilo
     * @param costoComidaKilo tipo double, sera el nuevo costo que remplazara a la anterior.
     */
    public void setCostoComidaKilo(double costoComidaKilo) {
        this.costoComidaKilo = costoComidaKilo;
    }

     /**
     *metodo que me permite obtener el costo de comida al mes de un animal.
     * @return MesComidaKilo, tipo double, tiene el estado del costo por comida al mes de un animal.
     */
    public double getMesComidaKilo() {
        return mesComidaKilo;
    }

    /**
     *metodo que me permite obtener el costo de comida al mes de un animal.
     */
    public void setMesComidaKilo(double mesComidaKilo) {
        this.mesComidaKilo = mesComidaKilo;
    }
    
    /**
     *Metodo que inicializa los gastos en 0
     * @return gastos, tipo double que contendra el valor 0.
     */
    public double gastosAnimales() {        
        double gastos = 0;        
        return gastos;
    }

    /**
     *metodo que me permite saber si un animal esta adoptado o no.
     * @return isAdoptado, tipo boolean.
     */
    public boolean isAdoptado() {
        return adoptado;
    }

    /**
     *Metodo que reemplaza el valor del atributo adoptado.
     * @param adoptado tipo boolean, sera el nuevo estado de adoptado que reemplazara a la anterior.
     */
    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    /**
     *metodo que me permite obtener el tipo de animal de un animal.
     * @return salidaAnimal, tipo String, tiene un tipo(Perro-Gato) de animal
     */
    public String getSalidaAnimal() {
        return salidaAnimal;
    }

    /**
     *metodo que me reemplaza el valor del atributo salidaAnimal
     * @param salidaAnimal, tipo String.
     */
    public void setSalidaAnimal(String salidaAnimal) {
        this.salidaAnimal = salidaAnimal;
    }
    
    /**
     *metodo que me permite saber si un animal tiene veterinario o no.
     * @return isAdoptado, tipo boolean.
     */
    public boolean isTieneVeterinario() {
        return tieneVeterinario;
    }

    /**
     *metodo que me reemplaza el valor del atributo tieneVeterinario
     * @param tieneVeterinario, tipo boolean, puede tomar 1 si efectivamente tiene un veterinario y 0 si no lo tiene. 
     */
    public void setTieneVeterinario(boolean tieneVeterinario) {
        this.tieneVeterinario = tieneVeterinario;
    }

    /**
     *Metodo que me permite obtener un objeto de tipo veterinario.
     * @return veterinario, tipo Veterinario,  
     */
    public Veterinario getVeterinario() {
        return veterinario;
    }

    /**
     *metodo que reemplaza el valor del atributo veterinario.
     * @param veterinario tipo Veteinario, puedo tomar cualquier objeto que sea de tipo veterinario
     * y pasarlo como parametro.
     */
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    /**
     *Metodo que me permite obtener un objeto de tipo cliente.
     * @return cliente, tipo Cliente, retorna un cliente el cual ya estara instanciado.  
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *metodo que reemplaza el valor del atributo cliente.
     * @param cliente tipo Cliente, puedo tomar cualquier objeto que sea de tipo Cliente
     * y pasarlo como parametro.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *Metodo que me permite obtener un objeto de tipo LocalDate.
     * @return fechaAdopcion, tipo LocalDate, retorna la fecha de adopcion de un animal que haya
     * sido adoptado.
     */
    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    /**
     *mtodo que reemplaza el valor del atributo fechaAdopcion.
     * @param fechaAdopcion tipo LocalDate, puedo tomar cualquier objeto que sea de tipo LocalDate
     * y pasarlo como parametro para el efectivo reemplazo.
     */
    public void setFechaAdopcion(LocalDate fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
    
    /**
     * Calcula los gastos al mes de un animal.
     * @return el gasto
     */
    public double calcularGastoAnimales(){
        
        double gasto = this.costoComidaKilo*this.mesComidaKilo;
        return gasto;
    }
    
    /**
     *Metodo que me convierte un booleano y a un string. 
     * @param b tipo boolean, es el valor que se transformara a un String.
     * @return mensaje, toma el booleano y segun eso lo hace si o no.
     */
    public String ConvertirBoolean(boolean b){
        String mensaje;
        if(b==true){
            mensaje="Si";
        }else{
            mensaje="No";
        }
        return mensaje;
    }
    
    @Override
    public String toString(){
        return("Tipo animal: " + salidaAnimal + ", Codigo resgistro: " + codigo + ", Fecha de ingreso: " + fechaIngreso 
                + ", Color: " + color + ", Raza: " + raza + ", Sexo: " + sexo + ", Peso: " + peso + ", Edad: " + edad 
                + ", Castrado: " + ConvertirBoolean(castrado) + ", Enfermo: " + ConvertirBoolean(enfermo) + ", ¿Esta adoptado? " + ConvertirBoolean(adoptado));
    }  
    public String toStringDet(){
        return("Tipo animal: " + salidaAnimal + ", Codigo resgistro: " + codigo+", Sexo: " + sexo + ", Fecha de ingreso: " + fechaIngreso + ", Fecha adopcion: " + fechaAdopcion);
    }  
    
}
