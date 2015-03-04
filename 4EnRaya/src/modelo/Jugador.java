package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Jugador implements Serializable{
    private String nombre;
    private int color;
    private int ganadas;
    
    public Jugador() {
    
    }
    
    public void victoria(){
        this.ganadas += 1; 
    }
    
    public int miColor(){
        return this.color;
    }
}
