 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Javi
 */
public class Caja {
    private final String TARIFAS= "./tarifas.txt";
    private final double IVA = 0.21;
    private Tramo[] tramos;
    private Ticket ticket;
    private StringTokenizer st;
    private Scanner sc; //Se indica que se quiere leer desde consola
    
    public Caja() {
        st = new StringTokenizer(TARIFAS, ":");
        sc = new Scanner(System.in);
        ticket = new TicketCentro();
    }

    private double calcularPrecio(double importe, double iva) {
        return importe + iva;
    }

    private double calcularIva(double importe) {

        return importe * IVA;
    }
    private double calcularImporte(double tiempo){
      double tiempoFinal = 0;
      double importe = 0;
      for (int i = 0; i < tramos.length;i++){
          if(tiempo < tramos[i].getLimiteSuperior()){
              tiempoFinal = tramos[i].getLimiteSuperior() - tramos[i].getLimiteInferior();
              importe = importe + tramos[i].calcular(tiempoFinal);
          }else{
              tiempoFinal = tiempo - tramos[i].getLimiteInferior();
              importe = importe + tramos[i].calcular(tiempoFinal);
          }
      }
      return importe;
    }
    private void crearTramos(){
        int nDatos=st.countTokens();
        tramos = new Tramo[nDatos];
        String token;
        double limiteSuperior;
        double limiteInferior;
        double tasa;
        for (int i = 0; i < tramos.length;i++){
            while(st.hasMoreTokens()){
                 token = st.nextToken();
                 
            }
            tramos[i] = new Tramo(1,1,1);
        }
    }
    public void crearTicket(int numeroTicket, Vehiculo v) {
        crearTramos();
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
        ticket.modificarTicket(numeroTicket, v, tiempo, importe,
                                    calcularIva(importe),
                                    calcularPrecio(importe, calcularIva(importe)));
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
                    ticket.imprimir();
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
}