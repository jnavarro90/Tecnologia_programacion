package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import modelo.Jugador;
import modelo.Tablero;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Partida implements Serializable{
    private String nombre;
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turno; 
    private BufferedReader br;
    public Partida() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        jugador1 = new Jugador(br.readLine(), "#");
        jugador2 = new Jugador(br.readLine(), "o");
        tablero = new Tablero();
    }
    public void jugar(){
        
    }
    public void guardar(){
    
    }
    
    public void cargar(){
    
    }
    
    public void cambiarTurno(){
        
    }
}
