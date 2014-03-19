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
    int fechaSalida;
    int tiempoSalida;

    public boolean registrar(Vehiculo v,int plazaOcupada){
        this.matricula = v.getMatricula();
        this.plazaOcupada = plazaOcupada;
        this.fechaSalida = v.getFechaSalida();
        System.out.println("Sale el vehiculo matricula: "+matricula+", deja libre la plaza: "+plazaOcupada+", a fecha: "+fechaSalida);
    return true;
    }
}
