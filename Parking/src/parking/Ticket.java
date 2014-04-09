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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Vehiculo getV() {
        return v;
    }

    public void setV(Vehiculo v) {
        this.v = v;
    }
   public void modificarTicket(int numero, Vehiculo v, double tiempo, double importe, double iva, double total){
        this.numero = numero;
        this.v = v;
        this.tiempo = tiempo;
        this.importe =importe;
        this.iva = iva;
        this.total = total;
   }
   public abstract boolean imprimir();
}
