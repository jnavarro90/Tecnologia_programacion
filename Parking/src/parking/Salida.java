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

    public Salida(Vehiculo v,int plazaOcupada) {
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaSalida = v.getFechaSalida();
    }
    public boolean registrar(){
        
        System.out.println("SALIDA\n matricula: "+getMatricula()+".\n Plaza: "+getPlazaOcupada()+".\n Fecha: "+fechaSalida.getTime()+".");
    return true;
    }
}
