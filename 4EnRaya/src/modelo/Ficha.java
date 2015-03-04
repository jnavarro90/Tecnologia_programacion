package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 
 */
public class Ficha implements Serializable{
    private int color;
    private int fila;
    private int columna;
    public Ficha() {
    
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public String toString() {
        return " "+ color + " ";
    }
}
