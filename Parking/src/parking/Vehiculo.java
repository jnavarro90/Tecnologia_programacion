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
            fechaSalida.add(Calendar.SECOND,fechaEntrada.get(Calendar.SECOND));
            fechaSalida.add(Calendar.MINUTE,fechaEntrada.get(Calendar.MINUTE));
            fechaSalida.add(Calendar.HOUR, fechaEntrada.get(Calendar.HOUR));
            fechaSalida.add(Calendar.MONTH, fechaEntrada.get(Calendar.MONTH));
            fechaSalida.add(Calendar.YEAR,fechaEntrada.get(Calendar.YEAR));
            
            System.out.println(fechaSalida.getTime());
        return 0;
    }
}