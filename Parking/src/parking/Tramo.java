package parking;

/**
 *
 * @author javi
 * 
 */
public class Tramo extends Tarifa {
    private int limite;
    private double tasa;

    public Tramo(int limite, double tasa) {
        this.limite = limite;
        this.tasa = tasa;
    }
    
    public double calcular(double tiempo) {
        return tiempo * tasa;
    }

    public int getLimite() {
        return limite;
    }
}
