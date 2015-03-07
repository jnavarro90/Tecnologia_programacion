package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Tablero implements Serializable{
    private int casillas[][];
    private int movimientos;
    public Tablero() {
        
    }
    
    public void vaciarTablero(){
    
    }
    
    public void fichaValida(int c){
    
    }
    
    public void comprobarLineas(){
    
    }

    public int[][] getCasillas() {
        return casillas;
    }
    
    public void movimientoHecho() {
        this.movimientos += 1;
    }
}
