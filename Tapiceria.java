/**
 * Clase abstracta que representa la tapicería interior de un vehículo.
 * Define los atributos comunes: color y metros cuadrados de material.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Tapiceria {
    private String color;
    private double metrosCuadrados;

    /**
     * Constructor de Tapiceria.
     *
     * @param color          Color de la tapicería.
     * @param metrosCuadrados Superficie total de material en m².
     */
    public Tapiceria(String color, double metrosCuadrados) {
        this.color = color;
        this.metrosCuadrados = metrosCuadrados;
    }

    /**
     * Obtiene el color de la tapicería.
     *
     * @return Color de la tapicería.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la tapicería.
     *
     * @param color Nuevo color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene los metros cuadrados de material de la tapicería.
     *
     * @return Superficie en m².
     */
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    /**
     * Establece los metros cuadrados de material.
     *
     * @param metrosCuadrados Nueva superficie en m².
     */
    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
}
