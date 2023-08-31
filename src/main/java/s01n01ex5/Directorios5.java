package s01n01ex5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Directorios5 implements Serializable {
    //Atributo para hacer pruebas de serialización
    private int campoPrueba1;
    private String campoPrueba2;

    //constructor para hacer pruebas de serializacion
    public Directorios5(int campoPrueba1, String campoPrueba2) {
        this.campoPrueba1 = campoPrueba1;
        this.campoPrueba2 = campoPrueba2;
    }
    public Directorios5() {
    }

    //variable para guardar el contenido del archivo de salida
    private BufferedWriter writer;
    public void directorioOrdenado(String rutaDirectorio, String archivoSalida){
        try {
            //indicamos la apertura del archivo de salida para su escritura
            writer = new BufferedWriter(new FileWriter(archivoSalida));
            File directorio = new File(rutaDirectorio);

            if (directorio.exists() && directorio.isDirectory()) {
                //lista recursivamente el contenido del directorio, con la cadena vacia
                mostrarContenidoRecursivo(directorio, " ");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void mostrarContenidoRecursivo(File directorio, String prefijo) throws IOException {
        File[] archivos = directorio.listFiles();
        if(archivos != null){
            Arrays.sort(archivos, new ArchivoComparator5());
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

    public void serializarObjeto(Object objeto, String archivo){
        try {
            FileOutputStream archivoSalida = new FileOutputStream(archivo);
            ObjectOutputStream salida = new ObjectOutputStream(archivoSalida);
            salida.writeObject(objeto);
            salida.close();
            archivoSalida.close();
            System.out.println("Objeto serializado en: " + archivo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object deserializarObjeto(String archivo){
        Object objetoDeserializado = null;

        try {
            FileInputStream archivoEntrada = new FileInputStream(archivo);
            ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
            objetoDeserializado = entrada.readObject();
            entrada.close();
            archivoEntrada.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return objetoDeserializado;
    }

}