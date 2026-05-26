package vista;

import controlador.Controlador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("**** MENU ****");
            System.out.println("1.Añadir nuevo mazo");
            System.out.println("2.Modificar mazo");
            System.out.println("3.Eliminar mazo");
            System.out.println("4.Listar mazos");
            System.out.println("0. Salir.");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    anniadirMazo(controlador);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Saliendo...");
            }
        } while (opcion != 0);
    }
    public static void anniadirMazo(Controlador controlador) {
        System.out.println("Función para añadir un nuevo mazo");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre del mazo:");
        String nombre = input.nextLine();
        System.out.println("Introduce el formato del mazo:");
        String formato = input.nextLine();
    }
}
