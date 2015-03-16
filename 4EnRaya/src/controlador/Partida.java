package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
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
    private boolean finalPartida;
    private Scanner leer;
    public Partida() throws IOException {
        this.finalPartida = false;
        this.turno = true;
        leer = new Scanner(System.in);
        this.mensaje("Introduce el nombre del Jugador 1: ");
        jugador1 = new Jugador(leer.nextLine(), "#");
        mensaje("Introduce el nombre del Jugador 2: ");
        jugador2 = new Jugador(leer.nextLine(), "o");
        tablero = new Tablero();
    }
    
    /**
     * El metodo jugar lleva toda la lógica de control del juego
     */
    public void jugar(){
        int opcionCol;
        Jugador jugadorActual;
        tablero.dibujar(jugador1, jugador2, turno);
        while(!finalPartida){
            if(turno){
                jugadorActual = jugador1;
            }else{
                jugadorActual = jugador2;
            }
            opcionCol = pedirJugada(jugadorActual);
            /**
             * Si la opcion no es -1 no hay error y si hay error 
             * seguira sin saltar turno
            */
            if(opcionCol != -1){
                /**
                 * Si la jugada es correcta inserta la ficha si no seguira 
                 * sin saltar turno
                 */
                if(tablero.jugada(opcionCol-1, jugadorActual.getSimbolo())){
                    this.cambiarTurno();
                    //this.limpiarPantalla();
                    tablero.dibujar(jugador1, jugador2, turno);
                }else{
                    mensajeError("No se pudo realizar su jugada, vuelve a intentarlo.");
                }
            }
        }
    }
    /**
     * 
     */
    public void guardar(){
    
    }
    /**
     * 
     */
    public void cargar(){
    
    }
    /**
     * Cambia la variable turno de valor
     */
    public void cambiarTurno(){
        turno = !turno;
    }
    
    /**
     *  Pide a un jugador una jugada para que se realize en el juego
     * @param j
     * @return opcion
     * @throws java.io.IOException
     */
    public int pedirJugada(Jugador j){
        int opcion;
        mensaje("\n"+j.getNombre()+" introduce un columna: ");
        try {
            opcion = leer.nextInt();
        } catch (InputMismatchException ex) {
            opcion = -1;
            mensajeError("Opcion incorrecta.");
        }
        return opcion;
    }
    
    /**
     * Escribe un mensaje por pantalla 
     * Este método lo haria la vista
     * @param mensaje 
     */
    
    private void mensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    /**
     * Escribe un mensaje de error por pantalla 
     * Este metodo lo haria la vista
     * @param error 
     */
    private void mensajeError(String error){
        System.out.println("ERROR: "+error);
    }
    
    private void limpiarPantalla(){
    try{
        String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            Runtime.getRuntime().exec("cls");
        }else{
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        this.mensajeError("No se pudo limpiar la pantalla.");
    }
}
}
