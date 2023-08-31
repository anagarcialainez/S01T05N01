package s01n01ex3;

public class MainDirectorio3 {
    public static void main(String[] args) {
        Directorios3 directorios = new Directorios3();
        String rutaDirectorio ="src/main/java/s01n01ex1/recursosJava";

        String archivoSalida = "src/main/java/s01n01ex3/resultado.txt";
        directorios.directorioOrdenado(rutaDirectorio, archivoSalida);
    }

}

/*Modifica el ejercicio anterior. Ahora, en lugar de mostrar el resultado por la pantalla, guarda el resultado en un
archivo TXT.
 */
