package s01n01ex5;

public class MainDirectorio5 {
    public static void main(String[] args) {
        Directorios5 directorios = new Directorios5();
        String rutaDirectorio ="src/main/java/s01n01ex1/recursosJava";

        String archivoSalida = "src/main/java/s01n01ex3/resultado.txt";
        directorios.directorioOrdenado(rutaDirectorio, archivoSalida);

        String rutaArchivo = "src/main/java/s01n01ex4/Countries.txt";
        LeerArchivoTxt leerArchivo = new LeerArchivoTxt();
        leerArchivo.mostrarContenidoArchivo(rutaArchivo);

        Directorios5 serializacion = new Directorios5(1,"prueba1");
        String archivoSerializado = "src/main/java/s01n01ex5/objetoSerializado.ser";
        serializacion.serializarObjeto(serializacion,archivoSerializado);

        Directorios5 objetoDeserializado = (Directorios5) serializacion.deserializarObjeto(archivoSerializado);
        if(objetoDeserializado != null){
        System.out.println("Objeto deserializado: " + objetoDeserializado);
        }
    }

}

/*Ahora el programa debe serializar un Objeto Java a un archivo .ser y después debe desserializarlo.*/
