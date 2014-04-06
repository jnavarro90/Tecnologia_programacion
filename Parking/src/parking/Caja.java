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
    private final double IVA = 0.21;
    private Tramo[] tramos;
    private Ticket ticket;
    static Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola

    public Caja() {
        //tarifas = new Tarifa();
    }

    private double calcularPrecio(double importe, double iva) {
        return importe + iva;
    }

    private double calcularIva(double importe) {

        return importe * IVA;
    }
    private double calcularImporte(double tiempo){
      for (int i = 0; i < tramos.length;i++){
          if(tiempo <tramos[i].getLimite()){
              
          }
      }
      return 0;  
    }
    private void crearTramos(){
        tramos = new Tramo[2];
        for (int i = 0; i < tramos.length;i++){
            tramos[i] = new Tramo(1,1);
        }
    }
    public void crearTicket(int numeroTicket, Vehiculo v) {
        //tarifas.leerTarifas();
        double tiempo = 0;
        double importe = 0;
        int opcion;

        System.out.println("Se esta creando su ticket...");
        if (v.obtenerTiempo() != -1) {
            tiempo = v.obtenerTiempo();
        } else {
            System.out.println("No se puede calcular el tiempo porque falta alguna fecha");
        }
        importe = calcularImporte(tiempo);
 //       ticket = new TicketCentro(numeroTicket, v, tiempo, tramos.calcularImporte(tiempo),
 //                                   calcularIva(tramos.calcularImporte(tiempo)),
 //                                   calcularPrecio(tramos.calcularImporte(tiempo), calcularIva(tramos.calcularImporte(tiempo))));
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
                    opcion = 2;
                    break;
                case 2:
                    System.out.println("Volviendo al menu...");
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