package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Jugador implements Serializable{
    private String nombre;
    private String simbolo;
    private int ganadas;
    
    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }
    
    public void victoria(){
        this.ganadas += 1; 
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Jugador "+this.nombre;
    }

    
}