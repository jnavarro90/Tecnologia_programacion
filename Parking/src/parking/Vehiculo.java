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
    private int fechaEntrada;
    private int fechaSalida;

    private int tiempoEntrada;
    private int tiempoSalida;


    public Vehiculo() {
        
    }
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        fechaEntrada = 300;

    }
    public void setFechaSalida(int tiempoSalida) {
        this.fechaSalida = tiempoSalida;
        tiempoEntrada = 300;
    }
    public void setTiempoSalida(int tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getFechaEntrada() {
        return fechaEntrada;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }

    public boolean equals(Object o) {
        
        Vehiculo v = (Vehiculo)o;
        return matricula.equals(v.matricula);
    }
    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public int getTiempoSalida() {
        return tiempoSalida;
    }
    
}