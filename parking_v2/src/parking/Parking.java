/*
 * Clase Principal
 * Version 1
 * Fecha 2-4-2014
 */
package parking;

/**
 * Clase en la que se almacenan las plazas y con un cajero para cobrar. Esta
 * clase tambien registra los movimientos de esntrada y salida que se pproducen
 * en el parking.
 *
 * @author Javi
 * @version 1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parking {

    /*
     * Declaracion de constantes
     */
    private final int MAX_PLAZAS = 10;
    /*
     * Declaracion de variables
     */
    private Map<Integer, Plaza> plazas;
    private Caja cajero;
    private int numeroTicket = 0;

    /*
     * El constructor de Parking crea un array de la clase Plaza con un maximo
     * que esta en una cosntante y rellena el array con plazas vacias, tambien
     * crea un cajero de la clase Caja que servira para cobrar a los clientes.
     */
    public Parking() {
        plazas = new HashMap<Integer, Plaza> ();
        cajero = new Caja();
        for (int i = 0; i < MAX_PLAZAS; i++) {
            Plaza nuevaPlaza = new Plaza(i);
            plazas.put(i, nuevaPlaza);
        }
    }

    /*
     * entraVehiculo ocupa una plaza del array con un coche y 
     * registra el movimiento.
     */
    public boolean entraVehiculo(String matricula) {

        boolean salir = true;
        Vehiculo v = new Vehiculo(matricula);

        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.size() && salir; i++) {
            if (!plazas.get(i).ocupada()) {
                if (plazas.get(i).ocupar(v)) {        /*Cuando ocupar devuelve 
                 * true cambia salir a true para salir del bucle*/
                    salir = false;
                    Entrada nuevaEntrada = 
                            new Entrada(plazas.get(i).obtenerVehiculo(), i);
                    nuevaEntrada.registrar();
                }
            }
        }

        /*
         * retornara true siempre haya entrado un vehiculo porque cuando salir
         * es falso, si no ha podido entrar el vehiculo salir seguira a true
         * entonces la comparación dara false
         */
        return salir == false;
    }

    /*
     * saleVehiculo desocupa una plaza del array con un coche 
     * y registra el movimiento.
     */
    public boolean saleVehiculo(String matricula) {

        boolean salir = true;
        Vehiculo v = new Vehiculo(matricula);

        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.size() && salir; i++) {

            if (plazas.get(i).equals(v)) {
                v = plazas.get(i).obtenerVehiculo();    
                /*Hay sacar el vehiculo de la plaza para poder modificarlo 
                 * y usar su metodo desocupar.*/
                if (v.haPagado()) {
                    plazas.get(i).desocupar();
                    
                    Salida nuevaSalida = new Salida(v, i);
                    nuevaSalida.registrar();
                }else{
                    System.out.println("No ha podido salir "
                            + "porque el vehiculo todavia no ha pagado.");
                }
                salir = false;
            }else{
                System.out.println("El vehiculo no esta en el parking.");
            }
        }
        
        /*
         * retornara true siempre haya entrado un vehiculo porque cuando salir
         * es falso, si no ha podido entrar el vehiculo salir seguira a true
         * entonces la comparación dara false
         */
        return salir == false;
    }

    /*
     * cobrar se ocupa de usar el cajero para cobrar.
     */
    public boolean cobrar(String matricula) {

        boolean salir = true;
        /*Se crea un nuevo vehiculo con la matricula y la 
        fecha se pone en el constructor de vehiculo*/
        Vehiculo v = new Vehiculo(matricula);

        for (int i = 0; i < plazas.size() && salir; i++) {

            if (plazas.get(i).equals(v)) {
                plazas.get(i).obtenerVehiculo().asignarFechaSalida();

                System.out.println("Cobrando al vehiculo matricula: " + v.getMatricula());
                cajero.cobrar(numeroTicket, plazas.get(i).obtenerVehiculo());

                numeroTicket++;
                salir = false;
            }else{
                System.out.println("El vehiculo no esta en el parking.");
            }
        }
        return salir == false;
    }
}
