/**
 * Dashboard de monitorización de la fábrica. Muestra en tiempo real el estado
 * de las cadenas de montaje y del almacén. Trabaja con IVisualizacion para
 * mantenerse desacoplado de la implementación concreta de la vista.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Dashboard {
    private IVisualizacion visualizador;

    /**
     * Constructor de Dashboard.
     *
     * @param visualizador Implementación de la vista a usar para mostrar datos.
     */
    public Dashboard(IVisualizacion visualizador) {
        this.visualizador = visualizador;
    }

    /**
     * Muestra el estado actual de las tres cadenas de montaje.
     * La implementación completa se realiza en el Nivel 3.
     */
    public void mostrarEstadoCadenas() {
        // TODO: Nivel 3
    }

    /**
     * Muestra el estado actual del almacén (stock de componentes y vehículos).
     * La implementación completa se realiza en el Nivel 3.
     */
    public void mostrarEstadoAlmacen() {
        // TODO: Nivel 3
    }

    /**
     * Solicita a la vista que actualice su presentación con los datos más recientes.
     */
    public void actualizarVista() {
        visualizador.actualizar();
    }

    /**
     * Obtiene el visualizador asociado al dashboard.
     *
     * @return Implementación de IVisualizacion activa.
     */
    public IVisualizacion getVisualizador() {
        return visualizador;
    }

    /**
     * Establece el visualizador del dashboard.
     *
     * @param visualizador Nueva implementación de IVisualizacion.
     */
    public void setVisualizador(IVisualizacion visualizador) {
        this.visualizador = visualizador;
    }
}
