/*
 * Clase Plaza
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que contiene un vehiculo, tiene un numero asociado.
 * @author Javi
 * @version 1
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Plaza {
    
    /*Declaracion de constantes*/
    private final int OCUPADO = 1;
    private final int LIBRE = 0;
    
    /*Declaracion de variables*/
    int numero;
    int estado;
    Vehiculo v;
    /*
     * el constructor de la clase Plaza le pone un numero y lo pone a libre.
     */
    public Plaza(int numero) {
        this.numero = numero;
        this.estado = LIBRE;
    }
    
    /*
     * ocupar le asigna un vehiculo a la plaza y la pone ocupada.
     */
    public boolean ocupar(Vehiculo v){
        this.v = v;
        this.estado = OCUPADO;
        return true;
    }
    
    /*
     * desocupar retira un vehiculo de la plaza y la pone libre.
     */
    public boolean desocupar(){
        this.v = null;
        this.estado = LIBRE;
        return true;
    }
    
    /*
     * ocupada devuelve el estado de la plaza siendo true ocupada y false libre.
     */
    public boolean ocupada(){
        return this.estado == OCUPADO;
    }
    
    /*
     * obtenerVehiculo devuelbe el objeto vehiculo que contiene la plaza.
     */
    public Vehiculo obtenerVehiculo(){
        return v;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Vehiculo){
        Vehiculo v = (Vehiculo)obj;
        }
        return this.v.equals(v);
    }
    /*
     * Modificion de hashCode porque lo voy a usar con hashMap.
    */
    public int hashCode() {
        int resultado = 7;
        resultado = 89 * resultado + v.hashCode();
        return 89 * resultado + (int)numero;
    }
    
}
