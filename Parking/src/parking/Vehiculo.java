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
    private String matricula;
    private int tiempoEntrada;
    private int tiempoSalida;

    public Vehiculo() {
        
    }
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        tiempoEntrada = 300;
    }
    public void setTiempoSalida(int tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public int getTiempoSalida() {
        return tiempoSalida;
    }
    
}