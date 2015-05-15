/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Jugador;
import utilidades.RecursosAppSwing;

/**
 *
 * @author javi
 */
public class IUGrafica extends JFrame{
  
    private String devolverNombre;
    private MenuVista menuJugador;
    private TableroSwing tablero;
    public final String CARGAR_PARTIDA = "Cargar Partida";
    public final String GUARDAR_PARTIDA = "Guardar Partida";
    public final String VOLVER = "Volver";
    public final String ERROR = "Error";
    public final String NUEVA_PARTIDA = "Nueva Partida";
    public final String SALIR = "Salir";
    public final String ACERCA_DE = "Acerca de ..";
    public IUGrafica(){
        /*
        SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() { 
        try {
          // Lenguaje español
          //RecursosAppSwing recSwingApp = RecursosAppSwing.instancia("es.xml");
          
          // Lenguaje inglés
          RecursosAppSwing recSwingApp = RecursosAppSwing.instancia("en.xml");
          TableroSwing tableroSwing = 
            new TableroSwing(8, 16, recSwingApp); 
        } catch (Exception ex) {
          Logger.getLogger(TableroSwing.class.getName()).log(Level.SEVERE, 
                                                             null, ex);
        }       
      }
    });	
                */
        
    }

    public void menuInicial(){
        menuJugador = new MenuVista("Menu Inicial");
        menuJugador.obtenerOpcionMenu();
    }
    
    public String preguntarNombre(String titulo){
       
        menuJugador = new MenuVista("Jugador 1");
        return menuJugador.obtenerNombreJugador(titulo);
    }
    
    public void pintarTablero(Jugador j1, Jugador j2){
        RecursosAppSwing recSwingApp = RecursosAppSwing.instancia("es.xml");
        tablero = new TableroSwing(8, 16, recSwingApp);
    }
    public void addObservadorMenus(Observador controlador){
        menuJugador.nuevoObservador(controlador);
    }
    
    public void addObservadorTablero(Observador controlador){
        tablero.nuevoObservador(controlador);
    }
}
