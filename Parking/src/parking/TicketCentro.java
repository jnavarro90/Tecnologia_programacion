/*
 * Clase TicketCentro
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase que es un tipo de ticket.
 * Se implementa el imprimr de la clase Ticket.
 * @author Javi
 * @version 1
 */
import java.io.*;

/**
 *
 * @author javi
 */
public class TicketCentro extends Ticket {

    /*Declaracion de constantes*/
    private final String NOMBRE = "Parking Centro S.L";

    /*
     * El constructor de TicketCentro añade los valores las variable de su clase
     * super(Ticket).
     */
    public TicketCentro(int numero, Vehiculo v, double tiempo, double importe, double iva, double total) {
        super(numero, v, tiempo, importe, iva, total);
    }
    /*
     * imprimir guarda el ticket en un fichero, implementa la clase
     * abstracta imprimir de Ticket.
     */
    public boolean imprimir() {
        String ticket = NOMBRE + "\nTicket: " + getNumero() + "\nEntrada: " + getV().getFechaEntrada().getTime()
                + "\nSalida: " + getV().getFechaSalida().getTime() + "\nMatricula: " + getV().getMatricula() + "\nImporte: "
                + getImporte() + "\nIVA: " + getIva() + "\nTotal: " + getTotal();

        try {
            PrintWriter fOut = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Javi/NetBeansProjects/Tecnologia_programacion/Parking/src/parking/ticket"+getNumero()+".txt")));
            fOut.write(ticket);
            fOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return true;
    }
}