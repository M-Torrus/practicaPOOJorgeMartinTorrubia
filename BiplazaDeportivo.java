/**
 * Vehículo deportivo de dos plazas. El número de plazas es fijo (2)
 * y se establece automáticamente en el constructor.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class BiplazaDeportivo extends Vehiculo {

    /**
     * Constructor de BiplazaDeportivo. Las plazas quedan fijadas a 2.
     *
     * @param color             Color de la carrocería.
     * @param tara              Peso en vacío en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado en kg.
     */
    public BiplazaDeportivo(String color, double tara, double pesoMaxAutorizado) {
        super(color, 2, tara, pesoMaxAutorizado);
    }
}
