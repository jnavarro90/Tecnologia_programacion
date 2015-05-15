/**
 * TableroVista.java
 * 19-abr-2012
 * @author ccatalan
 * 
 *  Version 1.1
 *  27-abr-2012
 *  Modificaciones para mejora la separación MVC
 *    - TableroBarcos pasa a llamarse TableroVista
 *    - Recibe evento pero no modifica casilla únicamente notifica a 
 *      los posibles observadores
 */
package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 * Un tablero es una panel con una matriz de Casillas.
 */
public class TableroVista extends JPanel {
  private static final int ALTURA_FILA = 60;
  private static final int ANCHURA_COLUMNA = 20;
  private CasillaVista casillas[][];
  private java.util.List<Observador> observadores = new ArrayList<>();

  public static final boolean RECIBIR_EVENTOS_RATON = true;
  public static final boolean NO_RECIBIR_EVENTOS_RATON = false;

  /**
   * TableroVista
   */
  TableroVista(int filas, int columnas, 
                boolean recibe_eventos_raton, String rutaRecursos) {   
    
    setLayout(new GridLayout(filas, columnas));
    casillas = new CasillaVista[filas][columnas];
    
    for(int fil = 0; fil < filas; fil++) 
      for(int col = 0; col < columnas; col++) {
        casillas[fil][col] = new CasillaVista(fil, col);         
        add(casillas[fil][col]);      
        if (recibe_eventos_raton) {
          casillas[fil][col].addMouseListener(new MouseAdapter() { 
          @Override
            public void mousePressed(MouseEvent e) {
              notifica((CasillaVista)e.getSource());   
	        }
 	      });
        }
      } 
    this.setPreferredSize(new Dimension(filas * ALTURA_FILA, 
                                        columnas * ANCHURA_COLUMNA));
  }

  /**
   * dimensionCasilla
   */  
  public Dimension dimensionCasilla() {
    return casillas[0][0].getSize();
  }
 
  Icon getIconCasilla(CasillaVista casilla) {
    return casilla.getIcon();
  }
  
  /**
   * poner
   */   
  public void ponerIconoCasilla(int fil, int col, Icon icono) {
    casillas[fil][col].setIcon(icono);
  }
 
  /**
   * nuevoObservador
   */   
  public void nuevoObservador(Observador observador) {
    observadores.add(observador);
  }
  
  /**
   * notifica
   */  
  public void notifica(CasillaVista casillaVista) {
    for(Observador observador: observadores){
        observador.actualiza(casillaVista);
    }    
  }
}
