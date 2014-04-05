/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public class Movimiento {
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
