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

    public Ticket(int numero, Vehiculo v, float tiempo) {
        this.numero = numero;
        this.v = v;
        this.tiempo = tiempo;
    }
   
   private boolean imprimir(){
   return false;
   }
   private boolean modificar(){
       
   return false;
   }
}
