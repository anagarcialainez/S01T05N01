package s01n01ex1;

public class MainDirectorio {
    public static void main(String[] args) {
        Directorios directorios = new Directorios();
        String rutaDirectorio ="src/main/java/s01n01ex1/recursosJava";
        directorios.directorioOrdenado(rutaDirectorio);
    }

}

/*Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.*/
