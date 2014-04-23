
package recursos;
/*
 *se importa esta clase para ler desde teclado 
*/
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class Lee {
	public String leeBuffer(BufferedReader buffer) throws Exception{
            String retorno = null;
            String lineaSalida = "";
            StringBuffer contenido = new StringBuffer();
            String separador = "";
            
            while ((lineaSalida = buffer.readLine()) != null){
                contenido.append(separador +lineaSalida);
                separador = "\n";
            }
            
            retorno = contenido.toString();
            return retorno;
        }
        public String leeFichero(String ruta) throws Exception{
            File rutaFichero = new File(ruta);
            FileReader lectorFichero = new FileReader(rutaFichero);
            BufferedReader buffer = new BufferedReader(lectorFichero);
            
            return leeBuffer(buffer);
        }
        
	public long leeLong(){
		Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
		long leidoLong = sc.nextLong();
		return leidoLong;
	}
	public double leeDouble(){
		Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
		double leidoDouble = sc.nextDouble();
		return leidoDouble;
	}
	public float leeFloat(){
		Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
		float leidoFloat = sc.nextFloat();
		return leidoFloat;
	}
	public int leeEntero(){
		Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
		int leidoEntero = sc.nextInt();
		return leidoEntero;
	}
	public String leeString(){
		Scanner sc = new Scanner(System.in); //Se indica que se quiere leer desde consola
		String leidoString = sc.next();
		return leidoString;
	}
	public char leeChar() throws IOException{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		char leidoChar = entrada.readLine().charAt(0);
		return leidoChar;
	}
}
