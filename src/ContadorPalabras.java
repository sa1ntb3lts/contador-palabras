public class ContadorPalabras {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ContadorPalabras <archivo>");
            return;
        }

        String nombreArchivo = args[0];
        System.out.println("Archivo: " + nombreArchivo);
    }
}
