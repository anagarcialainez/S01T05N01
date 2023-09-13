package s01n01ex5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivoTxt {
    public void mostrarContenidoArchivo(String rutaArchivo) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
