package vista;

import controlador.Controlador;
import modelo.Colores;
import modelo.Mazos;
import modelo.MazosColores;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("**** MENU MAGIC ****");
            System.out.println("1. Listar mazos");
            System.out.println("2. Listar colores");
            System.out.println("3. Listar mazos con faccion");
            System.out.println("4. Introducir mazo nuevo");
            System.out.println("5. Introducir color nuevo");
            System.out.println("6. Asignar colores a un mazo");
            System.out.println("7. Eliminar mazo");
            System.out.println("8. Actualizar mazo");
            System.out.println("0. Salir");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    obtenerMazos(controlador);
                    break;
                case 2:
                    obtenerColores(controlador);
                    break;
                case 3:
                    obtenerMazosColores(controlador);
                    break;
                case 4:
                    pedirDatosMazo(controlador);
                    break;
                case 5:
                    pedirDatosColor(controlador);
                    break;
                case 6:
                    asignarColoresMazo(controlador);
                    break;
                case 7:
                    eliminarMazo(controlador);
                    break;
                case 8:
                    actualizarMazo(controlador);
                    break;
                default:
                    System.out.println("Saliendo...");
            }
        } while (opcion != 0);
    }

    public static void obtenerMazos(Controlador controlador) {
        List<Mazos> mazos = controlador.obtenerMazos();
        System.out.println(mazos);
    }

    public static void obtenerColores(Controlador controlador) {
        List<Colores> colores = controlador.obtenerColores();
        System.out.println(colores);
    }

    public static void obtenerMazosColores(Controlador controlador) {
        List<MazosColores> lista = controlador.obtenerMazosColores();
        System.out.println(lista);
    }

    public static void pedirDatosMazo(Controlador controlador) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre del mazo:");
        String nombre = input.nextLine();
        System.out.println("Introduce el formato del mazo:");
        String formato = input.nextLine();

        Mazos m = new Mazos(nombre, formato);
        int resultado = controlador.insertarMazo(m);

        if (resultado > 0) {
            System.out.println("El mazo se ha podido insertar");
        } else {
            System.out.println("El mazo no se ha podido insertar");
        }
    }

    public static void pedirDatosColor(Controlador controlador) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre del color:");
        String nombre = input.nextLine();

        int resultado = controlador.insertarColor(nombre);

        if (resultado > 0) {
            System.out.println("El color se ha podido insertar");
        } else {
            System.out.println("El color no se ha podido insertar");
        }
    }

    public static void asignarColoresMazo(Controlador controlador) {
        Scanner input = new Scanner(System.in);
        obtenerMazos(controlador);
        System.out.println("Introduce el id del mazo:");
        int idMazo = input.nextInt();
        input.nextLine();
        obtenerColores(controlador);
        System.out.println("Introduce los ids de colores separados por coma (ej: 1,2,5):");
        String coloresIds = input.nextLine();

        int resultado = controlador.insertarMazoColor(idMazo, coloresIds);

        if (resultado > 0) {
            System.out.println("Los colores se han asignado correctamente");
        } else {
            System.out.println("No se han podido asignar los colores");
        }
    }

    public static void eliminarMazo(Controlador controlador) {
        Scanner input = new Scanner(System.in);
        obtenerMazos(controlador);
        System.out.println("Introduce el id del mazo a eliminar:");
        int idMazo = input.nextInt();

        int resultado = controlador.eliminarMazo(idMazo);

        if (resultado > 0) {
            System.out.println("El mazo se ha podido eliminar");
        } else {
            System.out.println("El mazo no se ha podido eliminar");
        }
    }

    public static void actualizarMazo(Controlador controlador) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el id del mazo a actualizar:");
        int idMazo = input.nextInt();
        input.nextLine();

        System.out.println("**** Actualizar ****");
        System.out.println("1. Nombre del mazo");
        System.out.println("2. Formato del mazo");
        System.out.println("3. Colores del mazo");
        int opcion = input.nextInt();
        input.nextLine();

        System.out.println("Introduce el nuevo dato:");
        String dato = input.nextLine();

        int resultado = controlador.actualizarMazo(idMazo, dato, opcion);

        if (resultado > 0) {
            System.out.println("El mazo se ha podido actualizar");
        } else {
            System.out.println("El mazo no se ha podido actualizar");
        }
    }
}