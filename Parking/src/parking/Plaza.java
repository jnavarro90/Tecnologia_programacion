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
    int numero;
    String estado;
    Vehiculo v;
    Calendar calendar = new GregorianCalendar();

    public Plaza() {
    }
    public boolean ocupar(Vehiculo v, int i){
    
        return false;
    }
    public boolean desocupar(Vehiculo v){
        
        return false;
    }
}
