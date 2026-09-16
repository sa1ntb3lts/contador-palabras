import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

        Map<String, Integer> frecuencias = new HashMap<>();

        try (
            BufferedReader lector = Files.newBufferedReader(archivo)
        ) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                linea = linea.toLowerCase();
                linea = linea.replaceAll("[^\\p{L}\\p{N}\\s]", "");

                if (linea.isBlank()) {
                    continue;
                }

                String[] palabras = linea.trim().split("\\s+");

                for (String palabra : palabras) {
                    if (frecuencias.containsKey(palabra)) {
                        int frecuencia = frecuencias.get(palabra);
                        frecuencias.put(palabra, frecuencia + 1);
                    } else {
                        frecuencias.put(palabra, 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
