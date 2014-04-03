/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Javi
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Salida extends Movimiento{
    Calendar fechaSalida;

    public boolean registrar(Vehiculo v,int plazaOcupada){
        this.matricula = v.getMatricula();
        this.plazaOcupada = plazaOcupada;
        this.fechaSalida = v.getFechaSalida();
        System.out.println("SALIDA\n matricula: "+matricula+".\n Plaza: "+plazaOcupada+".\n Fecha: "+fechaSalida.getTime()+".");
    return true;
    }
}
