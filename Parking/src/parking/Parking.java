/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author javi
 */
public class Parking {

    private final int MAX_PLAZAS = 10;
    private Plaza plazas[];
    private Caja cajero;

    public Parking() {
        plazas = new Plaza[MAX_PLAZAS];
        cajero = new Caja();
        for (int i = 0; i < MAX_PLAZAS; i++) {
            Plaza nuevaPlaza = new Plaza(i);
            plazas[i] = nuevaPlaza;
        }
    }

    public boolean entraVehiculo(String matricula) {
        boolean salir = true;

        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);

        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.length && salir; i++) {

            if (!plazas[i].ocupada()) {
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar

                if (plazas[i].ocupar(v)) {        //Cuando ocupar devuelve true cambia salir a true para salir del bucle
                    salir = false;
                    Entrada nuevaEntrada = new Entrada(plazas[i].obtenerVehiculo(), i);
                    nuevaEntrada.registrar();
                }
            }
        }
        /**
         * retornara true siempre haya entrado un vehiculo porque cuando salir es falso,
         * si no ha podido entrar el vehiculo salir seguira a true entonces la comparación dara false
         */
        return salir == false;
    }

    public boolean saleVehiculo(String matricula) {
        boolean salir = true;

        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);

        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.length && salir; i++) {

            if (plazas[i].equals(v)) {
                v = plazas[i].obtenerVehiculo();
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                if (plazas[i].desocupar()) {        //Cuando ocupar devuelve true cambia salir a true para salir del bucle
                    salir = false;
                    Salida nuevaSalida = new Salida(v, i);
                    nuevaSalida.registrar();
                }
            }
        }
        return salir == false;
    }

    public boolean cobrar(String matricula) {
        int numeroTicket = 0;
        boolean salir = true;

        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);

        for (int i = 0; i < plazas.length && salir; i++) {

            if (plazas[i].equals(v)) {
                plazas[i].obtenerVehiculo().asignarFechaSalida();
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                System.out.println("Cobrando al vehiculo...");
                cajero.cobrando(plazas[i].obtenerVehiculo());
                cajero.crearTicket(numeroTicket, plazas[i].obtenerVehiculo());


                numeroTicket++;
                salir = false;
            }
        }
        return salir == false;
    }
}
