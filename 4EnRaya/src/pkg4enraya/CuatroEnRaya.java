package pkg4enraya;

import controlador.ControlJuego;
/**
 *
 * @author Javi Navarro
 * @version 1
 */
public class CuatroEnRaya {
    /**
     * @param args the command line arguments
     */
    public static ControlJuego control;
    public static void main(String[] args) {
        control = new ControlJuego();
        control.comenzar();
    }
    
}
