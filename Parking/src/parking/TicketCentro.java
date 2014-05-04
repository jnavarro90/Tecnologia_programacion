/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.io.*;

/**
 *
 * @author javi
 */
public class TicketCentro extends Ticket {

    private final String NOMBRE = "Parking Centro S.L";

    public TicketCentro(int numero, Vehiculo v, double tiempo, double importe, double iva, double total) {
        super(numero, v, tiempo, importe, iva, total);
    }

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