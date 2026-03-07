/**
 * Rueda todoterreno, diseñada para terrenos irregulares con mayor índice de carga.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class RuedaTodoterreno extends Rueda {

    /**
     * Constructor de RuedaTodoterreno.
     *
     * @param anchoMilimetros        Ancho del neumático en mm.
     * @param diametroLlantaPulgadas Diámetro de la llanta en pulgadas.
     * @param indiceCarga            Índice de carga en kg.
     * @param codigoVelocidad        Velocidad máxima admitida en km/h.
     */
    public RuedaTodoterreno(double anchoMilimetros, double diametroLlantaPulgadas,
                            double indiceCarga, double codigoVelocidad) {
        super(anchoMilimetros, diametroLlantaPulgadas, indiceCarga, codigoVelocidad);
    }
}
