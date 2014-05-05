/*
 * Clase Salida
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que es un tipo de movimiento que registra las salidas en un fichero.
 * @author Javi
 * @version 1
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Salida extends Movimiento{
    
    /*Declaracion de constantes*/
    private final String RUTA ="/Users/Javi/NetBeansProjects/Tecnologia_programacion/Parking/src/parking/";
    
    /*Declaracion de variables*/
    Calendar fechaSalida;
    String salida;

    /*
     * El constructor de Salida asigna los valores a las variables.
     */
    public Salida(Vehiculo v,int plazaOcupada) {
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaSalida = v.getFechaSalida();
    }
    
    /*
     * registrar guarda los datos del movimiento en un fichero.
     */
    public void registrar(){
        
        salida = "\nSALIDA\n matricula: "+getMatricula()+".\n Plaza: "+getPlazaOcupada()+".\n Fecha: "+fechaSalida.getTime()+"."+"\n";
         try {
            PrintWriter fOut = new PrintWriter(new BufferedWriter(new FileWriter(RUTA+"movimientos.txt", true)));
            fOut.write(salida);
            fOut.close();
        } catch (IOException e) {
            System.out.println("Fallo al guardar en un fichero");
        }
    }
}
