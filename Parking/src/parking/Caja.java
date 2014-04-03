 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class Caja {

    private Tarifa tarifas;
    private Ticket ticket;
    static Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola

    public double calcularPrecio(double importe, double iva) {
        float precio = 0;
        return precio;
    }

    public double calcularIva(double importe) {

        return 0;
    }

    public void crearTicket(int numeroTicket, Vehiculo v) {
        double tiempo = 0;
        int opcion;

        System.out.println("Se esta creando su ticket...");
        if (v.obtenerTiempo() != -1) {
            tiempo = v.obtenerTiempo();
        } else {
            System.out.println("No se puede calcular el tiempo porque falta alguna fecha");
        }
        ticket = new Ticket(numeroTicket, v, tiempo, tarifas.calcularImporte(tiempo),
                calcularIva(tarifas.calcularImporte(tiempo)),
                calcularPrecio(tarifas.calcularImporte(tiempo), calcularIva(tarifas.calcularImporte(tiempo))));
        System.out.println("¿Quiere su ticket?");
        System.out.println("-----------------------------------------");
        System.out.println("\t 1 - Si.");
        System.out.println("\t 2 - No.");
        System.out.println("-----------------------------------------");
        System.out.print("Opcion: ");
        do {
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                        imprimirTicket();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 2);    
    }

    public void cobrando(Vehiculo v) {
        System.out.println("Abone la cantidad indicada...");
        v.pagando();        
    }

    public void imprimirTicket() {
        ticket.imprimir();
    }
}