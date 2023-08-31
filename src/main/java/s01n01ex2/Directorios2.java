package s01n01ex2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Directorios2 {
    public void directorioOrdenado(String rutaDirectorio){
        File directorio = new File(rutaDirectorio);

        if(directorio.exists() && directorio.isDirectory()){
            //lista recursivamente el contenido del directorio, con la cadena vacia
           mostrarContenidoRecursivo(directorio," ");
        }
    }
    public void mostrarContenidoRecursivo(File directorio, String prefijo){
        File[] archivos = directorio.listFiles();
        if(archivos != null){
            Arrays.sort(archivos, new ArchivoComparator2());
            for(File archivo : archivos){
                String tipo = archivo.isDirectory() ? "D" : "F";
                String fechaModificacion = obtenerFechaModificacion(archivo);
                System.out.println(prefijo + tipo + " " + archivo.getName() + " - última modificación: " + fechaModificacion);
                if(archivo.isDirectory()){
                    mostrarContenidoRecursivo(archivo, prefijo + "  ");
                }
            }
        }
    }
    private String obtenerFechaModificacion(File archivo){
        //utilizamos la clase SimpleDateFormat del paquete java.text, para trabajar fechas y tiempo
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatoFecha.format(archivo.lastModified());
    }

}
