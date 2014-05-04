/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Javi
 */
public class Entrada extends Movimiento{
    Calendar fechaEntrada;
    String entrada;

    public Entrada(Vehiculo v,int plazaOcupada) {
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaEntrada = v.getFechaEntrada();
    }
    
    public boolean registrar(){
        entrada = "\nENTRADA\n matricula: "+getMatricula()+".\n Plaza: "+getPlazaOcupada()+".\n Fecha: "+fechaEntrada.getTime()+"."+"\n";
        try {
            PrintWriter fOut = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Javi/NetBeansProjects/Tecnologia_programacion/Parking/src/parking/movimientos.txt", true)));
            fOut.write(entrada);
            fOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    return true;
    }
}