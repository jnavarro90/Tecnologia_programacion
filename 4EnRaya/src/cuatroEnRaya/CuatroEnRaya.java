package cuatroEnRaya;

import controlador.Partida;
import java.io.IOException;
import vista.IUGrafica;
/**
 *
 * @author Javi Navarro
 * @version 1.2
 */
public class CuatroEnRaya {
    public static Partida partidaActual;
    public static IUGrafica vista;
    public static void main(String[] args) throws IOException {
        vista = new IUGrafica();
        partidaActual = new Partida(vista);
        vista.addControlador(partidaActual);
            
        while(true){        
            if(partidaActual.jugar()){
                partidaActual.mensaje("Volver a jugar.");
            }else{
                partidaActual.mensaje("Salir del juego.");
                break;
            }
        } 
    } 
}
