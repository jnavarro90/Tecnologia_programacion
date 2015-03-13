package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class Tablero implements Serializable{
    private final int  MAX_COLUMNAS = 7;
    private final int MAX_FILAS = 6;
    private String casillas[][];
    private int movimientos;
    public Tablero() {
        vaciar();
    }
    
    public void vaciar(){
        int fila = 0;
        int columna = 0;
        
    }
    
    public void fichaValida(int c){
    
    }
    
    public void comprobarLineas(){
    
    }

    public String[][] getCasillas() {
        return casillas;
    }
    
    public void movimientoHecho() {
        this.movimientos += 1;
    }
}
