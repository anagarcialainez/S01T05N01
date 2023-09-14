package s01n01ex5;

import java.io.IOException;

public class MainDirectorio5 {
    public static void main(String[] args) {
        Directorios5 directorios = new Directorios5();
        String rutaDirectorio = "src/main/java/s01n01ex1/recursosJava";
        String archivoSalida = "src/main/java/s01n01ex3/resultado.txt";
        try {
            directorios.OrdenarDirectorio(rutaDirectorio, archivoSalida);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String rutaArchivo = "src/main/java/s01n01ex4/Countries.txt";
            Directorios5 leerArchivo = new Directorios5();
            leerArchivo.mostrarContenidoArchivo(rutaArchivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Directorios5 serializacion = new Directorios5(1, "prueba1");
        String archivoSerializado = "src/main/java/s01n01ex5/objetoSerializado.ser";
        try {
            serializacion.serializarObjeto(serializacion, archivoSerializado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Directorios5 objetoDeserializado = null;
        try {
            objetoDeserializado = (Directorios5) serializacion.deserializarObjeto(archivoSerializado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (objetoDeserializado != null) {
            System.out.println("Objeto deserializado: " + objetoDeserializado);
        }
    }

}

/*Ahora el programa debe serializar un Objeto Java a un archivo .ser y después debe desserializarlo.*/
