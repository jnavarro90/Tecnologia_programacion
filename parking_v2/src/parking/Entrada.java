/*
 * Clase Entrada
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que es un tipo de movimiento que registra las entradas en un fichero.
 * @author Javi
 * @version 1
 */
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
    
    /*Declaracion de variables*/
    Calendar fechaEntrada;
    String entrada;

    /*
     * El constructor de Entrada asigna los valores a las variables.
     */
    public Entrada(Vehiculo v,int plazaOcupada) {
        setMatricula(v.getMatricula());
        setPlazaOcupada(plazaOcupada);
        this.fechaEntrada = v.getFechaEntrada();
    }
    
    /*
     * registrar guarda los datos del movimiento en un fichero.
     */
    public void registrar(){
        entrada = "\nENTRADA\n matricula: "+getMatricula()+".\n Plaza: "
                +getPlazaOcupada()+".\n Fecha: "+fechaEntrada.getTime()+
                "."+"\n";
        try {
            PrintWriter fOut = new PrintWriter(new BufferedWriter(
                    new FileWriter("./movimientos.txt", true)));
            fOut.write(entrada);
            fOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}