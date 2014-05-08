/*
 * Clase Vehiculo
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase almacena los datos de un vehiculo.
 * @author Javi
 * @version 1
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Vehiculo {

    /*Declaracion de variables*/
    private String matricula;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;
    private boolean pagado = false;

    /*
     * El constructor de Vehiculo necesita una matricula la 
     * asigna al vehiculo y le pone la fecha de entrada.
     */
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        fechaEntrada = new GregorianCalendar();
    }
    
    /*
     * asignarFechaSalida le asigna una fecha de salida.
     */
    public void asignarFechaSalida() {
        fechaSalida = new GregorianCalendar();
    }

    public String getMatricula() {
        return matricula;
    }

    public Calendar getFechaEntrada() {
        return fechaEntrada;
    }

    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    public boolean equals(Object o) {

        Vehiculo v = (Vehiculo) o;
        return matricula.equals(v.getMatricula());
    }
    
    /*
     * pagando pone pagado a true.
     */
    public boolean pagando() {
        pagado = true;
        return true;
    }
    
    /*
     * haPagado devuelve si el vehiculo ha pagado.
     */
    public boolean haPagado(){
        return pagado;
    }
}