/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Javi
 */
public class Entrada extends Movimiento{
    int tiempoEntrada;
    public boolean registrar(Vehiculo v,int plazaOcupada){
        this.matricula = v.getMatricula();
        this.plazaOcupada = plazaOcupada;
        this.tiempoEntrada = v.getTiempoEntrada();
        
        
    return false;
    }
}
