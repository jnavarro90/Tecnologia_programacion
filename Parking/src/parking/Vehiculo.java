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
    private Calendar c = Calendar.getInstance();
    
    public Vehiculo() {
        
    }
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        fechaEntrada = new GregorianCalendar();
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
        
        Vehiculo v = (Vehiculo)o;
        return matricula.equals(v.matricula);
    }  
    public float obtenerTiempo(){

        return 0;
    }
}