/**
 * Vehículo deportivo de dos plazas.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class BiplazaDeportivo extends Vehiculo {

    /**
     * Constructor de BiplazaDeportivo.
     *
     * @param color             Color de la carrocería.
     * @param numPlazas         Número de plazas del vehículo.
     * @param tara              Peso en vacío en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado en kg.
     */
    public BiplazaDeportivo(String color, int numPlazas, double tara, double pesoMaxAutorizado) {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }
}
