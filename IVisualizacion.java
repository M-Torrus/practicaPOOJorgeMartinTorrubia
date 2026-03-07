/**
 * Interfaz que define el contrato de visualización del dashboard.
 * Desacopla el dashboard de la implementación concreta de la vista,
 * permitiendo cambiar el modo de presentación sin modificar el sistema.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public interface IVisualizacion {

    /**
     * Muestra el estado actual del sistema por la salida configurada.
     */
    void mostrar();

    /**
     * Actualiza la vista con los datos más recientes del sistema.
     */
    void actualizar();
}
