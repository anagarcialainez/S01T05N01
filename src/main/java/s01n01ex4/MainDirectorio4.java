package s01n01ex4;

import java.io.IOException;

public class MainDirectorio4 {
    public static void main(String[] args) {
        Directorios4 directorios = new Directorios4();
        String rutaDirectorio ="src/main/java/s01n01ex1/recursosJava";

        String archivoSalida = "src/main/java/s01n01ex3/resultado.txt";
        try {
            directorios.directorioOrdenado(rutaDirectorio, archivoSalida);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String rutaArchivo = "src/main/java/s01n01ex4/Countries.txt";
        LeerArchivoTxt leerArchivo = new LeerArchivoTxt();
        leerArchivo.mostrarContenidoArchivo(rutaArchivo);
    }

}

/*Añade la funcionalidad de leer cualquier archivo TXT y muestra su contenido por consola.*/
