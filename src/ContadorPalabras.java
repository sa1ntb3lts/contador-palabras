import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.IOException;

public class ContadorPalabras {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ContadorPalabras <archivo>");
            return;
        }

        String nombreArchivo = args[0];
        System.out.println("Archivo: " + nombreArchivo);

        Path archivo = Path.of(args[0]);

        System.out.println("Archivo: " + archivo.getFileName());
        System.out.println("Ruta: " + archivo.toAbsolutePath());

        if (!Files.exists(archivo)) {
            System.err.println("El archivo no existe: " + archivo);
            return;
        }

        try (
            BufferedReader lector = Files.newBufferedReader(archivo)
        ) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);

                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    System.out.println(palabra);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
