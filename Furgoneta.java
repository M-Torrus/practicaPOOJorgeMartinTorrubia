/**
 * Vehículo de tipo furgoneta, orientado al transporte de mercancías.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Furgoneta extends Vehiculo {

    /**
     * Constructor de Furgoneta.
     *
     * @param color             Color de la carrocería.
     * @param numPlazas         Número de plazas.
     * @param tara              Peso en vacío en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado en kg.
     */
    public Furgoneta(String color, int numPlazas, double tara, double pesoMaxAutorizado) {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }
}
