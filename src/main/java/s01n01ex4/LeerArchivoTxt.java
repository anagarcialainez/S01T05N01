package s01n01ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoTxt {
    public void mostrarContenidoArchivo(String rutaArchivo){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
