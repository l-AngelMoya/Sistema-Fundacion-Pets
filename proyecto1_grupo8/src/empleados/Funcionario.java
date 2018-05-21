/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

import fundacion.Veterinario;
import fundacion.Cliente;
import animal.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase define un objeto funcionario.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Funcionario extends Empleado{
    
    /**
     *Contructor por defecto vacio.
     */
    public Funcionario() { 
        
    }

    /**
     *Constructor 
     * @param nombres tipo String, es el nombre del empleado de tipo Funcionario.
     * @param apellidos tipo String, es el apellido del empleado de tipo Funcionario.
     * @param direccion tipo String, es la direccion del empleado de tipo Funcionario.
     * @param telefono tipo String, es el numero de telefono del empleado de tipo Funcionario.
     * @param correo tipo String, es el correo electronico del empleado de tipo Funcionario.
     * @param fechaInicio tipo LocalDate, es la fecha en la que el empleado de tipo Funcionario empezo a laborar con la fundacion.
     * @param sueldo tipo double, es el sueldo del empleado de tipo Funcionario.
     * @param privilegio tipo TipoEmpleado, es el tipo del empleado.
     * @param userName tipo String, es el usuario del empleado de tipo Funcionario.
     * @param contraseña tipo String, es la contraseña del empleado de tipo Funcionario.
     */
    public Funcionario(String nombres, String apellidos, String direccion, String telefono, String correo, LocalDate fechaInicio, Double sueldo, TipoPrivilegio privilegio, String userName, String contraseña) {
        super(nombres, apellidos, direccion, telefono, correo, fechaInicio, sueldo, privilegio, userName, contraseña);
    }
    
    /**
     *Metodo que me permite ingresar un animal en una lista de animales.
     * @param animal tipo Animal,es una referencia a un animal en la funcacion.
     * @param animalLista tipo ArrayList,es una lista que almacenara animales.
     */
    public static void ingresoAnimal(Animal animal, ArrayList<Animal> animalLista){
        animalLista.add(animal);
    }
    
    /**
     * Crea una cita con el veterinario cuando el animal aparece como enfermo
     * @param animal el animal al que se cita con el veterinario
     * @param codigoAnimal el codigo de tipo int del animal
     * @param vet el veterinario al que se le asignará el animal
     * @param codigoVeterinario el codigo del veterinario de tipo String
     */
    public static void crearCita(ArrayList<Animal> animal, int codigoAnimal, ArrayList<Veterinario> vet, String codigoVeterinario) {
        boolean bandera = false;  
        for (int i = 0; i < vet.size(); i++) {            
            for (int j = 0; j < animal.size(); j++) {                
                if (codigoVeterinario.equals(vet.get(i).getId()) && codigoAnimal == animal.get(j).getCodigo() && animal.get(j).isTieneVeterinario() == false && animal.get(j).isAdoptado() == false && animal.get(j).isEnfermo() == true) {    
                    vet.get(i).getAnimalesCuidar().add(animal.get(j));
                    vet.get(i).setNumeroAnimales(vet.get(i).getNumeroAnimales() + 1);
                    animal.get(j).setTieneVeterinario(true);
                    System.out.println("\nEl animal ha sido asignado a un veterinario exitosamente."); 
                    bandera = true;
                }
            }
        }  
        
        if (bandera == false) {
            System.out.println("\nLas identificaciones ingresadas fueron incorrectas.");
        }
        
    }
    
    /**
     * cambia el estado de enfermo después de haber sido llevado al veterinario
     * y se cambia su atributo de poseer veterinario a falso
     *
     * @param animal el animal que originalmente estaba enfermo
     * @param codigoAnimal el codigo de animal que se sanó
     * @param vet el veterinario que curo al animal
     */
    public static void marcarSano(ArrayList<Animal> animal, int codigoAnimal, ArrayList<Veterinario> vet) {
        boolean bandera = false;        
        for (int i = 0; i < vet.size(); i++) {
            for (int j = 0; j < animal.size(); j++) {
                if (codigoAnimal == animal.get(j).getCodigo() && vet.get(i).getAnimalesCuidar().contains(animal.get(j)) == true) {
                    vet.get(i).getAnimalesCuidar().remove(animal.get(j));
                    vet.get(i).getAnimalesMarcadosSanos().add(animal.get(j));
                    vet.get(i).setNumeroAnimales(vet.get(i).getNumeroAnimales() - 1);
                    animal.get(j).setTieneVeterinario(false);
                    animal.get(j).setEnfermo(false);
                    System.out.println("\nEl animal ahora se encuentra sano.");
                    bandera = true;
                } 
            }
        }
        
        if (bandera == false) {
            System.out.println("\nEl codigo ingresado es incorrecto.");
        }
    }

    /**
     * Método que permite el proceso de adopción, cambio el estado del perro a adoptado y lo retira
     * del conjunto de animales actuales dentro de la fundación
     * @param codigoAnimal el codigo del animal que se va a adoptar
     * @param cliente el cliente que recibirá al animal
     * @param animal el animal que se entregará
     * @param clienteLista el conjunto de clientes disponibles, en caso de que no hallan se permitirá
     * crear uno nuevo
     * @param animalesAdoptados el conjunto de animales ya adoptados
     */
    public static void adoptar(int codigoAnimal, Cliente cliente, ArrayList<Animal> animal, ArrayList<Cliente> clienteLista, ArrayList<Animal> animalesAdoptados) {
        boolean bandera = false;
        for (int i = 0; i < animal.size(); i++) {
            if (codigoAnimal == animal.get(i).getCodigo() && animal.get(i).isEnfermo() == false && animal.get(i).isAdoptado() == false) {
                Animal animal1 = animal.get(i);
                animal1.setAdoptado(true);
                if (registroPrevio(cliente.getId(), clienteLista)) { //si el cliente ya existe no lo agrega a la lista de clientes.
                    clienteLista.add(cliente);
                }
                animalesAdoptados.add(animal.get(i));
                animal.get(i).setCliente(cliente);
                animal.get(i).setFechaAdopcion(LocalDate.now());
                for (int k = 0; k < clienteLista.size(); k++) {
                    if (cliente.getId().equals(clienteLista.get(k).getId())) {
                        clienteLista.get(k).getAnimales().add(animal.get(i));
                    }
                }

                bandera = true;
            }

        }

        if (bandera == false) {
            System.out.println("\nEl codigo ingresado es invalido.");
        } 

    }

    /**
     * Metodo que verifica si un cliente ya esta registrado debido a un registro previo.
     * @param id tipo String, es el numero de identificacion del cliente.
     * @param clienteLista tipo ArrayList, es una lista que almacenara a todos los clientes al momento de adoptar.
     * @return estado tipo boolean, falso si el cliente ya existe en los registros, true si el cliente no existe en los registros.
     */
    private static boolean registroPrevio(String id,ArrayList<Cliente> clienteLista){ //Persona que ya ha adopato un animal
        boolean estado=true;
        for(int j=0; j<clienteLista.size();j++){
            if(id.equalsIgnoreCase(clienteLista.get(j).getId())){
                estado=false;
            }
        }
        return(estado);
    }
   
    /**
     * Muestra solo a los animales que ya han sido adoptados
     * @param animalAdoptado el  animal que pertenecio a la fundación
     * @param codigoAnimal el codigo del animal adoptado que permitirá su búsqueda
     */
    public static void filtrarAdoptados(ArrayList<Animal> animalAdoptado, int codigoAnimal) {
        for (int i = 0; i < animalAdoptado.size(); i++) {
            if (codigoAnimal == animalAdoptado.get(i).getCodigo()) {
                System.out.println("");
                System.out.println("La fecha de adopcion fue: " + animalAdoptado.get(i).getFechaAdopcion());
                System.out.println("El dueño actual es: " + animalAdoptado.get(i).getCliente());
                System.out.println("Datos completos del animal: " + animalAdoptado.get(i));
            }
        }
    }
    
    /**
     * Permite hallar un veterinario mediante su codigo dentro de un conjunto de
     * otros veterinarios
     * @param codigoVeterinario el codigo oon el que se lo diferenciará de los demás
     * @param vetLista el conjunto de veterinarios dentro de la fundación
     */
    public static void consultarVeterinario(String codigoVeterinario, ArrayList<Veterinario> vetLista) {

        boolean bandera = false;

        for (Veterinario vet : vetLista) {
            if (vet.getId().equals(codigoVeterinario)) {
                System.out.println(vet);
                vet.listadoPacientes();
                bandera = true;
            } 
        }
        
        if (bandera == false) {
            System.out.println("\nNo se hallaron datos del veterinario");
        }
    }
    
    /**
     * Ordena a los animales mediante un Bubble sort según su fecha de ingreso
     * @param animal un ArrayList de animales
     * @return a la lista de animales ordenadas por fecha de ingreso
     */
    public static ArrayList<Animal> filtrarFechaIngreso(ArrayList<Animal> animal) {

        Animal ani;
        for (int i = 0; i < (animal.size() - 1); i++) {
            int min = i;
            for (int j = i + 1; j < animal.size(); j++) {
                if (animal.get(min).getFechaIngreso().isBefore(animal.get(j).getFechaIngreso())) {
                    min = j;
                }
            }
            ani = animal.get(i);
            animal.set(i, animal.get(min));
            animal.set(min, ani);
        }

        for (Animal a : animal) {
            System.out.println(a);
        }
        
        return animal;

    }
    
    /**
     Ordena por fechas a los animales por la fecha de adopcion
     * @param animal el ArrayList de objetos Animal
     * @return el ArrayList con los animales ordenados por fecha de adopcion
     */
    public static ArrayList<Animal> filtrarFechaAdopcion(ArrayList<Animal> animal) {

        Animal ani;
        for (int i = 0; i < (animal.size() - 1); i++) {
            int min = i;
            for (int j = i + 1; j < animal.size(); j++) {
                if (animal.get(min).getFechaAdopcion().isBefore(animal.get(j).getFechaAdopcion())) {
                    min = j;
                }
            }
            ani = animal.get(i);
            animal.set(i, animal.get(min));
            animal.set(min, ani);
        }

        for (Animal a : animal) {
            System.out.println(a.toStringDet());
        }
        
        return animal;

    }
    
    /**
     * Filtra por el tipo de animal que se muestra
     * @param tipo parametro de tipo string que representa si el animal es perro o gato
     * @param animal la lista de animales que posee la fundación
     * @return una lista con solo los nimales del mismo tipo que el solicitado
     */
    public static ArrayList<Animal> filtrarTipo(String tipo, ArrayList<Animal> animal){
        ArrayList<Animal> anim = new ArrayList<>();
        
        for(Animal animales: animal){
            if((animales instanceof Gato) && tipo.contains("G")){
                anim.add(animales);
            }else if ((tipo.contains("P")&& (animales instanceof Perro))) {
                anim.add(animales);
            } 
        }
        for(Animal animalesEntrego: anim){
            System.out.println(animalesEntrego);
        }
        return anim;
    }
    
    /**
     * filtra un conjunto de animales solo por su sexo
     * @param sexo de tipo string es macho o hemmbra  
     * @param animal la lista de animales que posee la fundación
     * @return un ArrayList de animales que tienen el mismo género
     */
    public static ArrayList<Animal> filtrarSexo(String sexo, ArrayList<Animal>animal){
        ArrayList<Animal> animH = new ArrayList<>();
        ArrayList<Animal> animM = new ArrayList<>();
        ArrayList<Animal> animR = new ArrayList<>();
        
        for(Animal animales: animal){
            if(animales.getSexo().startsWith("m")||animales.getSexo().startsWith("M")){
                animM.add(animales);
            }else if(animales.getSexo().startsWith("h")||animales.getSexo().startsWith("H")){
                animH.add(animales);
            }
            
            }
        if(sexo.startsWith("M")){
            
            for(Animal ani: animM){
            System.out.println(ani);
                
        }animR = animM;     
        }else if(sexo.startsWith("H")){
            for(Animal ani:animH){
            System.out.println(ani);
            }
            animR = animH;
        }
        return animR;
     }
    
    /**
     * Filtra a los animales de la fundación por la raza que tenga el animal, según
     * su especie
     * @param raza de tipo String es el nombre de la raza del animal que se busca
     * @param animal ArrayList de animales de donde se hara el filtro
     * @return un ArrayList de animales de la misma raza
     */
    public static ArrayList<Animal> filtrarRaza(String raza, ArrayList<Animal> animal) {
        ArrayList<Animal> anim = new ArrayList<>();
        
        boolean bandera = false;
        for (Animal animales : animal) {
            if (animales.getRaza().equalsIgnoreCase(raza)) {
                anim.add(animales);
                System.out.println(animales);
                bandera = true;
            }
        }
        
        if (bandera == false) {
            System.out.println("\nNo existe ninguna animal con dicha raza.");        
        }

        return anim;
    }
    
    /**
     * Filtra a unicamente a los perros por tamaño
     * @param tamano de tipo Tamano
     * @param animal ArrayList de tipo Animal de donde se realizará la búsqueda
     */
    public static void filtrarPerros(Tamano tamano, ArrayList<Animal> animal){
        ArrayList<Animal> anim = new ArrayList<>();
        
        for(Animal animales: animal){
            if(animales instanceof Perro){
                Perro perro = (Perro) animales;
               if(perro.getTamano().equals(tamano)){
                anim.add(perro); 
            }
            
            }
        }
        for(Animal animales: anim){
            System.out.println(animales);
        }
    }

    
}
