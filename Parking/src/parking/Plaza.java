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
public class Plaza {
    private final int OCUPADO = 1;
    private final int LIBRE = 0;
    int numero;
    int estado;
    Vehiculo v;

    public Plaza(int numero) {
        this.numero = numero;
        this.estado = LIBRE;
    }

    public boolean ocupar(Vehiculo v){
        this.v = v;
        this.estado = OCUPADO;
        return true;
    }
    public boolean desocupar(){
        this.v = null;
        this.estado = LIBRE;
        return true;
    }
    public boolean ocupada(){
        return this.estado == OCUPADO;
    }
    
    public boolean equals(Object obj) {
        Vehiculo v = (Vehiculo)obj;
        return this.v.equals(v);
    }
}
