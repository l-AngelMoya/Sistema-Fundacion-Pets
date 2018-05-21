/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author Joseph
 */
public class Elefante extends Animal {
    public Elefante(String color, String raza, String sexo, double peso, int edad, boolean castrado, boolean enfermo, int codigo){
        super(color, raza, sexo, 0, 0, true, true, 0);
        super.setSalidaAnimal("Elefante");
    }
    
    
}
