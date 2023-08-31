package s01n01ex3;

import java.io.File;
import java.util.Comparator;

public class ArchivoComparator3 implements Comparator<File> {

    @Override
    public int compare(File file1, File file2) {
        return file1.getName().compareTo(file2.getName());
    }
}

/*Implementamos la interfaz génerica Comparator<File>, se utilizará para comparar los objetos , esta clase se
utiliza en conjunto con el método Arrays.sort para ordenar los archivos en el método directorioOrdenado*/