/*
 * Clase Tarifa
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase para saber las tasas del parking.
 * @author Javi
 * @version 1
 */
  abstract class Tarifa {
      
  /*Declaracion de variables*/
  private double tasa;
  
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }
    public abstract double calcular(double tiempo);
}
