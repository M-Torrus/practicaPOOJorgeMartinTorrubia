/**
 * Clase principal de la aplicación. Punto de entrada del sistema de gestión
 * de la fábrica de vehículos. Inicializa el SistemaGestion.
 * La interfaz textual de usuario se implementará en el Nivel 3.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class factory_main {

    /**
     * Método principal. Inicializa el sistema de gestión de la fábrica.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        System.out.println("Sistema de gestión de la fábrica iniciado.");
        // La interfaz textual de usuario se implementará en el Nivel 3.
        // Para probar el sistema en el Nivel 2, usar el entorno BlueJ directamente.
    }
}
