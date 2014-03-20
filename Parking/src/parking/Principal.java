/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.Scanner;

/**
 *
 * @author javi
 */
public class Principal {
        static Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
        static Parking parking = new Parking();
    	public static int menu(){
		
                int opcion;
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("Elija una de las opciones:");
		System.out.println("\t 1 - Entrada.");
		System.out.println("\t 2 - Salida.");		
		System.out.println("-----------------------------------------");
		System.out.print("Opcion: ");
		
		
		opcion = sc.nextInt();
		return opcion;
		
	}
	
	public static void comenzar(){
		int opcion;
		String matricula;
			
		do{
                        opcion = menu();
                        
                        switch(opcion){
			case 1:
                            System.out.println("Introduzca matricula del vehiculo que entra:");
                            matricula = sc.next();
                            if (!parking.entraVehiculo(matricula)){
                                System.err.println("No hay sitio en el parking");
                            }                          
                            break;
			case 2:
                            System.out.println("Introduzca matricula del vehiculo que sale:");
                            matricula = sc.next();
                            if (!parking.saleVehiculo(matricula)){
                                System.out.println("El vehiculo no está en el parcking");
                            }
                            break;
                        case 3:
                            System.out.println("Introduzca matricula del vehiculo que sale:");
                            matricula = sc.next();
                            parking.cobrar(matricula);
                        case 4:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción incorrecta.");
                            break;
                        }
			
                }while(opcion!=4);
		
	}
	
	
	
	public static void main(String[] args){
		Principal.comenzar();
		
		
	}
    
}
