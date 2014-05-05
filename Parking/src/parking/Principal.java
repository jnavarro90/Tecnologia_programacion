/*
 * Clase Principal
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase para comenzar la aplicación del parking.
 * @author Javi
 * @version 1
 */
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal{

    /*Declaracion de constantes*/
    static Parking parking = new Parking();
    static Scanner sc = new Scanner(System.in);
    
    public static int menu() {

        int opcion;
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Elija una de las opciones:");
        System.out.println("\t 1 - Entrada de vehiculo.");
        System.out.println("\t 2 - Salida de vehiculo.");
        System.out.println("\t 3 - Cobrar a un vehiculo.");
        System.out.println("\t 4 - Salir.");
        System.out.println("-----------------------------------------");
        System.out.print("Opcion: ");

 
        opcion = sc.nextInt();
        
        return opcion;

    }

    public static void comenzar() {
        int opcion;
        String matricula;

        do {
                opcion = menu();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca matricula del vehiculo que entra:");
                    matricula = sc.next();
                    if (!parking.entraVehiculo(matricula)) {
                        System.err.println("No hay sitio en el parking");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca matricula del vehiculo que sale:");
                    matricula = sc.next();
                    if (!parking.saleVehiculo(matricula)) {
                        System.out.println("El vehiculo no está en el parcking");
                    }
                    break;
                case 3:
                    System.out.println("Introduzca matricula del vehiculo para cobrarle:");
                    matricula = sc.next();
                    parking.cobrar(matricula);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

        } while (opcion != 4);

    }

    public static void main(String[] args){
        comenzar();
    }
}
