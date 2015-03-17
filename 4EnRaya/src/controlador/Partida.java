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
 * @version 1.2
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
        this.leer = new Scanner(System.in);
        this.mensaje("Introduce el nombre del Jugador 1: ");
        this.jugador1 = new Jugador(this.leer.nextLine(), "#");
        this.mensaje("Introduce el nombre del Jugador 2: ");
        this.jugador2 = new Jugador(this.leer.nextLine(), "o");
        this.tablero = new Tablero();
    }
    
    /**
     * El metodo jugar lleva toda la lógica de control del juego
     */
    public void jugar(){
        int opcionCol;
        Jugador jugadorActual;
        this.tablero.dibujar(this.jugador1, this.jugador2, this.turno);
        while(!this.finalPartida){
            if(this.turno){
                jugadorActual = this.jugador1;
            }else{
                jugadorActual = this.jugador2;
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
                if(this.tablero.jugada(opcionCol-1, jugadorActual.getSimbolo())){
                    this.cambiarTurno();
                    
                    this.tablero.dibujar(this.jugador1, this.jugador2, this.turno);
                    if(this.tablero.finDePartida()){
                        this.mensaje("¡Ganador: "+jugadorActual.getNombre()+"!");
                        break;
                    }else if(this.tablero.esEmpate()){
                        this.mensaje("La partida termina en empate.");
                        break;
                    }
                }else{
                    this.mensajeError("No se pudo realizar su jugada, vuelve a intentarlo.");
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
        this.turno = !this.turno;
    }
    
    /**
     *  Pide a un jugador una jugada para que se realize en el juego
     * Este método lo haría la vista
     * @param j
     * @return opcion
     */
    public int pedirJugada(Jugador j){
        int opcion = 0;
        mensaje("\n"+j.getNombre()+" introduce una columna: ");
        try {
            opcion = this.leer.nextInt();
        } catch (InputMismatchException e) {
            leer.next();
            mensajeError("Opcion incorrecta.");
            return -1;
        }
        return opcion;
    }
    
    /**
     * Escribe un mensaje por pantalla 
     * Este método lo haría la vista
     * @param mensaje 
     */
    
    private void mensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    /**
     * Escribe un mensaje de error por pantalla 
     * Este método lo haría la vista
     * @param error 
     */
    private void mensajeError(String error){
        System.out.println("ERROR: "+error);
    }
}