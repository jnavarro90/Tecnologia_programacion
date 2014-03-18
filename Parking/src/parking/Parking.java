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
    Plaza plazas[];
    Caja cajero;
    boolean entraVehiculo(String matricula){
        boolean salir = false;
        
        //Se crea un nuevo vehiculo con la matricula y la fecha se pone en el constructor de vehiculo
        Vehiculo v = new Vehiculo(matricula);
        
        //Bucle para ver la primera posicion libre del vector plazas
        for (int i = 0; i<plazas.length || salir;i++){
            if(plazas[i] != null){
                
                //Se crea una nueva plaza con el vehiculo y el numero de plaza con el metodo ocupar
                Plaza nuevaPlaza = new Plaza();
                nuevaPlaza.ocupar(v, i);
                plazas[i] = nuevaPlaza;
                
                Entrada nuevaEntrada = new Entrada();
                nuevaEntrada.registrar(v, i);
            }
        }
        return false;
    }
    boolean saleVehiculo(String matricula){
    
        return false;
    }
    
    private boolean cobrar(Vehiculo v){
    
        return false;
    }
    
    private boolean registrarMovimiento(){
        
        return false;
    }
}
