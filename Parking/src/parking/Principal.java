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
        static Parking parcking = new Parking();
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
			opcion = menu();
		do{
			switch(opcion){
			case 1:
                            matricula = sc.next();
                            parcking.entraVehiculo(matricula);
				break;
			case 2:
                            matricula = sc.next();
                            parcking.saleVehiculo(matricula);
                                break;
                        case 3:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción incorrecta.");
                            break;
                        }
			
                }while(opcion!=3);
		
	}
	
	
	
	public static void main(String[] args){
		Principal.comenzar();
		
		
	}
    
}
