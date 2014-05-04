/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Javi
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Salida extends Movimiento{
    Calendar fechaSalida;
    String salida;

    public Salida(Vehiculo v,int plazaOcupada) {
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaSalida = v.getFechaSalida();
    }
    public boolean registrar(){
        
        salida = "\nSALIDA\n matricula: "+getMatricula()+".\n Plaza: "+getPlazaOcupada()+".\n Fecha: "+fechaSalida.getTime()+"."+"\n";
         try {
            PrintWriter fOut = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Javi/NetBeansProjects/Tecnologia_programacion/Parking/src/parking/movimientos.txt", true)));
            fOut.write(salida);
            fOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    return true;
    }
}
