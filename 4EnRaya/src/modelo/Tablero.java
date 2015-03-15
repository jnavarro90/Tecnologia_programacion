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
        casillas = new String[MAX_FILAS][MAX_COLUMNAS];
        vaciar();
    }
    
    public void vaciar(){
        for (int i = MAX_FILAS-1;i>0;i--){
            for(int j = 0; j<MAX_COLUMNAS-1;j++){
                casillas[i][j] = ".";
            }
        }
        
    }
    
    public boolean jugada(int c){
     return true;   
    }
    
    public void finPartida(){
        
    }

    public String[][] getCasillas() {
        return casillas;
    }
    
    public void movimientoHecho() {
        this.movimientos += 1;
    }
    
    //Los siguientes metodos los haria la vista
    
    public boolean dibujar(Jugador j1, Jugador j2, Boolean t){
        int ultimaFila = MAX_FILAS;
        System.out.println("|                    |");
        System.out.print("|     4 en Raya      | Jugador: "+j1.getNombre());
        if(t){
            System.out.println("  <<");
        }else{
            System.out.println(" ");
        }
        System.out.print("|____________________| Jugador: "+j2.getNombre());
        if(!t){
            System.out.println("  <<");
        }else{
            System.out.println(" ");
        }
        System.out.println("|  1  2  3  4  5  6  |");
        for (int i = MAX_FILAS-1;i>0;i--){
            if(ultimaFila!=i) System.out.print("| ");
            for(int j = 0; j<MAX_COLUMNAS-1;j++){
                System.out.print(" "+casillas[i][j]+" ");             
            }
            if(ultimaFila!=i) System.out.print(" |\n");
        }
        System.out.print("|--------------------|");
        return true;
    }
}
