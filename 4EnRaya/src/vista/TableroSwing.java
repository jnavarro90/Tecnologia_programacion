/**
 * TableroSwing2.java
 * 19-abr-2012
 * @author ccatalan
 * 
 * Version 1.0
 * Ejemplo tablero aplicación Swing
 * Demos de:
 *   - Uso de Manager Layouts
 *   - Empleo de JLabel para la representación en pantalla de un tablero.
 *   - Dimensionamiento de la ventana principal automático según el tamaño del
 *     tablero.
 *   - Indicación con el ratón de la tirada, visualización y selección de 
 *     contricante.
 *   - Empleo de un paquete para recursos (imágenes, textos, etc.)
 *   - Recursos internacionalizables mediante fichero XML, accedido con
 *     clases reutilizables.
 * 
 *  Version 1.1
 *  27-abr-2012
 *  Modificaciones para mejorar la separación MVC
 *    - TableroBarcos pasa a llamarse TableroVista
 *    - TableroVista es modificado en método actualiza 
 *    - Cambio en el main al inicializar los recursos
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilidades.RecursosAppSwing;

/**
 * Tablero Swing
 */
public class TableroSwing extends JFrame implements ActionListener, Observador {  
  private RecursosAppSwing recSwingApp;
  private TableroVista tableroVista;
  private JList listaJugadores;
  private JLabel contrincante;
  private DefaultListModel jugadores;
  private JButton botonInvitar;
  private JLabel estadoTablero;
  
  /** Identificadores de textos dependientes de idioma */
  private static final String MENU_FICHERO = "MENU_FICHERO";
  private static final String MENU_ITEM_SALIR = "MENU_ITEM_SALIR";
  private static final String MENU_AYUDA = "MENU_AYUDA";
  private static final String MENU_ITEM_ACERCA_DE = "MENU_ITEM_ACERCA_DE";
  private static final String ETIQUETA_CONTRINCANTE = "CONTRINCANTE";
  private static final String BOTON_INVITAR = "BOTON_INVITAR";
  private static final String ESTADO_TABLERO = "ESTADO_TABLERO";
          
  /** Constantes para redimensionamiento */
  private static final int ANCHURA_LISTA_JUGADORES = 160;
  private static final int ALTURA_LISTA_JUGADORES = 200;
  private static final int MARGEN_HORIZONTAL = 50;
  private static final int MARGEN_VERTICAL = 100;
  
 /**
  * TableroSwing
  */  
  TableroSwing(int numFilTab, int numColTab, 
               final RecursosAppSwing recSwingApp) {
    super(recSwingApp.getGeneral(RecursosAppSwing.TITULO));
    this.recSwingApp = recSwingApp;
     
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        acaba();
      }
    });
    
    getContentPane().setLayout(new BorderLayout());
    
    // creamos elementos
    creaMenus();
    
    JPanel panelCentral = new JPanel();
    panelCentral.setLayout(new FlowLayout());
    creaTablero(panelCentral, numFilTab, numColTab);
    creaListaJugadores(panelCentral);
    getContentPane().add(panelCentral, BorderLayout.CENTER);
    
    estadoTablero = new JLabel(this.recSwingApp.getEtiqueta(ESTADO_TABLERO));
    getContentPane().add(estadoTablero, BorderLayout.SOUTH);
 
    // hacemos visible con el tamaño y la posición deseados 
    setIconImage(this.recSwingApp.getIconoImagenApp());
    setResizable(false);
    setSize((int)(tableroVista.dimensionCasilla().getWidth() * 
                  numColTab + ANCHURA_LISTA_JUGADORES + MARGEN_HORIZONTAL), 
            (int)(tableroVista.dimensionCasilla().getHeight() * 
                  numFilTab + MARGEN_VERTICAL));
    
    pack();  // ajusta ventana y sus componentes
    setVisible(true);
    setLocationRelativeTo(null);  // centra en la pantalla
  }  
  
  /**
  * creaMenus
  */  
  private void creaMenus() {
    JMenu menuFichero = new JMenu(this.recSwingApp.getTextoMenu(MENU_FICHERO));
    JMenuItem menuFicheroSalir = 
    new JMenuItem(this.recSwingApp.getTextoMenuItem(MENU_ITEM_SALIR),
                  this.recSwingApp.getAtajoMenuItem(MENU_ITEM_SALIR));
    menuFicheroSalir.addActionListener(this);

    menuFichero.add(menuFicheroSalir);

    JMenu menuAyuda = new JMenu(this.recSwingApp.getTextoMenu(MENU_AYUDA));
    JMenuItem menuAyudaAcercaDe = 
    new JMenuItem(this.recSwingApp.getTextoMenuItem(MENU_ITEM_ACERCA_DE),
                  this.recSwingApp.getAtajoMenuItem(MENU_ITEM_ACERCA_DE));
    menuAyudaAcercaDe.addActionListener(this);
    menuAyuda.add(menuAyudaAcercaDe);    

    JMenuBar menuPrincipal = new JMenuBar();
    menuPrincipal.add(menuFichero);
    menuPrincipal.add(menuAyuda);
    getContentPane().add(menuPrincipal,BorderLayout.NORTH);     
  }

 /**
  * creaTablero
  */   
  private void creaTablero(JPanel panel, int numFilTab, int numColTab) {
    tableroVista = new TableroVista(numFilTab, numColTab, 
                                      TableroVista.RECIBIR_EVENTOS_RATON, 
                                      RecursosAppSwing.RUTA_RECURSOS);
    tableroVista.nuevoObservador(this);

    panel.add(tableroVista);
    panel.add(new JPanel());
  }

 /**
  * creaListaJugadores
  */     
  private void creaListaJugadores(JPanel panel) {
    JPanel panelListaJugadores = new JPanel();
    panelListaJugadores.setLayout(new BorderLayout());
    contrincante = 
      new JLabel(this.recSwingApp.getEtiqueta(ETIQUETA_CONTRINCANTE));
    panelListaJugadores.add(contrincante, BorderLayout.NORTH);
    
    jugadores = new DefaultListModel();
    
    listaJugadores = new JList(jugadores);
    listaJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listaJugadores.setLayoutOrientation(JList.VERTICAL);
    
    listaJugadores.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent evt) {
        botonInvitar.setEnabled(true);  // activamos al seleccionar un jugador
      }
    });
    
    JScrollPane panelListaJugadoresScroller = new JScrollPane(listaJugadores);
    panelListaJugadoresScroller.setPreferredSize(
      new Dimension(ANCHURA_LISTA_JUGADORES, ALTURA_LISTA_JUGADORES));
    panelListaJugadores.add(panelListaJugadoresScroller, BorderLayout.CENTER);
    
    botonInvitar = new JButton(this.recSwingApp.getEtiqueta(BOTON_INVITAR));
    botonInvitar.setEnabled(false);
    
    botonInvitar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent evt) {
        if (! listaJugadores.isSelectionEmpty())
          contrincante.setText(recSwingApp.getEtiqueta(ETIQUETA_CONTRINCANTE) +
                               listaJugadores.getSelectedValue());
      }
    });     
    panelListaJugadores.add(botonInvitar, BorderLayout.SOUTH); 
    
    panel.add(panelListaJugadores);
  }
  
  /**
   * actionPerformed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    JMenuItem menuItem = (JMenuItem)e.getSource();
    if(menuItem.getText().equals(recSwingApp.getTextoMenuItem(MENU_ITEM_SALIR)))
      acaba();
    else if (menuItem.getText().equals(
      recSwingApp.getTextoMenuItem(MENU_ITEM_ACERCA_DE))) {
      JOptionPane.showMessageDialog(this,
        recSwingApp.getGeneral(RecursosAppSwing.TITULO) + "\n" + 
        recSwingApp.getGeneral(RecursosAppSwing.AUTOR)+ "\n" + 
        recSwingApp.getGeneral(RecursosAppSwing.VERSION), 
        recSwingApp.getTextoMenuItem(MENU_ITEM_ACERCA_DE), 
        JOptionPane.INFORMATION_MESSAGE,
        recSwingApp.getIconoApp());
    }
  }
  
  /**
   * actualiza
   */
  @Override
  public void actualiza(Object obj) {
    if (obj instanceof CasillaVista) { 
      CasillaVista casilla = (CasillaVista)obj;
      
      // si hay imagen en la casilla la quitamos y al revés
      if(tableroVista.getIconCasilla(casilla) == null)
        tableroVista.ponerIconoCasilla(casilla.getFil(), casilla.getCol(), 
                                 recSwingApp.getIconoApp());
      else
        tableroVista.ponerIconoCasilla(casilla.getFil(), casilla.getCol(), null);
      
      // indicamos la casilla seleccionada en la línea de estado
      estadoTablero.setText(
        recSwingApp.getEtiqueta(ESTADO_TABLERO) + obj.toString());
      
      // desactivamos selección de nuevo jugador
      if (! listaJugadores.isSelectionEmpty())
       listaJugadores.clearSelection();
       botonInvitar.setEnabled(false);
    }
  }

  /**
   * acaba
   */  
  private void acaba() {
    // ... aquí puede ir código de finalización
    
    System.exit(0);  
  }
  
  /**
   * main
   */
  public static void main(String[] args) {
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
                    
          for (int i = 0; i < 20; i++)
            tableroSwing.jugadores.addElement("Jugador" + i);
                    
          tableroSwing.tableroVista.ponerIconoCasilla(5, 3, 
                                                recSwingApp.getIconoApp());
          tableroSwing.tableroVista.ponerIconoCasilla(5 ,10, 
                                                recSwingApp.getIconoApp()); 
        } catch (Exception ex) {
          Logger.getLogger(TableroSwing.class.getName()).log(Level.SEVERE, 
                                                             null, ex);
        }       
      }
    });	
  }
}
