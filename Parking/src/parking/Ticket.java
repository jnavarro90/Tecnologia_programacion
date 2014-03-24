/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public class Ticket {
   int numero;
   Vehiculo v;
   double tiempo;
   double importe;
   double iva;
   double total;

    public Ticket(int numero, Vehiculo v, double tiempo, double importe, double iva, double total) {
        this.numero = numero;
        this.v = v;
        this.tiempo = tiempo;
        this.importe = importe;
        this.iva = iva;
        this.total = total;
    }
   
   private boolean imprimir(){
   
        return false;
   }
}
