/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import utilidades.RecursosAppSwing;
/**
 *
 * @author javi
 */
public class IUGrafica extends JFrame implements ActionListener{
  
    private JButton botonAceptarJugador;
    private JButton botonOpcionMenu;
    private JLabel mensajeJugador;
    private JPanel panel;
    private JTextField nombreJugador;
    private String devolverNombre;
    private MenuJugadorNombre menuJugador;
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
        
        menuJugador = new MenuJugadorNombre("Menu Inicial");
        menuJugador.obtenerOpcionMenu();
    }
    
    public String preguntarNombre(String titulo){
       
        menuJugador = new MenuJugadorNombre("Jugador 1");
        return menuJugador.obtenerNombreJugador(titulo);
    }
    
    public void addControlador(ActionListener controlador){
        menuJugador.addControlador(controlador);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonAceptarJugador){
            mensajeJugador.setText("Tablero actualizado");
            devolverNombre = nombreJugador.getText();
            
        }
    }
}
