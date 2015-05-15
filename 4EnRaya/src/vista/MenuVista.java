package vista;

/**
 *
 * @author Javi
 */
import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuVista extends JFrame implements ActionListener{
    public final String CARGAR_PARTIDA = "Cargar Partida";
    public final String GUARDAR_PARTIDA = "Guardar Partida";
    public final String VOLVER = "Volver";
    public final String ERROR = "Error";
    public final String NUEVA_PARTIDA = "Nueva Partida";
    public final String SALIR = "Salir";
    public final String ACERCA_DE = "Acerca de ..";
    private String titulo;
    private JButton botonNuevaPartida;
    private JButton botonCargarPartida;
    private JButton botonSalir;
    private JMenuItem menuFicheroSalir;
    private JMenu menuAyuda;
    private JMenuItem menuAyudaAcercaDe;
    private Observador observador;
    public MenuVista(String titulo){
        super(titulo);
        this.titulo = titulo;
    }
    
    public String obtenerNombreJugador(String titulo){
        this.titulo = titulo;
        String nombre = JOptionPane.showInputDialog(
                this, "Introduce el nombre del jugador", titulo, 
                JOptionPane.QUESTION_MESSAGE);
        return nombre;
    }
    
    public void obtenerOpcionMenu(){
        
        botonNuevaPartida= new JButton(NUEVA_PARTIDA);
        botonCargarPartida = new JButton(CARGAR_PARTIDA);
        botonSalir = new JButton(SALIR);
        menuFicheroSalir  = new JMenuItem(SALIR,'S');
        menuAyuda  = new JMenu("Ayuda");
        menuAyudaAcercaDe = new JMenuItem(ACERCA_DE, 'A');
        
        getContentPane().setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){ setVisible(false);}
        });
        
        JMenu menuFichero = new JMenu("Fichero");

        menuFichero.add(menuFicheroSalir);
        menuAyuda.add(menuAyudaAcercaDe);
        
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menuFichero);
        barraMenu.add(menuAyuda);
        getContentPane().add(barraMenu, BorderLayout.NORTH);
        
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new FlowLayout());
        getContentPane().add(panelNombre, BorderLayout.CENTER);
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(botonNuevaPartida);
        panelBotones.add(botonCargarPartida);
        panelBotones.add(botonSalir);
        
        botonNuevaPartida.addActionListener(this);
        botonCargarPartida.addActionListener(this);
        botonSalir.addActionListener(this);

        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        JLabel etiquetaNombre = new JLabel();
        panelNombre.add(etiquetaNombre);
        etiquetaNombre.setForeground(Color.blue);
        etiquetaNombre.setFont(new Font("Arial", Font.PLAIN, 40));
        
        setBounds(250, 200,440, 150);
        setVisible(true);
        setResizable(false);
    }

   /**
   * nuevoObservador
   */   
  public void nuevoObservador(Observador observador) {
    this.observador = observador;
  }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(NUEVA_PARTIDA)){
            observador.actualiza(NUEVA_PARTIDA);
            this.setVisible(false);
        }else if(e.getActionCommand().equals(CARGAR_PARTIDA)){           
            observador.actualiza(CARGAR_PARTIDA); 
            this.setVisible(false);
        }else if(e.getActionCommand().equals(SALIR)){        
            observador.actualiza(SALIR);  
            this.setVisible(false);
        }
    }
}
