/**
 * Rueda de uso estándar para vehículos de turismo convencionales.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class RuedaNormal extends Rueda {

    /**
     * Constructor de RuedaNormal.
     *
     * @param anchoMilimetros        Ancho del neumático en mm.
     * @param diametroLlantaPulgadas Diámetro de la llanta en pulgadas.
     * @param indiceCarga            Índice de carga en kg.
     * @param codigoVelocidad        Velocidad máxima admitida en km/h.
     */
    public RuedaNormal(double anchoMilimetros, double diametroLlantaPulgadas,
                       double indiceCarga, double codigoVelocidad) {
        super(anchoMilimetros, diametroLlantaPulgadas, indiceCarga, codigoVelocidad);
    }
}
