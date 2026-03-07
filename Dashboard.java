
/**
 * Write a description of class Dashboard here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dashboard {
    private IVisualizacion visualizador;

    public Dashboard(IVisualizacion visualizador) {
        this.visualizador = visualizador;
    }

    public void mostrarEstadoCadenas() {
        // TODO: Nivel 3
    }

    public void mostrarEstadoAlmacen() {
        // TODO: Nivel 3
    }

    public void actualizarVista() {
        visualizador.actualizar();
    }

    public IVisualizacion getVisualizador() {
        return visualizador;
    }

    public void setVisualizador(IVisualizacion visualizador) {
        this.visualizador = visualizador;
    }
}