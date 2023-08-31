package s01n01ex1;

import java.io.File;
import java.util.Arrays;

public class Directorios {
    //Método que listará el contenido del directorio pasado en orden alfabetico
    public void directorioOrdenado(String rutaDirectorio){
        //creamos el objeto que representara el directorio a listar, con la ruta proporcionada
        File directorio = new File(rutaDirectorio);

        //comprobamos si el directorio existe y si es válido en el sistema de archivo
        if(directorio.exists() && directorio.isDirectory()){
            //arreglo para representar la lista de los archivos y directorios dentro del directorio
            File[] archivos = directorio.listFiles();

            //validamos si el directorio no esta vacio
            if(archivos != null){
                /*ordenamos el listado mediante el método sort, a través de la instancia ArchivoComparator*/
                Arrays.sort(archivos,new ArchivoComparator());

                //recorremos la lista ordenada y obtenemos el nombre del archivo
                for(File archivo:archivos){
                    System.out.println(archivo.getName());
                }

            }
        }

    }

}
