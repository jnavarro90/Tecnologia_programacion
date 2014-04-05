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
  
  public boolean leerTramos(){
  return false;
  }
  
  public abstract double calcularImporte(double tiempo);
}
