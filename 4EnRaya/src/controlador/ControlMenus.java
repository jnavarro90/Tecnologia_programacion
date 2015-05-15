/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.IUGrafica;
import vista.Observador;

/**
 *
 * @author Javi
 */

public class ControlMenus implements Observador{
    private final String CARGAR_PARTIDA = "Cargar Partida";
    private final String GUARDAR_PARTIDA = "Guardar Partida";
    private final String VOLVER = "Volver";
    private final String ERROR = "Error";
    private final int ERROR_NUM = -1;
    private final String NUEVA_PARTIDA = "Nueva Partida";
    private final String SALIR = "Salir";
    private IUGrafica vista;
    private Partida partida;
    private String opcionMenu = " ";

    public ControlMenus(IUGrafica _vista) {
        this.vista = _vista;
        
    }
    public void menuInicial(){
        this.vista.addObservadorMenus(this);
        this.vista.menuInicial();
    }

    @Override
    public void actualiza(Object obj) {
        if (obj instanceof String) { 
            this.partida.cambiarOpcionMenu((String)obj); 
        }
    }
}
