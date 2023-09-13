package s01n01ex4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Directorios4 {
    //variable para guardar el contenido del archivo de salida
    private BufferedWriter writer;
    public void directorioOrdenado(String rutaDirectorio, String archivoSalida) throws IOException {
        try {
            //indicamos la apertura del archivo de salida para su escritura
            writer = new BufferedWriter(new FileWriter(archivoSalida));
            File directorio = new File(rutaDirectorio);

            if (directorio.exists() && directorio.isDirectory()) {
                //lista recursivamente el contenido del directorio, con la cadena vacia
                mostrarContenidoRecursivo(directorio, " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }
    public void mostrarContenidoRecursivo(File directorio, String prefijo) throws IOException {
        File[] archivos = directorio.listFiles();
        if(archivos != null){
            Arrays.sort(archivos, new ArchivoComparator4());
            for(File archivo : archivos){
                String tipo = archivo.isDirectory() ? "D" : "F";
                String fechaModificacion = obtenerFechaModificacion(archivo);
                // guardamos en "linea" los detalles del archivo o directorio
                String linea = prefijo + tipo + " " + archivo.getName() + " - última modificación: " + fechaModificacion;
               //para escribir el contenido en el archivo de salida
                writer.write(linea);
                //para agregar una nueva linea despues de cada linea escrita
                writer.newLine();
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
