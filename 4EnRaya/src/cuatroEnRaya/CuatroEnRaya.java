package cuatroEnRaya;

import controlador.Partida;
import java.io.IOException;
/**
 *
 * @author Javi Navarro
 * @version 1.2
 */
public class CuatroEnRaya {
    /**
     * @param args the command line arguments
     */
    public static Partida partidaActual;
    public static void main(String[] args) throws IOException {
        partidaActual = new Partida();
        partidaActual.jugar();
    } 
}
