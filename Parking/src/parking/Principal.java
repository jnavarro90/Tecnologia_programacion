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
        static Parcking parcking = new Parcking();
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
		
		do{
			
			opcion = menu();
		
			switch(opcion){
			case 1:
				System.err.println("Entrada");
				break;
			case 2:
				System.err.println("Salida");
				break;
			}
			
		}while(opcion!=3);
		
	}
	
	
	
	public static void main(String[] args){
		Principal.comenzar();
		
		
	}
    
}
