/**
 * Rueda de perfil deportivo, con mayor agarre y mayor código de velocidad.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class RuedaDeportivo extends Rueda {

    /**
     * Constructor de RuedaDeportivo.
     *
     * @param anchoMilimetros        Ancho del neumático en mm.
     * @param diametroLlantaPulgadas Diámetro de la llanta en pulgadas.
     * @param indiceCarga            Índice de carga en kg.
     * @param codigoVelocidad        Velocidad máxima admitida en km/h.
     */
    public RuedaDeportivo(double anchoMilimetros, double diametroLlantaPulgadas,
                          double indiceCarga, double codigoVelocidad) {
        super(anchoMilimetros, diametroLlantaPulgadas, indiceCarga, codigoVelocidad);
    }
}
