/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

/**
 *
 * @author javi
 */
public class FactoriaIU {
    public ElementoIU hacerVentana(){
        return new Ventana();
    }
    public ElementoIU hacerBoton(){
        return new Boton();
    }
    public ElementoIU hacerDesplegable(){
        return new Desplegable();
    }
}
