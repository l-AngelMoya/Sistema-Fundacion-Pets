/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

import empleados.Administrador;
import empleados.TipoPrivilegio;
import empleados.Funcionario;
import empleados.Empleado;
import animal.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase fundacion la cual es la clase principal del sistema, se encarga de hacer que los objetos intactuen entre si.
 * y contendra al metodo main.
 * @since 19/06/2017
 * @author Carolina Burgos, Angel Moya, Manuel Lecaro
 * @version 1.0
 */
public class Fundacion {

    private static ArrayList<Animal> animalesFundacion;
    private static ArrayList<Animal> animalesAdoptados;
    private static ArrayList<Empleado> empleados;
    private static ArrayList<Cliente> clientesActivos;
    private static ArrayList<Voluntario> voluntarios;
    private static ArrayList<Veterinario> veterinarios;
    private static Scanner sc;

    /**
     *Metodo constructor por default, el cual instancia a los atributos de la clase Fundacion
     */
     
    public Fundacion() {
        this.sc = new Scanner(System.in);

        animalesFundacion = new ArrayList<>(80);
        animalesAdoptados = new ArrayList<>();
        clientesActivos = new ArrayList<>();
        empleados = new ArrayList<>();
        veterinarios = new ArrayList<>();
        voluntarios = new ArrayList<>();
        inicializarSistema();
    }

    /**
     * Metodo main que se encarga de que las clases interactuen entre si.
     * Este metodo es el primero que se ejecutara al correr el programa.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fundacion fundacion = new Fundacion();
        String usuario = "";
        String password = "";
        
        for (int i = 0; i < empleados.size(); i++) {
            do {
                usuario = validarString("Ingrese su usuario: ");
                password = validarString("Ingrese su contraseña: ");

                fundacion.ingresoSistema(usuario, password);

            } while (!empleados.get(i).getUserName().equalsIgnoreCase(usuario) && !empleados.get(i).getContraseña().equalsIgnoreCase(password));
        }
    }

    /**
     * Metodo que permite el ingreso al sistema para ello se verifica si los datos ingresados son correctos.
     * @param usuario nombre de usuario del empleado
     * @param password contraseña del empleado
     */
    public void ingresoSistema(String usuario, String password) {
        String salida = "";
        boolean bandera = false;
        for (int i = 0; i < getEmpleados().size(); i++) {
            if (getEmpleados().get(i).getUserName().equalsIgnoreCase(usuario) && getEmpleados().get(i).getContraseña().equalsIgnoreCase(password)) {
                if (getEmpleados().get(i).getPrivilegio().equals(TipoPrivilegio.ADMINISTRADOR)) {
                    menuAdministradorImplementacion();
                } else if (getEmpleados().get(i).getPrivilegio().equals(TipoPrivilegio.FUNCIONARIO)) {
                    menuFuncionarioImplemtacion();
                }
                bandera = true;
                break;
            }
        }
      
        if (bandera) {
            salida = respuesta("\n¿Desea salir de todo el sistema de la Fundacion “Amigos de cuatro Patas”? (S/N): ");
            
            if (salida.equalsIgnoreCase("s")) {
                System.out.println("\nGRACIAS.\n");
                System.exit(0);
            }
            
        } else if (!bandera) {
            System.out.println("\nUsuario y contaseña ingresados incorrectos. Intente nuevamente.");
        }

    }

     /**
     *Metodo que inicializa el sistema con 3 animales de cada tipo, 3 empleados, 3 voluntarios y 3 veterinarios.
     */
    public void inicializarSistema() {
        inicializarAnimales();
        inicializarEmpleados();
        inicializarVeterinarios();
        inicializarVoluntarios();

    }

    /**
     *Metodo que crea instancias de empleados.
     */
    public void inicializarEmpleados() {
        Empleado administrador = new Administrador("Luis", "Moya", "Guasmo Sur", "0990851889", "lamoya@espol.edu.ec", LocalDate.now(), 600.0, TipoPrivilegio.ADMINISTRADOR, "Dean", "1234");
        administrador.setFechaInicio(LocalDate.of(2017, 01, 12));
        Empleado funcionario1 = new Funcionario("Carlos", "Burgos", "Mucho Lote", "0995095432", "c_burgos@hotmail.com", LocalDate.now(), 900.0, TipoPrivilegio.FUNCIONARIO, "CaBM", "1234");
        funcionario1.setFechaInicio(LocalDate.of(2016, 11, 20));
        Empleado funcionario2 = new Funcionario("Marcos", "Orellana", "Samborondon", "0997098971", "morellana@hotmail.com", LocalDate.now(), 800.0, TipoPrivilegio.FUNCIONARIO, "MOrellana", "pp78");
        funcionario2.setFechaInicio(LocalDate.of(2017, 06, 12));
        empleados.add(administrador);
        empleados.add(funcionario1);
        empleados.add(funcionario2);
    }

    /**
     *Metodo que crea 3 instancias de voluntarios.
     */
    public void inicializarVoluntarios() {
        Voluntario voluntario1 = new Voluntario("Karla", "Arevalo", "kaarevalo@hotmail.com", "0953147285", "Orquideas", LocalDate.now());
        Voluntario voluntario2 = new Voluntario("Lorenzo", "Guerrero", "jguerrero@hotmail.com", "0986574123", "Sauces", LocalDate.now());
        Voluntario voluntario3 = new Voluntario("Manuel", "Alvarez", "k_alvarez8@hotmail.com", "09921456782", "La joya", LocalDate.now());
        voluntarios.add(voluntario1);
        voluntarios.add(voluntario2);
        voluntarios.add(voluntario3);

    }
    
    /**
     *Metodo que crea 3 instancias de veterinarios.
     */
    public void inicializarVeterinarios() {
        Veterinario veterinario1 = new Veterinario("0931580446", "David", "Perez", "david_p@hotmail.com", "Bellavista", "0998534412", 600, 5);
        Veterinario veterinario2 = new Veterinario("0957863452", "Alejandra", "Carrillo", "alecarrillo@hotmail.com", "Urdesa", "0985632177", 700, 8);
        Veterinario veterinario3 = new Veterinario("0932001256", "William", "Tandazo", "wtand@hotmail.com", "Portete", "0989654763", 800, 7);
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);
        veterinarios.add(veterinario3);

    }

    /**
     *Metodo que crea 3 instancias de perros y 3 instancias de gatos, los cuales 2 gatos y 1 perro ya estan adoptados. 
     */
    public void inicializarAnimales() {

        Cliente cliente1 = new Cliente("0384383345", "Orlando", "Zambrano", "orly@hotmail.com", "0943242312", "Sauces");
        Cliente cliente2 = new Cliente("0111111111", "Juan", "Perez", "Jperez@hotmail.com", "0923322323", "Urdesa");

        Animal gato1 = new Gato("Negro", "Siames", "Macho", 4.5, 12, true, false, 1);
        gato1.setFechaIngreso(LocalDate.of(2010, 11, 10));
        animalesFundacion.add(gato1);
        Funcionario.adoptar(1, cliente1, animalesFundacion, clientesActivos, animalesAdoptados);
        gato1.setFechaAdopcion(LocalDate.of(2015, Month.DECEMBER, 2));

        Animal gato2 = new Gato("Blanco, manchas negras", "Persa", "Hembra", 3.4, 3, true, false, 2);
        gato2.setFechaIngreso(LocalDate.of(2008, 03, 15));
        animalesFundacion.add(gato2);
        Funcionario.adoptar(2, cliente2, animalesFundacion, clientesActivos, animalesAdoptados);

        Animal gato3 = new Gato("cafe", "Angora", "Hembra", 6.0, 7, false, false, 3);
        gato3.setFechaIngreso(LocalDate.of(2009, 06, 13));
        animalesFundacion.add(gato3);

        Animal perro1 = new Perro(Tamano.GRANDE, "plomo", "Husky", "Macho", 7.0, 5, true, false, 4);
        perro1.setFechaIngreso(LocalDate.of(2017, 02, 11));
        animalesFundacion.add(perro1);
        Funcionario.adoptar(4, cliente1, animalesFundacion, clientesActivos, animalesAdoptados);
        perro1.setFechaAdopcion(LocalDate.of(2015, Month.AUGUST, 10));

        Animal perro2 = new Perro(Tamano.MEDIANO, "negro", "Salchicha", "Hembra", 8.0, 12, true, false, 5);
        perro2.setFechaIngreso(LocalDate.of(2016, 9, 06));
        animalesFundacion.add(perro2);

        Animal perro3 = new Perro(Tamano.PEQUEÑO, "Blanco-negro", "Dalmata", "Macho", 7.7, 4, false, true, 6);
        perro3.setFechaIngreso(LocalDate.of(2016, 8, 10));
        animalesFundacion.add(perro3);
    }

    /**
     *Metpdo que imprime el menu de un empleado de tipo Funcionario.
     */
    public static void menuFuncionario() {
        System.out.println("");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("\t    MENU FUNCIONARIO\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("\t\t\t\t\t   ");
        System.out.println((char) 27 + "[36;49m" + " *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  1.- Ingresar animal\t\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  2.- Crear cita con veterinario\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  3.- Marcar animal como sano\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  4.- Registrar adopcion\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  5.- Consultar animales en la fundación   ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  6.- Consultar animales adoptados\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  7.- Consultar persona\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  8.- Consultar veterinario\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  9.- Salir\t\t\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("\t\t\t\t\t");
        System.out.println((char) 27 + "[36;49m" + "    *");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }

    /**
     * Metodo que imprime un menu el cual solo podra ser accedido por un empleado que tenga
     * como cargo o privilegio ser un funcionario.
     */
    public static void menuFuncionarioImplemtacion() {

        int op = 0;

        while (!(op == 9)) {

            menuFuncionario();

            do {
                System.out.print("\nIngrese opcion del menu funcionario: ");
                op = validarOpciones();
            } while (op < 1 || op > 9);

            switch (op) {

                case 1:
                    ingresarAnimal();
                    break;

                case 2:
                    crearCita();
                    break;

                case 3:
                    marcarSanoAnimal();
                    break;

                case 4:
                    realizarAdopcion();
                    break;

                case 5:
                    consultarAnimales();
                    break;

                case 6:
                    consultarAnimalesAdoptados();
                    break;

                case 7:
                    consultarPersona();
                    break;

                case 8:
                    consultarVeterinarios();
                    break;

                case 9:
                    System.out.println("\nCIERRE DEL FUNCIONARIO");
                    break;

                default:
                    break;

            }
        }
    }
    
    /**
     *Metpdo que imprime el menu de un empleado de tipo Administrador.
     */
    public static void menuAdministrador() {
        System.out.println("");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("          MENU ADMINISTRADOR       ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("\t\t\t\t  ");
        System.out.println((char) 27 + "[36;49m" + "  *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  1.- Registrar veterinario\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  2.- Registrar empleado\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  3.- Registrar voluntario\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  4.- Calcular presupuesto mensual ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  5.- Salir\t\t\t    ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("\t\t\t\t");
        System.out.println((char) 27 + "[36;49m" + "    *");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * *");
    }

    /**
     * Metodo que imprime un menu el cual solo podra ser accedido por un empleado que tenga
     * como cargo o privilegio ser un Administrador.
     */
    public static void menuAdministradorImplementacion() {

        int op = 0;

        while (!(op == 5)) {

            menuAdministrador();

            do {
                System.out.print("\nIngrese opcion del menu administrador: ");
                op = validarOpciones();
            } while (op < 1 || op > 5);

            switch (op) {

                case 1:
                    registrarVeterinario();
                    break;

                case 2:
                    registrarEmpleado();
                    break;

                case 3:
                    registrarVoluntario();
                    break;

                case 4:
                    presupuestoMensual(); 
                    break;

                case 5:
                    System.out.println("\nCIERRE DEL ADMINISTRADOR");
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * Metodo que permitira el ingreso de un animal a la fundacion
     */
    public static void ingresarAnimal() {

        Animal animalIngresado = new Animal();
        String animal = "";
        String cast = "";
        String enf = "";
        String ta = "";
        String sexo = "";
        Tamano tamaño = Tamano.PEQUEÑO; //Por default
        boolean castrado = false;
        boolean enfermo = false;
        int codigo = animalesFundacion.size() + 1;

        System.out.println("\nINGRESAR ANIMAL\n");

        do {
            System.out.print("Animal a ingresar (P/G): ");
            animal = sc.nextLine();
        } while (!animal.equalsIgnoreCase("p") && !animal.equalsIgnoreCase("g"));

        if (revisionMaxAnimales(animal)) {
            System.out.print("Fecha de ingreso: ");
            LocalDate fechaIngreso = LocalDate.now();
            System.out.println(fechaIngreso);
            String color = validarString("Color: ");
            String raza = validarString("Raza: ");
            
            do {
                System.out.print("Sexo (H/M): ");
                sexo = sc.nextLine();
            } while (!sexo.equalsIgnoreCase("h") && !sexo.equalsIgnoreCase("m"));

            if (sexo.equalsIgnoreCase("h")) {
                sexo = "Hembra";
            } else if (sexo.equalsIgnoreCase("m")) {
                sexo = "Macho";
            }
            
            System.out.print("Peso: ");
            double peso = validarOpciones();
            System.out.print("Edad: ");
            int edad = validarOpciones();

            cast = respuesta("¿Esta castrado? S/N: ");
            
            if (cast.equalsIgnoreCase("s")) {
                castrado = true;
            } else if (cast.equalsIgnoreCase("n")) {
                castrado = false;
            }

            enf = respuesta("¿Se encuentra enfermo? S/N: ");

            if (enf.equalsIgnoreCase("s")) {
                enfermo = true;
            } else if (enf.equalsIgnoreCase("n")) {
                enfermo = false;
            }

            System.out.print("Codigo: ");
            int codigoNew = codigo;
            System.out.print(codigoNew + "\n");

            if (animal.equalsIgnoreCase("p")) {
                do {
                    System.out.print("Tamaño (G/M/P): ");
                    ta = sc.nextLine();
                } while (!ta.equalsIgnoreCase("g") && !ta.equalsIgnoreCase("m") && !ta.equalsIgnoreCase("p"));

                if (ta.equalsIgnoreCase("g")) {
                    tamaño = Tamano.GRANDE;
                } else if (ta.equalsIgnoreCase("m")) {
                    tamaño = Tamano.MEDIANO;
                } else if (ta.equalsIgnoreCase("p")) {
                    tamaño = Tamano.PEQUEÑO;
                }

                animalIngresado = new Perro(tamaño, color, raza, sexo, peso, edad, castrado, enfermo, codigoNew);

            } else if (animal.equalsIgnoreCase("g")) {
                animalIngresado = new Gato(color, raza, sexo, peso, edad, castrado, enfermo, codigoNew);
            }
            Funcionario.ingresoAnimal(animalIngresado, animalesFundacion);
        }

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'INGRESAR ANIMAL'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                ingresarAnimal();
            } else if (salir.equalsIgnoreCase("n")){
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));
    }

    /**
     *Metodo que me permite crear una cita entre un animal y un veterinario si y solo si el animal esta enfermo.
     */
    public static void crearCita() {

        String confirmacion = "";

        System.out.println("\nCREAR CITA CON VETERINARIO\n");

        //Lista de animales enfermos
        System.out.println("LISTA DE ANIMALES ENFERMOS\n");
        for (int i = 0; i < animalesFundacion.size(); i++) {
            if (animalesFundacion.get(i).isEnfermo() == true && animalesFundacion.get(i).isTieneVeterinario() == false) {
                System.out.println(animalesFundacion.get(i));
            }
        }

        //Lista de veterinarios ordenada de menor a mayor cantidad de animales a cuidar
        System.out.println("\nLISTA DE VETERINARIOS\n");
        for (int i = 0; i < (veterinarios.size() - 1); i++) {
            int min = i;
            for (int j = i + 1; j < (veterinarios.size()); j++) {
                if (veterinarios.get(j).getAnimalesCuidar().size() < veterinarios.get(min).getAnimalesCuidar().size()) {
                    min = j;
                    Veterinario auxiliar = new Veterinario();
                    auxiliar = veterinarios.get(i);

                    veterinarios.set(i, veterinarios.get(min));
                    veterinarios.set(min, auxiliar);
                }
            }
        }

        for (int indice = 0; indice < veterinarios.size(); indice++) {
            System.out.println(veterinarios.get(indice));
        }

        System.out.print("\nCodigo de animal: ");
        int codA = validarOpciones();
        String codV = validarString("ID del veterinario: ");

        confirmacion = respuesta("\n¿Se desea asignar al veterinario este animal? S/N: ");

        if (confirmacion.equalsIgnoreCase("s")) {
            Funcionario.crearCita(animalesFundacion, codA, veterinarios, codV);
        } else if (confirmacion.equalsIgnoreCase("n")) {
            System.out.println("\nEl animal no ha sido asignaado a ningun veterinario.");
        }

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'CREAR CITA CON VETERINARIO'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                crearCita();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que me permite cambiar el estado de salud del animal sano.
     */
    public static void marcarSanoAnimal() {

        boolean bandera = false;

        System.out.println("\nMARCAR SANO ANIMAL");

        System.out.println("\nLISTA DE ANIMALES ENFERMOS QUE TIENE ASIGNADO UN VETERINARIO\n");
        for (int i = 0; i < veterinarios.size(); i++) {
            if (veterinarios.get(i).getAnimalesCuidar().isEmpty() == false) {
                System.out.println(veterinarios.get(i).getAnimalesCuidar().toString());
                bandera = true;
            }
        }

        if (bandera) {
            System.out.print("\nCodigo de animal: ");
            int codA = validarOpciones();
            String tratamiento = validarString("Ingrese tratamiento a seguir: ");

            Funcionario.marcarSano(animalesFundacion, codA, veterinarios);
        } else {
            System.out.println("No hay datos para presentar al momento");
        }

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'MARCAR SANO ANIMAL'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                marcarSanoAnimal();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que me permite realizar una adopcion de los animales que estan en mi Fundacion.
     */
    public static void realizarAdopcion() {

        boolean bandera = false;
        Cliente cl = new Cliente();
        String nombre = "";
        String apellido = "";
        String direccion = "";
        String telefono = "";
        String correo = "";
        System.out.println("\nREALIZAR ADOPCION\n");
        System.out.println("DATOS DEL CLIENTE\n");
        String id = validarString("Identificacion: ");
        for (int i = 0; i < clientesActivos.size(); i++) {
            if (clientesActivos.get(i).getId().equalsIgnoreCase(id)) {
                bandera = true;
                cl = clientesActivos.get(i);
            }
        }
        if (bandera == true) {
            nombre = cl.getNombre();
            apellido = cl.getApellido();
            direccion = cl.getDireccion();
            telefono = cl.getTelefono();
            correo = cl.getCorreo();
        } else {
            nombre = validarString("Nombres: ");
            apellido = validarString("Apellidos: ");
            direccion = validarString("Direccion: ");
            telefono = validarString("Telefono: ");
            correo = validarString("Correo: ");
        }
        System.out.println("\nLISTA DE ANIMALES QUE PUEDEN SER ADOPTADOS");
        for (int i = 0; i < animalesFundacion.size(); i++) {
            if (animalesFundacion.get(i).isAdoptado() == false && animalesFundacion.get(i).isEnfermo() == false) {
                System.out.println(animalesFundacion.get(i));
            }
        }

        System.out.println("\nDATOS DEL ANIMAL A ADOPTAR\n");
        System.out.print("Codigo de animal: ");
        int codA = validarOpciones();

        Cliente c = new Cliente(id, nombre, apellido, correo, telefono, direccion);
        Funcionario.adoptar(codA, c, animalesFundacion, clientesActivos, animalesAdoptados);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'REALIZAR ADOPCION'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                realizarAdopcion();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que me muestra los animales adoptados deacuerdo a la fecha en los que fueron adoptados.
      A su vez por cada animal puedo conocer la informacion de su dueño
     */
    public static void consultarAnimalesAdoptados() {
        System.out.println("\nCONSULTAR ANIMALES ADOPTADOS");
        System.out.println("\nLISTA DE ANIMALES ADOPTADOS\n");
        
        Funcionario.filtrarFechaAdopcion(animalesAdoptados);
        System.out.print("\nIngrese el codigo del animal: ");
        int codigo = validarOpciones();

        Funcionario.filtrarAdoptados(animalesAdoptados, codigo);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'CONSULTAR ANIMALES ADOPTADOS'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                consultarAnimalesAdoptados();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }
    
    /**
     *Metodo que me muestra por pantalla las personas que han adoptado en la fundacion.
     *A su vez se puede conocer la cantidad e informacion de dichos animales que posee cada persona o cliente.
     */
    public static void consultarPersona() {
        System.out.println("\nCONSULTAR CLIENTE");
        System.out.println("\nCLIENTES QUE ADOPTARON UN ANIMAL\n");
        for (int i = 0; i < clientesActivos.size(); i++) {
            System.out.println(clientesActivos.get(i).toStringDet());
        }

        String id = validarString("\nIngrese el numero de cedula: ");
        System.out.println("");
        for (int i = 0; i < clientesActivos.size(); i++) {
            if (id.equalsIgnoreCase(clientesActivos.get(i).getId())) {
                System.out.println(clientesActivos.get(i));
                for (int j = 0; j < clientesActivos.get(i).getAnimales().size(); j++) {
                    System.out.println(clientesActivos.get(i).getAnimales().get(j).toStringDet());
                }
                String opcion = respuesta("\nDesea editar los datos (S/N): ");
                if (opcion.equalsIgnoreCase("s")) {
                    String nombre = validarString("Nombres: ");
                    String apellido = validarString("Apellidos: ");
                    String direccion = validarString("Direccion: ");
                    String telefono = validarString("Telefono: ");
                    String correo = validarString("Correo: ");
                    clientesActivos.get(i).setNombre(nombre);
                    clientesActivos.get(i).setApellido(apellido);
                    clientesActivos.get(i).setDireccion(direccion);
                    clientesActivos.get(i).setTelefono(telefono);
                    clientesActivos.get(i).setCorreo(correo);
                    System.out.println("\nSe han guardaron los cambios");
                } else if (opcion.equalsIgnoreCase("n")){
                    System.out.println("\nLos datos no han sido modificados.");
                }
            }
        }

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'CONSULTAR CLIENTE'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                consultarPersona();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que me muestra por pantalla todos los veterinarios que estaran dispuestos a ofrecer sus
     * servicios en la fundacion.
     * A su vez se puede obtener informacion acerca de los animales que esta atendiendo en ese momento
     * y los que ya han sido atendidos por el.
     */
    public static void consultarVeterinarios() {

        System.out.println("\nCONSULTAR VETERINARIOS");
        System.out.println("\nLISTADO PRINCIPAL DE VETERINARIOS");
        for (Veterinario vet : veterinarios) {
            System.out.println(vet.datosPrincipales());
        }

        String codVet = validarString("\nID del veterinario: ");

        Funcionario.consultarVeterinario(codVet, veterinarios);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'CONSULTAR VETERINARIOS'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                consultarVeterinarios();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que crea una nueva instancia o objeto de un veterinario.
     */
    public static void registrarVeterinario() {

        System.out.println("\nREGISTRAR VETERINARIO\n");
        String id = validarString("Identificacion: ");
        String nombre = validarString("Nombres: ");
        String apellido = validarString("Apellidos: ");
        String direccion = validarString("Direccion: ");
        String telefono = validarString("Telefono: ");
        String correo  = validarString("Correo: ");
        System.out.print("Sueldo por hora: ");
        double sueldoHora = validarOpciones();
        System.out.print("Horas a trabajar: ");
        int horas = validarOpciones();

        Administrador.registrarVeterinario(nombre, apellido, direccion, telefono, id, correo, sueldoHora, horas, veterinarios);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'REGISTRAR VETERINARIO'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                registrarVeterinario();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));
    }

    /**
     *Metodo que crea una nueva instancia o objeto de un empleado.
     * Un empleado tiene 2 atributos: Funcionario y administrados, por default
     * se lo inicializa como funcionario.
     */
    public static void registrarEmpleado() {

        TipoPrivilegio privilegio = TipoPrivilegio.FUNCIONARIO;
        boolean isAdministrador = false;
        boolean bandera = true;
        String respuesta = "";
        String usuario = "";

        System.out.println("\nREGISTRAR EMPLEADO\n");
        String nombreEmpleado = validarString("Nombres: ");
        String apellidoEmpleado = validarString("Apellidos: ");
        
        do {
            usuario = validarString("Usuario: ");
            for (Empleado e : empleados) {
                if (usuario.equalsIgnoreCase(e.getUserName())) {
                    bandera = false;
                    System.out.println("\nEl usuario ya existe. Ingrese nuevamente.");
                    break;
                } else {
                    bandera = true;
                }
            }
        } while (!bandera);
        
        String contraseña = validarString("Contraseña: ");
        String direccionEmpleado = validarString("Direccion: ");
        String telefEmpleado = validarString("Telefono: ");
        String correoEmpleado = validarString("Correo: ");
        System.out.print("Fecha de inicio: ");
        LocalDate fechaInicio = LocalDate.now();
        System.out.println(fechaInicio);
        System.out.print("Sueldo: ");
        double sueldoEmpleado = validarOpciones();

        respuesta = respuesta("¿Sera administrador? S/N: ");

        if (respuesta.equalsIgnoreCase("s")) {
            isAdministrador = true;
            privilegio = TipoPrivilegio.ADMINISTRADOR;
        } else if (respuesta.equalsIgnoreCase("n")) {
            isAdministrador = false;
            privilegio = TipoPrivilegio.FUNCIONARIO;
        }

        Administrador.registrarEmpleado(nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefEmpleado, correoEmpleado, fechaInicio, sueldoEmpleado, usuario, contraseña, isAdministrador, privilegio, empleados);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'REGISTRAR EMPLEADO'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                registrarEmpleado();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que crea una nueva instancia o objeto de un Voluntario.
     */
    public static void registrarVoluntario() {
        System.out.println("\nREGISTRAR VOLUNTARIO\n");
        String nombreVoluntario = validarString("Nombres: ");
        String apellidoVoluntario = validarString("Apellidos: ");
        String direccionVoluntario = validarString("Direccion: ");
        String telefVoluntario = validarString("Telefono: ");
        String correoVoluntario = validarString("Correo: ");
        System.out.print("Fecha de inicio: ");
        LocalDate fechaInicioVoluntario = LocalDate.now();
        System.out.println(fechaInicioVoluntario);

        Administrador.registrarVoluntario(nombreVoluntario, apellidoVoluntario, direccionVoluntario, telefVoluntario, correoVoluntario, fechaInicioVoluntario, voluntarios);

        String salir = "";
        do {
            System.out.print("\n¿Desea continuar en la opcion 'REGISTRAR VOLUNTARIO'? S/N: ");
            salir = sc.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                registrarVoluntario();
            } else if (salir.equalsIgnoreCase("n")) {
                break;
            }
        } while (!salir.equalsIgnoreCase("s") && !salir.equalsIgnoreCase("n"));

    }

    /**
     *Metodo que realiza el calculo del presupuesto de los empleados y animales de la
     * fundacion.
     */
    public static void presupuestoMensual() {

        double gastoAdministrativo = 0;
        for (Animal animales : animalesFundacion) {
            gastoAdministrativo += animales.calcularGastoAnimales();
        }
        System.out.println("\nLos gastos de los animales son: " + gastoAdministrativo);
        gastoAdministrativo += Empleado.gastosAdministrativos(empleados);
        System.out.println("Los gastos administrativos son: " + Empleado.gastosAdministrativos(empleados));
        System.out.println("Los gastos totales son: " + gastoAdministrativo);
    }

    /**
     * Metodo que valida el ingreso de un numero.
     * @return op, tipo int que posee el valor del numero ingresado de manera correcta.
     */
    private static int validarOpciones() {

        Scanner scan = new Scanner(System.in);
        int op = 0;

        do {
            try {
                op = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("\nIMPORTANTE: Tipo de dato erroneo.");
                System.out.print("Ingrese nuevamente: ");
                continue;
            }
            break;
        } while (true);

        return (op);
    }

    /**
     * Metodo que validara que sea ingresado un String, no se admitira el enter
     * @return la variable que guardara la respuesta a la consigana
     */
    private static String validarString(String consigna) {
        String variable = "";
        
        while(variable.equalsIgnoreCase("")){
            System.out.print(consigna);
            variable = sc.nextLine();
        }
        
        return variable;
    }
    
    /**
     * Metodo que me permite presponder a una consigana con un si (S) o un no (N)
     * @param consigna la pregunta a realizar
     * @return el valor de la respuesta, S para si y N para no
     */
    private static String respuesta(String consigna) {
        String salida = "";
        do {
            System.out.print(consigna);
            salida = sc.nextLine();
        } while (!salida.equalsIgnoreCase("s") && !salida.equalsIgnoreCase("n"));

        return salida;
    }
    
    /**
     * Metodo que revisa que no sean ingresados mas de 30 perros ni mas de 50
     * gatos.
     *
     * @param a tipo de animal a ingresar
     * @return un valor booleano para saber si cumple o no con el maximo de
     * animales.
     */
    public static boolean revisionMaxAnimales(String a) {
        int perro = 0;
        int gato = 0;
        boolean respuesta = true;

        for (int i = 0; i < animalesFundacion.size(); i++) {
            if (animalesFundacion.get(i).getSalidaAnimal().equalsIgnoreCase("Perro") && a.equalsIgnoreCase("P") && animalesFundacion.get(i).isAdoptado() == false) {
                perro++;
            } else {
                gato++;
            }
        }

        if (perro < 30 && gato < 50) {

        } else {
            respuesta = false;
            System.out.println("\nIMPORTANTE: No se puede ingresar mas animales mas de este tipo.");
        }

        return respuesta;
    }

    /**
     *Metodo que ordena a los animales dependiendo de su Fecha de Ingreso.
     */
    public static void animalesPorFecha() {
        System.out.println("\nFiltrado por fecha de ingreso del animal\n");
        Funcionario.filtrarFechaIngreso(animalesFundacion);

    }

    /**
     *Metodo que ordena a los animales dependiendo de su tipo (Perro-Gato).
     */
    public static void animalesPorTipo() {

        System.out.print("\nFiltrado por tipo de animal\nIngrese el tipo de animal que desee buscar (P/G): ");
        String opcion = sc.next();
        sc.nextLine();
        opcion = opcion.toUpperCase();
        if (opcion.equalsIgnoreCase("G") || opcion.equalsIgnoreCase("P")) {
            System.out.println("");
            Funcionario.filtrarTipo(opcion, animalesFundacion);
        } else {
            System.out.println("\nTipo de animal erroneo");
        }
        if (opcion.equalsIgnoreCase("p")) {
            System.out.println("");
            System.out.println("Ha escogido un perro, filtrar por tamaño\n");
            escogerTamano();

        }
    }

    /**
     *Metodo que ordena a los animales dependiendo de su tipo de sexo.
     */
    public static void animalesPorSexo() {

        System.out.print("\nFiltrado por sexo del animal\nIngrese macho(M) o hembra (H): ");
        String sexo = sc.next();
        sc.nextLine();
        sexo = sexo.toUpperCase();
        boolean confirmacion = sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M");
        while (!confirmacion) {
            System.out.print("Ingreso incorrecto, vuelva a escribir el sexo: ");
            sexo = sc.nextLine();
            sexo = sexo.toUpperCase();
            if (sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M")) {
                break;
            }
        }
        System.out.println("");
        Funcionario.filtrarSexo(sexo, animalesFundacion);

    }

    /**
     *Metodo que ordena a los animales dependiendo de su raza.
     */
    public static void animalesPorRaza() {
        System.out.print("\nFiltrado por raza\nEscriba la raza del animal que desea ver: ");
        String raza = sc.next();
        System.out.println("");
        Funcionario.filtrarRaza(raza, animalesFundacion);
    }

    /**
     *Metodo que me realiza una convercion de tipo int a un tipo enumTipe.
     * @return t1, tipo Tamaño el cual contendra el tamaño del perro.
     */
    public static Tamano escogerTamano() {

        Tamano t1 = Tamano.GRANDE;
        System.out.println("1. Grandes");
        System.out.println("2. Medianos");
        System.out.println("3. Pequeños");
        System.out.println("4. No hacer filtro por tamaño");
        System.out.print("\nEscoja el tamaño del perro, escribiendo el número de la opción: ");
        int opcion = validarOpciones();
        System.out.println("");
        switch (opcion) {
            case 1:
                t1 = Tamano.GRANDE;
                Funcionario.filtrarPerros(t1, animalesFundacion);
                break;
            case 2:
                t1 = Tamano.MEDIANO;
                Funcionario.filtrarPerros(t1, animalesFundacion);
                break;
            case 3:
                t1 = Tamano.PEQUEÑO;
                Funcionario.filtrarPerros(t1, animalesFundacion);
                break;
            case 4:
                System.out.println("No se realizo busqueda por tamaño.");
                break;
            default:
                System.out.println("Esta fuera del rango de opciones");
                break;
        }

        return t1;
    }

    /**
     *metodo que mostrara por pantalla a los animales que estan en la Fundacion y
     * estos estaran ordenados de diferentes formas.(Fecha de ingreso, Tipo, Sexo, Raza) 
     */
    public static void consultarAnimales() {

        int op = 0;
        System.out.println("\nCONSULTAR ANIMALES EN FUNDACION\n");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("          ANIMALES EN LA FUNDACION       ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[36;49m");
        System.out.print("\t\t\t\t       ");
        System.out.println((char) 27 + "[36;49m" + "   *");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  1.- Ver animales por fecha de ingreso  ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  2.- Ver animales por tipo\t\t  ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  3.- Ver animales por sexo\t\t  ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  4.- Ver  animales por raza\t\t  ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m" + "*");
        System.out.print((char) 27 + "[34;49m");
        System.out.print("  5.- Salir\t\t\t\t  ");
        System.out.println((char) 27 + "[36;49m" + "*");

        System.out.print((char) 27 + "[36;49m");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * *");

        while (!(op == 5)) {

            do {
                System.out.print("\nEscoja una opcion de filtrado del menu 'ANIMALES EN LA FUNDACION': ");
                op = validarOpciones();
            } while (op < 1 || op > 5);

            switch (op) {

                case 1:
                    animalesPorFecha();
                    break;

                case 2:
                    animalesPorTipo();
                    break;

                case 3:
                    animalesPorSexo();
                    break;

                case 4:
                    animalesPorRaza();
                    break;

                case 5:
                    System.out.println("\nSalida de 'ANIMALES EN LA FUNDACION'.");
                    break;

                default:
                    break;
            }

        }

    }

    /**
     *Metodo que me permite obtener el estado de una lista de animales en la Fundacion.
     * @return animalesFundacion, me retorna un ArrayList el cual contendra a los animales en la fundacion.
     */
    public ArrayList<Animal> getAnimalesFundacion() {
        return animalesFundacion;
    }

    /**
     *Metodo que me permite obtener el estado de una lista de empleados en la fundacion.
     * @return empleados, me retorna un ArrayList el cual contendra a los animales en la fundacion.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *Metodo que me permite obtener el estado de una lista de clientes activos en la fundacion.
     * @return clientesActivos, me retorna un ArrayList el cual contendra a los clientes activos en la fundacion.
     */
    public ArrayList<Cliente> getClientesActivos() {
        return clientesActivos;
    }

    /**
     *Metodo que me permite obtener el estado de una lista de vlountarios activos en la fundacion.
     * @return voluntarios, me retorna un ArrayList el cual contendra a los voluntarios  en la fundacion.
     */
    public ArrayList<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    /**
     *Metodo que me permite obtener el estado de una lista de veterinarios en la fundacion.
     * @return veterinarios, me retorna un ArrayList el cual contendra a los veterinarios en la fundacion.
     */
    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

}
