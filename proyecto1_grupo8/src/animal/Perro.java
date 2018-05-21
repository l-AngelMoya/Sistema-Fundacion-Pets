/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.time.LocalDate;

/**
 * Esta clase define un objeto perro y extinede de Animal.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Perro extends Animal{
    
    private Tamano tamano;
    
    /**
     *Constructor por defecto vacio.
     */
    public Perro() {
        
    }

    /**
     *Constructor 
     * @param tamano tipo Tamaño, tamaño que va a tener unicamente los perros.
     * @param color tipo String, color que tiene el animal.
     * @param raza tipo String, raza del animal.
     * @param sexo tipo String, Sexo del animal (Macho - Hembra)
     * @param peso tipo double, peso que tiene el animal al momento de ser ingresado
     * @param edad tipo int, edad del animal.
     * @param castrado tipo boolean, me define si un animal esta castrado o no.
     * @param enfermo tipo boolean, me define si un animal esta enfermo o no.
     * @param codigo tipo int, codigo de referencia que tendra un animal.
     */
    public Perro(Tamano tamano, String color, String raza, String sexo, double peso, int edad, boolean castrado, boolean enfermo, int codigo) {
        super(color, raza, sexo, peso, edad, castrado, enfermo, codigo);
        super.setSalidaAnimal("perro");
        this.tamano = tamano;
    }

    /**
     * Metodo que me retorna el tamaño actual de un obejeto.
     * @return tamano tipo Tamano, enumtipe.
     */
    public Tamano getTamano() {
        return tamano;
    }

    /**
     *metodo que reemplaza la la variable tamano por una nueva variable tamaño
     * @param tamano tipo EnumTipe. El tipo solo puede ser pequeño, grande, mediano.
     */
    public void setTamaño(Tamano tamano) {
        this.tamano = tamano;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", Tamaño: " + tamano;
    }
    
    @Override
    public double calcularGastoAnimales() {

        int costoVet = 25;

        if (null != this.tamano) {
            switch (this.tamano) {
                case GRANDE:
                    this.setCostoComidaKilo(4);
                    this.setMesComidaKilo(10);
                    costoVet = 30;
                    break;
                case MEDIANO:
                    this.setCostoComidaKilo(5);
                    this.setMesComidaKilo(6);
                    costoVet = 25;
                    break;
                case PEQUEÑO:
                    this.setCostoComidaKilo(5);
                    this.setMesComidaKilo(4);
                    costoVet = 25;
                    break;
                default:
                    break;
            }
        }

        double gasto = super.calcularGastoAnimales() + costoVet;

        return gasto;
    }
    
}
