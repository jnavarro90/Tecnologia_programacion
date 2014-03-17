/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public class Vehiculo {
    String matricula;
    int tiempoEntrada;
    int tiempoSalida;

    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public void setTiempoEntrada(int tiempoEntrada) {
        this.tiempoEntrada = tiempoEntrada;
    }

    public int getTiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(int tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }
    
}
