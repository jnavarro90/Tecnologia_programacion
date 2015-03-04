package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Tablero implements Serializable{
    private Ficha casillas[][];
    private int movimientos;
    public Tablero() {
        
    }
    
    public void vaciarTablero(){
    
    }
    
    public void fichaValida(Ficha f){
    
    }
    
    public void comprobarLineas(){
    
    }

    public Ficha[][] getCasillas() {
        return casillas;
    }
    
    public void movimientoHecho() {
        this.movimientos += 1;
    }
}
