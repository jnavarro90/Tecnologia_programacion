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
   float tiempo;
   float importe;
   float iva;
   float total;

    public Ticket(int numero, Vehiculo v, float tiempo, float importe, float iva, float total) {
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
