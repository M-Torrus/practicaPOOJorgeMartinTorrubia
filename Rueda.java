/**
 * Clase abstracta que representa una rueda genérica de vehículo.
 * Define los atributos comunes: ancho, diámetro de llanta,
 * índice de carga y código de velocidad.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Rueda {
    private double anchoMilimetros;
    private double diametroLlantaPulgadas;
    private double indiceCarga;
    private double codigoVelocidad;

    /**
     * Constructor de Rueda.
     *
     * @param anchoMilimetros       Ancho del neumático en mm.
     * @param diametroLlantaPulgadas Diámetro de la llanta en pulgadas.
     * @param indiceCarga           Índice de carga máxima en kg.
     * @param codigoVelocidad       Velocidad máxima admitida en km/h.
     */
    public Rueda(double anchoMilimetros, double diametroLlantaPulgadas,
                 double indiceCarga, double codigoVelocidad) {
        this.anchoMilimetros = anchoMilimetros;
        this.diametroLlantaPulgadas = diametroLlantaPulgadas;
        this.indiceCarga = indiceCarga;
        this.codigoVelocidad = codigoVelocidad;
    }

    /**
     * Obtiene el ancho del neumático.
     *
     * @return Ancho en mm.
     */
    public double getAnchoMilimetros() {
        return anchoMilimetros;
    }

    /**
     * Establece el ancho del neumático.
     *
     * @param anchoMilimetros Nuevo ancho en mm.
     */
    public void setAnchoMilimetros(double anchoMilimetros) {
        this.anchoMilimetros = anchoMilimetros;
    }

    /**
     * Obtiene el diámetro de la llanta.
     *
     * @return Diámetro en pulgadas.
     */
    public double getDiametroLlantaPulgadas() {
        return diametroLlantaPulgadas;
    }

    /**
     * Establece el diámetro de la llanta.
     *
     * @param diametroLlantaPulgadas Nuevo diámetro en pulgadas.
     */
    public void setDiametroLlantaPulgadas(double diametroLlantaPulgadas) {
        this.diametroLlantaPulgadas = diametroLlantaPulgadas;
    }

    /**
     * Obtiene el índice de carga de la rueda.
     *
     * @return Índice de carga en kg.
     */
    public double getIndiceCarga() {
        return indiceCarga;
    }

    /**
     * Establece el índice de carga de la rueda.
     *
     * @param indiceCarga Nuevo índice de carga en kg.
     */
    public void setIndiceCarga(double indiceCarga) {
        this.indiceCarga = indiceCarga;
    }

    /**
     * Obtiene el código de velocidad máxima admitida.
     *
     * @return Velocidad máxima en km/h.
     */
    public double getCodigoVelocidad() {
        return codigoVelocidad;
    }

    /**
     * Establece el código de velocidad máxima admitida.
     *
     * @param codigoVelocidad Nueva velocidad máxima en km/h.
     */
    public void setCodigoVelocidad(double codigoVelocidad) {
        this.codigoVelocidad = codigoVelocidad;
    }
}
