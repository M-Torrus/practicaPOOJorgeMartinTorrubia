/**
 * Vehículo de tipo turismo de uso general.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Turismo extends Vehiculo {

    /**
     * Constructor de Turismo.
     *
     * @param color             Color de la carrocería.
     * @param numPlazas         Número de plazas.
     * @param tara              Peso en vacío en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado en kg.
     */
    public Turismo(String color, int numPlazas, double tara, double pesoMaxAutorizado) {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }
}
