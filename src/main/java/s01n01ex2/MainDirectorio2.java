package s01n01ex2;

public class MainDirectorio2 {
    public static void main(String[] args) {
        Directorios2 directorios = new Directorios2();
        String rutaDirectorio ="src/main/java/s01n01ex1/recursosJava";
        directorios.directorioOrdenado(rutaDirectorio);
    }

}

/*Añade a la clase del ejercicio anterior, la funcionalidad de listar un árbol de directorios con el contenido de
todos sus niveles (recursivamente) de forma que se impriman en pantalla en orden alfabético dentro de cada nivel,
 indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación.
 */
