/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Javi
 */
public class Salida extends Movimiento{
    int tiempoSalida;

    public boolean registrar(Vehiculo v,int plazaOcupada){
        this.matricula = v.getMatricula();
        this.plazaOcupada = plazaOcupada;
        this.tiempoSalida = v.getTiempoSalida();
    return false;
    }
}
