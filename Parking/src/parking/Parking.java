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
    Plaza plazas[] = new Plaza[MAX_PLAZAS];
    Caja cajero;

    public Parking() {
        cajero = new Caja();
        for (int i = 0; i < MAX_PLAZAS; i++){
            Plaza nuevaPlaza = new Plaza(i);
            plazas[i] = nuevaPlaza;
        }
    }
    
    boolean entraVehiculo(String matricula){
        boolean salir = true;
        
        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);
       
        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.length && salir; i++){
            
            if(!plazas[i].ocupada()){
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                
                if(plazas[i].ocupar(v)){        //Cuando ocupar devuelve true cambia salir a true para salir del bucle
                    salir = false;
                }
                
                Entrada nuevaEntrada = new Entrada();
                nuevaEntrada.registrar(v, i);
            }
        }
        return salir == false;
    }
    boolean saleVehiculo(String matricula){
        boolean salir = true;
        
        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);
       
        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i < plazas.length && salir; i++){
            
            if(plazas[i].equals(v)){
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                if(plazas[i].desocupar()){        //Cuando ocupar devuelve true cambia salir a true para salir del bucle
                    salir = false;
                }
                v.asignarFechaSalida();
                v.obtenerTiempo();
                
                Salida nuevaSalida = new Salida();
                nuevaSalida.registrar(v, i);
            }
        }
        return salir == false;
    }
    
    public boolean cobrar(String matricula){
        int numeroTicket = 0;
        boolean salir = true;
        
        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);
       
        for (int i = 0; i < plazas.length && salir; i++){
            
            if(plazas[i].equals(v)){
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                v = plazas[i].obtenerVehiculo();
                cajero.crearTicket(numeroTicket, v);
                
                numeroTicket++;
                salir = false;
            }
        }
        return salir == false;
    }
}
