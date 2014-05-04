/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
  abstract class Tarifa {
  private double tasa;


    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }
    public abstract double calcular(double tiempo);
}
