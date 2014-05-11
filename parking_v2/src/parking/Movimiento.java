/*
 * Clase Movimiento
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que gestiona los movimientos que se realizan en el parking.
 * @author Javi
 * @version 1
 */
public class Movimiento {
    
    /*Declaracion de variables*/
    private int plazaOcupada;
    private String matricula;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPlazaOcupada(int plazaOcupada) {
        this.plazaOcupada = plazaOcupada;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPlazaOcupada() {
        return plazaOcupada;
    }
    
}
