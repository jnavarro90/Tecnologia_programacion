package modelo;

import java.io.Serializable;

/**
 *
 * @author Javi Navarro
 * @version 1.2
 */
public class Tablero implements Serializable{
    private final int  MAX_COLUMNAS = 7;
    private final int MAX_FILAS = 6;
    private String casillas[][];
    private int ultimaCol;
    private int ultimaFil;
    private int movimientos;
    public Tablero() {
        this.casillas = new String[MAX_FILAS][MAX_COLUMNAS];
        vaciar();
    }
    
    public void vaciar(){
        for (int i = MAX_FILAS-1;i>0;i--){
            for(int j = 0; j<MAX_COLUMNAS-1;j++){
                this.casillas[i][j] = ".";
            }
        }
        this.movimientos = 0;
        
    }
    /**
     * El metodo jugada comprobara si se puede hacer la jugada que el jugador
     * ha introducido
     * @param col: columna en la que se quiere introducir la ficha
     * @param sim: El simbolo de la ficha
     * @return true o false dependiendo si se ha realizado bien o mal 
     * la insercion de la ficha
     */
    public boolean esJugadaValida(int col, String sim){
        if(col< MAX_COLUMNAS-1 && col >= 0){
            for(int i = 1; i < MAX_FILAS; i++){ 
               if(this.casillas [i][col].equals(".")){  
                    this.casillas[i][col] = sim;
                    /**
                     * Guarda la ultima fila y la ultima columna 
                     * para la comprobacion y suma 1 a los movimientos.
                     */
                    this.ultimaCol = col;
                    this.ultimaFil = i;
                    this.movimientoHecho();
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
    
    /**
     * EL metodo finDePartida lleva toda la logica de comprobar si se ha hecho 
     * cuatro en raya en diagonal, horizontal o vertical.
     * @return true si en el final de la partida y false si no lo es
     */
    public boolean finDePartida(){
        //Horizontal
        if(this.comprHorizontal()) return true;
        //Vertical
        if(this.comprVertical()) return true;
        //Diagonal izquierda
        if(this.comprDiagonalIzq()) return true;
        //Diagonal derecha
        if(this.comprDiagonalDer()) return true;
        /**
         * Si uno de los anteriores if es true saldra con true y si no 
         * llega aqui con false
         */
        return false;
    }

    /**
    * El metodo comprHorizontal comprueba si se ha producido cuatro en raya
    * comprobando con dos iteradores en la posicon horizontal 
    * @return true si hay cuatro en raya y false si no lo hay
    */
    private boolean comprHorizontal(){
        int iteradorDer = ultimaCol+1;
        int iteradorIzq = ultimaCol-1;
        int cont = 1;
        boolean itIz = true;
        boolean itDe = true;
        while(true){
            //comprueba que este dento del tablero las comprobaciones
            if(iteradorDer > 5){
                itDe = false;
            }
            if(iteradorIzq < 0){
                itIz = false;
            }
            
            if(itDe){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[ultimaFil][iteradorDer])){
                    cont++;
                    iteradorDer++;
                }else{
                    itDe = false;
                }
            }
            if(itIz){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[ultimaFil][iteradorIzq])){
                    cont++;
                    iteradorIzq--;
                }else{
                    itIz = false;
                }
            }
            if(cont == 4){ //Si ha encontrado 4 fichas iguales devuelve true
                return true;
            }else if(!itDe && !itIz){ //Si no puede avanzar por la derecha ni por la izquierda sale del bucle
                break;
            }
        }
        return false;
    }
    
    /**
    * El metodo comprVertical comprueba si se ha producido cuatro en raya
    * comprobando con dos iteradores en la posicon vertical 
    * @return true si hay cuatro en raya y false si no lo hay
    */
    private boolean comprVertical(){
        int iteradorBot = ultimaFil-1;
        int cont = 1;
        boolean itbot = true;    
        while(true){
            
            //comprueba que este dento del tablero las comprobaciones
            if(iteradorBot < 1){
                itbot = false;
            }
            if(itbot){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[iteradorBot][ultimaCol])){
                    cont++;
                    iteradorBot--;
                }else{
                    itbot = false;
                }
            }
            if(cont == 4){ //Si ha encontrado 4 fichas iguales devuelve true
                return true;
            }else if(!itbot){ //Si no puede avanzar hacia abajo sale del bucle
                break;
            }
        }
        return false;
    }
   
    /**
    * El metodo comprDiagonalDer comprueba si se ha producido cuatro en raya
    * comprobando con dos iteradores para derecha y otros dos para la derecha
    * en la posicon diagonal hacia la derecha 
    * @return true si hay cuatro en raya y false si no lo hay
    */
    private boolean comprDiagonalDer(){
        int iteradorDiaDerfil = ultimaFil+1;
        int iteradorDiaDercol = ultimaCol+1;
        int iteradorDiaIzqfil = ultimaFil-1;
        int iteradorDiaIzqcol = ultimaCol-1;
        int cont = 1;
        boolean ittop = true;
        boolean itbot = true;    
        while(true){
            
            //comprueba que este dento del tablero las comprobaciones
            if(iteradorDiaDercol > 5 || iteradorDiaDerfil > 5){
                ittop = false;
            }
            if(iteradorDiaIzqcol < 0  || iteradorDiaIzqfil < 0){
                itbot = false;
            }
            
            if(ittop){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[iteradorDiaDerfil][iteradorDiaDercol])){
                    cont++;
                    iteradorDiaDerfil++;
                    iteradorDiaDercol++;
                }else{
                    ittop = false;
                }
            }
            if(itbot){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[iteradorDiaIzqfil][iteradorDiaIzqcol])){
                    cont++;
                    iteradorDiaIzqfil--;
                    iteradorDiaIzqcol--;
                }else{
                    itbot = false;
                }
            }
            if(cont == 4){ //Si ha encontrado 4 fichas iguales devuelve true
                return true;
            }else if(!ittop && !itbot){ //Si no puede avanzar por la derecha ni por la izquierda sale del bucle
                break;
            }
        }
        
        return false;
    }
    
    /**
    * El metodo comprDiagonalIzq comprueba si se ha producido cuatro en raya
    * comprobando con dos iteradores para derecha y otros dos para la derecha
    * en la posicon diagonal hacia la izquierda 
    * @return true si hay cuatro en raya y false si no lo hay
    */
    private boolean comprDiagonalIzq(){
        int iteradorDiaDerfil = ultimaFil-1;
        int iteradorDiaDercol = ultimaCol+1;
        int iteradorDiaIzqfil = ultimaFil+1;
        int iteradorDiaIzqcol = ultimaCol-1;
        int cont = 1;
        boolean ittop = true;
        boolean itbot = true;    
        while(true){
            //comprueba que este dento del tablero las comprobaciones
            if(iteradorDiaDercol > 5 || iteradorDiaDerfil < 1){
                ittop = false;
            }
            if(iteradorDiaIzqcol < 0  || iteradorDiaIzqfil >5){
                itbot = false;
            }
            
            if(ittop){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[iteradorDiaDerfil][iteradorDiaDercol])){
                    cont++;
                    iteradorDiaDerfil--;
                    iteradorDiaDercol++;
                }else{
                    ittop = false;
                }
            }
            if(itbot){
                if(this.casillas[ultimaFil][ultimaCol].equals(this.casillas[iteradorDiaIzqfil][iteradorDiaIzqcol])){
                    cont++;
                    iteradorDiaIzqfil++;
                    iteradorDiaIzqcol--;
                }else{
                    itbot = false;
                }
            }
            if(cont == 4){ //Si ha encontrado 4 fichas iguales devuelve true
                return true;
            }else if(!ittop && !itbot){ //Si no puede avanzar por la derecha ni por la izquierda sale del bucle
                break; 
            }
        }
        return false;
    }
    
    
    /**
     * El metodo esEmpate comprueba si el juego acaba en empate
     * @return true si hay empate false si no hay empate
     */
    public boolean esEmpate(){
        int totalCasillas = (MAX_COLUMNAS-1)*(MAX_FILAS-1);
        return movimientos == (totalCasillas);
    }
    
    public String[][] getCasillas() {
        return this.casillas;
    }
    
    public void movimientoHecho() {
        this.movimientos += 1;
    }
    
    /**
     * Dibuja el tablero en la pantalla
     * Este metodo lo haria la vista
     * @return  
     */
    
    public boolean dibujar(Jugador j1, Jugador j2, Boolean t){
        int ultimaFila = MAX_FILAS;
        System.out.println("|                    |Marcador");
        System.out.print("|     4 en Raya      | "+j1.getGanadas()+"\t"+j1.getNombre());
        if(t){
            System.out.println("  <<");
        }else{
            System.out.println(" ");
        }
        System.out.print("|____________________| "+j2.getGanadas()+"\t"+j2.getNombre());
        if(!t){
            System.out.println("  <<");
        }else{
            System.out.println(" ");
        }
        System.out.println("|  1  2  3  4  5  6  |");
        for (int i = MAX_FILAS-1;i>0;i--){
            if(ultimaFila!=i) System.out.print("| ");
            for(int j = 0; j<MAX_COLUMNAS-1;j++){
                System.out.print(" "+this.casillas[i][j]+" ");             
            }
            if(ultimaFila!=i) System.out.print(" |\n");
        }
        System.out.print("|--------------------|   Movimientos: "+this.movimientos+"\n");
        return true;
    }
}
