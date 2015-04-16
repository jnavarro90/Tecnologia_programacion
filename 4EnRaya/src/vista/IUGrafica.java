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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import utilidades.RecursosAppSwing;

/**
 *
 * @author javi
 */
public class IUGrafica extends JFrame implements ActionListener{
  /** Identificadores de textos dependientes de idioma */
  private static final String MENU_FICHERO = "MENU_FICHERO";
  private static final String MENU_ITEM_SALIR = "MENU_ITEM_SALIR";
  private static final String MENU_AYUDA = "MENU_AYUDA";
  private static final String MENU_ITEM_ACERCA_DE = "MENU_ITEM_ACERCA_DE";
  private static final String ETIQUETA_CONTRINCANTE = "CONTRINCANTE";
  private static final String BOTON_INVITAR = "BOTON_INVITAR";
  private static final String ESTADO_TABLERO = "ESTADO_TABLERO";
  private RecursosAppSwing recSwingApp;
  private JList listaJugadores;
  private JLabel contrincante;
  private DefaultListModel jugadores;
  private JButton botonInvitar;
  private JLabel estadoTablero;
  private JPanel panel;

    public int menuInicial(){
        JTextField txtTexto=new JTextField();
        panel = new JPanel();
        botonInvitar = new JButton("OK");
        botonInvitar.addActionListener(this);
        estadoTablero = new JLabel();
        panel.add(botonInvitar, BorderLayout.NORTH);
        panel.add(estadoTablero, BorderLayout.SOUTH);
        panel.add(txtTexto, BorderLayout.CENTER);
        this.add(panel);
        return 0;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonInvitar){
            estadoTablero.setText("Tablero actualizado");
        }
    }
  
}
