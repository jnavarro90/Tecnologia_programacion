/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Javi
 */
public class Entrada extends Movimiento{
    Calendar fechaEntrada;
    public boolean registrar(Vehiculo v,int plazaOcupada){
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaEntrada = v.getFechaEntrada();
        System.out.println(" ENTRADA\n matricula: "+getMatricula()+".\n Plaza: "+getPlazaOcupada()+".\n Fecha: "+fechaEntrada.getTime()+".");
    return true;
    }
}