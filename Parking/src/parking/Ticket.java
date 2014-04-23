/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
abstract class Ticket {
   private int numero;
   private Vehiculo v;
   private double tiempo;
   private double importe;
   private double iva;
   private double total;

    public Ticket(int numero, Vehiculo v, double tiempo, double importe, double iva, double total) {
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
