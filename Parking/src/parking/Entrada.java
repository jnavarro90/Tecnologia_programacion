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
        this.matricula = v.getMatricula();
        this.plazaOcupada = plazaOcupada;
        this.fechaEntrada = v.getFechaEntrada();
        System.out.println("Entra el vehiculo matricula: "+matricula+", ocupando la plaza: "+plazaOcupada+", a fecha: "+fechaEntrada);
    return false;
    }
}
