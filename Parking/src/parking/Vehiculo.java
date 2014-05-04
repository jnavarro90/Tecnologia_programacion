/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Vehiculo {

    private String matricula;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;
    private boolean pagado = false;

    public Vehiculo() {

        //Si se crea sin matricula solo pone la fecha
        fechaEntrada = new GregorianCalendar();
    }

    public Vehiculo(String matricula) {
        //Si se crea con matricula se comprueba si ya habia una fecha de entrada en caso que no tenga fecha de entrada se le pone nueva.
        this.matricula = matricula;
        if (fechaEntrada == null) {
            fechaEntrada = new GregorianCalendar();
        }
    }

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
        return matricula.equals(v.matricula);
    }

    public double obtenerTiempo() {
        double minutos = 0;
        try {
            long diferencia = fechaSalida.getTime().getTime() - fechaEntrada.getTime().getTime();
            minutos = (double) diferencia / (1000 * 60);

        } catch (NullPointerException e) {
            return -1;
        }

        return minutos;
    }

    public boolean pagando() {
        pagado = true;
        return true;
    }
    
    public boolean haPagado(){
        return pagado;
    }
}