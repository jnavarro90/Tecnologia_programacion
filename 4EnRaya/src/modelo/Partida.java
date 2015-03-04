package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Partida implements Serializable{
    private String nombre;
    private Tablero tablero;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private int turno; 
    public Partida() {
        
    }
    
    public void guardar(){
    
    }
    
    public void recuperar(){
    
    }
    
    public void cambiarTurno(){
        if (turno == 1){
            turno = 2;
        }else{
            turno  = 1;
        }
    }
    
    public void obtenerTablero(){
    
    }
    
}
