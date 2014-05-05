/*
 * Clase Tramo
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que es un tipo de tarifacon limites de tiempo para las tasas.
 * @author Javi
 * @version 1
 */
public class Tramo extends Tarifa {
    
    /*Declaracion de variables*/
    private int limiteInferior;
    private int limiteSuperior;

    /*
     * el constructor de Tramo asigna los valores a las variables de Tramo
     * y al de su clase super(Tarifa).
     */
    public Tramo(int limiteInferior, int limiteSuperior, double tasa) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        super.setTasa(tasa);
    }
    
    /*
     * calcular calcula recibiendo un tiempo segun la tasa el importe, 
     * implementa la clase abstracta calcular de Tarifa.
     */
    public double calcular(double tiempo) {
        return tiempo * getTasa();
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }
    public int getLimiteInferior(){
        return limiteInferior;
    }
}
