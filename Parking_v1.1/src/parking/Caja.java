/*
 * Clase Caja
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que gestiona el cobrar a los clientes y crear tickets.
 * @author Javi
 * @version 1
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caja {
    /*Declaracion de constantes*/
    private final String TARIFAS = "./tarifas.txt";
    private final int CREAR_TICKET = 1;
    private final int VOLVER = 2;
    private final double IVA = 0.21;
    
    
    /*Declaracion de variables*/
    private List<Tramo> tramos;
    private StringTokenizer st;
    private String s;
    private String fichero;
    int contadorLineas = 0;
/*
 * El constructor de Caja lee el fichero tarifas y le pasa su contenido a un String 
 * después crea los tramos necesarios
 */
    
    public Caja() {
        try {
            
            tramos = new ArrayList<Tramo>();
            /*Lee cada linea de un fichero y lo pasa a una cadena con delimitadores ":" 
             y añade un contador para saber las lineas que tiene el archivo que se usara saber el numero de tramos.*/
            BufferedReader fIn =
                    new BufferedReader(new FileReader(TARIFAS));
            while ((s = fIn.readLine()) != null) {
                if (fichero == null) {
                    fichero = s;
                    contadorLineas++;
                } else {
                    fichero += ":" + s;
                    contadorLineas++;
                }
            }
            fIn.close();


        } catch (Exception e) {
            System.out.println("Error en la lectura del fichero.");
        }
        st = new StringTokenizer(fichero, ":");                     /*Crea un stingTokenizer con la cadena que ha extraido del fichero y con el delimitador ":".*/
        
        crearTramos();
    }
    /*
     * calculaPrecio
     * calcularPrecio recibe el importe y el iva y los suma para calcular el total
     * Es private porque no se usa en otra clase.
     */
    private double calcularPrecio(double importe, double iva) {
        return importe + iva;
    }
    /*
     * calcularIva recibe el importe y calcula el iva
     * Es private porque no se usa en otra clase.
     */
    private double calcularIva(double importe) {

        return importe * IVA;
    }
    
    /*
     * calcularImporte calcula pasandole un tiempo con los datos de los tramos el importe a pagar.
     * Usa otros metodos de esta clase para calcular todo.
     */
    private double calcularImporte(double tiempo) {
        double tiempoRestado = tiempo;
        double total = 0;
        for (int i = 0; i < tramos.size() && tiempoRestado != 0; i++) {
            if (tiempo >= tramos.get(i).getLimiteSuperior()) {
                if (tramos.get(i).getLimiteSuperior() == 0) {
                    total = total + tramos.get(i).calcular(tiempoRestado);
                    tiempoRestado = 0;      /* Si llega aquí se pone a cero para que salga del bucle*/     
                    
                } else {
                    total = total + tramos.get(i).calcular(tramos.get(i).getLimiteSuperior() - tramos.get(i).getLimiteInferior());
                    tiempoRestado = tiempo - tramos.get(i).getLimiteSuperior();
                }
            } else {
                total = total + tramos.get(i).calcular(tiempoRestado);
                tiempoRestado = 0;      /* Si llega aquí se pone a cero para que salga del bucle*/
            }
        }
        return total;
    }
    /*
     * obtenerTiempo resta las dos fechas para sacar 
     * los minutos que ha estado dentro del parking.
     */
    private double obtenerTiempo(Vehiculo v) {
        double minutos = 0;
        try {
            long diferencia = v.getFechaSalida().getTime().getTime() 
                    - v.getFechaEntrada().getTime().getTime();
            minutos = (double) diferencia / (1000 * 60);

        } catch (NullPointerException e) {
            return -1;         
            /*Si falta alguna fecha devolveria -1 para poder tratarlo fuera*/
        }

        return minutos;
    }
      /*
     * crearTramos con el numero de lineas que tenia el fichero crea nuevos tramos y los guarda en un array.
     * Es private porque no se usa en otra clase.
     */
    private void crearTramos() {
        tramos  = new ArrayList<Tramo>();
        int limiteInferior;
        int limiteSuperior;
        double tasa;

        while (st.hasMoreTokens()) {
            limiteInferior = Integer.valueOf(st.nextToken());
            limiteSuperior = Integer.valueOf(st.nextToken());
            tasa = Double.valueOf(st.nextToken());
            tramos.add(new Tramo(limiteInferior, limiteSuperior, tasa));
        }
    }
    
    /*
     * El metodo crearTicket sirve para crear un ticket con los datos de el metodo cobrando que luego se imprime.
     * Es private porque no se usa en otra clase.
     */
    private void crearTicket(int numeroTicket, Vehiculo v, double tiempo, double importe, double iva, double total) {
        TicketCentro ticket;

        System.out.println("Se esta creando su ticket...");
        
        ticket = new TicketCentro(numeroTicket, v, tiempo, importe, iva, total);
        
        ticket.imprimir();
        
    }

    /*
     * El metodo cobrando sirve para calcular el importe total de un vehiculo y preguntar si quiere su ticket.
     */
   public void cobrar(int numeroTicket, Vehiculo v) {

        int opcion = 1;
        double tiempo = 0;
        double importe = 0;
        double iva;
        double total;
        if (obtenerTiempo(v) != -1) {
            tiempo = obtenerTiempo(v);
        } else {
            System.out.println("No se puede calcular el tiempo porque falta alguna fecha");
        }

        //importe = calcularImporte(tiempo);        /*esta es la linea que tiene que estar en el programa.*/
        importe = calcularImporte(67);              /* esta linea es para probar diferentes tiempos.*/
        iva = calcularIva(importe);
        total = calcularPrecio(importe, calcularIva(importe));
        
        System.out.println("Abone la cantidad indicada:\n"+"Total = "+total);
        if (v.pagando()){
            System.out.println("Puede retirar su vehiculo.");
        }
        System.out.println("¿Quiere su ticket?");
        System.out.println("-----------------------------------------");                        /*Menu para preguntar si imprimir un ticket*/
        System.out.println("\t 1 - Si.");
        System.out.println("\t 2 - No.");
        System.out.println("-----------------------------------------");
        System.out.print("Opcion: ");
        do {
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                case CREAR_TICKET:
                    crearTicket(numeroTicket, v, tiempo, importe, iva, total);
                    opcion = VOLVER;
                    break;
                case VOLVER:
                    System.out.println("Volviendo al menu...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != VOLVER);
    }
}