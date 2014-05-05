/*
 * Clase Ticket
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase abstracta que contiene los datos de un ticket.
 * tiene una clase imprimir para que todos los tickets que se creen tengan ese
 * metodo implementandolo cada uno.
 * @author Javi
 * @version 1
 */
abstract class Ticket {
    
   /*Declaracion de variables*/
   private int numero;
   private Vehiculo v;
   private double tiempo;
   private double importe;
   private double iva;
   private double total;

   /*
     * El constructor de Ticket asigna a cada variable sus valores.
     */
    public Ticket(int numero, Vehiculo v, double tiempo, double importe, 
            double iva, double total) {
        this.numero = numero;
        this.v = v;
        this.tiempo = tiempo;
        this.importe = importe;
        this.iva = iva;
        this.total = total;
    }

    public double getImporte() {
        return importe;
    }

    public double getIva() {
        return iva;
    }

    public int getNumero() {
        return numero;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getTotal() {
        return total;
    }

    public Vehiculo getV() {
        return v;
    }
    
   public abstract boolean imprimir();
}
