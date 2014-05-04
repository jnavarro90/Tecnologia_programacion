package parking;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Caja {
    /*Declaracion de constantes*/
    private final String TARIFAS = "/Users/Javi/NetBeansProjects/Tecnologia_programacion/Parking/src/parking/tarifas.txt";
    private final double IVA = 0.21;
    
    /*Declaracion de variables*/
    private Tramo[] tramos;
    private StringTokenizer st;
    String s;
    String fichero;
    int contadorLineas = 0;

    public Caja() {
        try {
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

    private double calcularPrecio(double importe, double iva) {
        return importe + iva;
    }

    private double calcularIva(double importe) {

        return importe * IVA;
    }
    
    /**
     * El metodo calcularImporte calcula pasandole un tiempo con los datos de los tramos el importe a pagar.
     */
    private double calcularImporte(double tiempo) {
        double tiempoRestado = tiempo;
        double total = 0;
        for (int i = 0; i < tramos.length && tiempoRestado != 0; i++) {
            if (tiempo >= tramos[i].getLimiteSuperior()) {
                if (tramos[i].getLimiteSuperior() == 0) {
                    total = total + tramos[i].calcular(tiempoRestado);
                    tiempoRestado = 0;      /* Si llega aquí se pone a cero para que salga del bucle*/     
                    
                } else {
                    total = total + tramos[i].calcular(tramos[i].getLimiteSuperior() - tramos[i].getLimiteInferior());
                    tiempoRestado = tiempo - tramos[i].getLimiteSuperior();
                }
            } else {
                total = total + tramos[i].calcular(tiempoRestado);
                tiempoRestado = 0;      /* Si llega aquí se pone a cero para que salga del bucle*/
            }
        }
        return total;
    }

    /**
     * El metodo crearTramos con el numero de lineas que tenia el fichero crea nuevos tramos y los guarda en un array.
     */
    private void crearTramos() {
        tramos = new Tramo[contadorLineas];
        int i = 0;
        int limiteInferior;
        int limiteSuperior;
        double tasa;

        while (st.hasMoreTokens()) {
            limiteInferior = Integer.valueOf(st.nextToken());
            limiteSuperior = Integer.valueOf(st.nextToken());
            tasa = Double.valueOf(st.nextToken());

            tramos[i] = new Tramo(limiteInferior, limiteSuperior, tasa);
            i++;
        }
    }
    
    /**
     * El metodo crearTicket sirve para crear un ticket con los datos de el metodo cobrando que luego se imprime.
     */
    public void crearTicket(int numeroTicket, Vehiculo v, double tiempo, double importe, double iva, double total) {
        TicketCentro ticket;

        System.out.println("Se esta creando su ticket...");
        
        ticket = new TicketCentro(numeroTicket, v, tiempo, importe, iva, total);
        
        ticket.imprimir();
        
    }

    /**
     * El metodo cobrando sirve para calcular el importe total de un vehiculo y preguntar si quiere su ticket.
     */
    public void cobrando(int numeroTicket, Vehiculo v) {

        int opcion = 1;
        double tiempo = 0;
        double importe = 0;
        double iva;
        double total;
        if (v.obtenerTiempo() != -1) {
            tiempo = v.obtenerTiempo();
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
        System.out.println("-----------------------------------------");
        System.out.println("\t 1 - Si.");
        System.out.println("\t 2 - No.");
        System.out.println("-----------------------------------------");
        System.out.print("Opcion: ");
        do {
            Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearTicket(numeroTicket, v, tiempo, importe, iva, total);
                    opcion = 2;
                    break;
                case 2:
                    System.out.println("Volviendo al menu...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 2);
    }
}