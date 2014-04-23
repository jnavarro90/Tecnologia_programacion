/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import recursos.Lee;
/**
 *
 * @author javi
 */
public class Principal{

    static Lee leer = new Lee(); //Se indica que se quiere leer desde consola
    static Parking parking = new Parking();

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

 
            opcion = leer.leeEntero();
        
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
                    matricula = leer.leeString();
                    if (!parking.entraVehiculo(matricula)) {
                        System.err.println("No hay sitio en el parking");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca matricula del vehiculo que sale:");
                    matricula = leer.leeString();
                    if (!parking.saleVehiculo(matricula)) {
                        System.out.println("El vehiculo no está en el parcking");
                    }
                    break;
                case 3:
                    System.out.println("Introduzca matricula del vehiculo para cobrarle:");
                    matricula = leer.leeString();
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
        Principal.comenzar();
    }
}
