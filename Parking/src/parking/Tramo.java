package parking;

/**
 *
 * @author javi
 * 
 */
public class Tramo extends Tarifa {
    private int limiteInferior;
    private int limiteSuperior;

    public Tramo(int limiteInferior, int limiteSuperior, double tasa) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        setTasa(tasa);
    }
    
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
