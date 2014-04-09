/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public abstract class Tarifa {
  private double tasa;
  public abstract double calcular(double tiempo);

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }
  
}
