/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 * Esta clase define un objeto Gato, esta clase hereda de la clase Animal.
 * @since 19/06/2017
 * @see Animal
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Gato extends Animal {
    
    private String salidaAnimal = "gato"; //Quizas sea mas facil para que el funcionario haga la busqueda por parametros

    /**
     *Constructor por defecto (vacio)
     */
    public Gato() {
    }

    /**
     *Constructor el cual sera llamado para instanciar un nuevo objeto de la clase Gato.
     * @param color tipo String, color que tiene el animal.
     * @param raza tipo String, raza del animal.
     * @param sexo tipo String, Sexo del animal (Macho - Hembra)
     * @param peso tipo double, peso que tiene el animal al momento de ser ingresado
     * @param edad tipo int, edad del animal.
     * @param castrado tipo boolean, me define si un animal esta castrado o no.
     * @param enfermo tipo boolean, me define si un animal esta enfermo o no.
     * @param codigo tipo int, codigo de referencia que tendra un animal.
     */
    public Gato(String color, String raza, String sexo, double peso, int edad, boolean castrado, boolean enfermo, int codigo) {
        super(color, raza, sexo, peso, edad, castrado, enfermo, codigo);
        super.setSalidaAnimal("gato");
    }

    @Override
    public String getSalidaAnimal() {
        return salidaAnimal;
    }

    @Override
    public void setSalidaAnimal(String salidaAnimal) {
        this.salidaAnimal = salidaAnimal;
    }
    
    
    @Override
    public double calcularGastoAnimales() {
        this.setMesComidaKilo(2.5);

        if (this.getEdad() >= 8) {
            this.setCostoComidaKilo(5);
        } else if (this.getEdad() < 8) {
            this.setCostoComidaKilo(3);
        }

        double gasto = super.calcularGastoAnimales() + 15;
        return gasto;
    }


}
