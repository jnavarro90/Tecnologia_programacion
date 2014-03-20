 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Javi
 */
public class Caja {
    private Tarifa tarifas;
    private Ticket ticket;
    
    public float calcularPrecio(){
        float precio = 0;
        return precio;
    }
    public Ticket crearTicket(int numeroTicket, Vehiculo v){
       float tiempo;
       
       
       tiempo = v.obtenerTiempo();
       
       
       
       ticket = new Ticket(numeroTicket, v, tiempo);
    
    return ticket;
    }
}