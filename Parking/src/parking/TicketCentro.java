/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public class TicketCentro extends Ticket{
    private final String NOMBRE = "Parking Centro S.L";
    public TicketCentro(int numero, Vehiculo v, double tiempo, double importe, double iva, double total) {
        setNumero(numero);
        setV(v);
        setTiempo(tiempo);
        setImporte(importe);
        setIva(iva);
        setTotal(total);
    }
    public boolean imprimir(){
        System.out.println(NOMBRE+"\nTicket: "+getNumero()+"\nEntrada: "+getV().getFechaEntrada().getTime()+
                "\nSalida: "+ getV().getFechaSalida().getTime()+"\nMatricula: "+getV().getMatricula()+"\nImporte: "+
                getImporte()+"\nIVA: "+getIva()+"\nTotal: "+getTotal());
    return true;
    }
}