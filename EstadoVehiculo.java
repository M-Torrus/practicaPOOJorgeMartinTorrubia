/**
 * Enumerado que representa las fases del proceso de montaje de un vehículo.
 * El orden de avance es: CHASIS → MOTOR → TAPICERIA → RUEDAS.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public enum EstadoVehiculo {
    /** Fase inicial: el chasis ha sido construido. */
    CHASIS,
    /** El motor ha sido instalado. */
    MOTOR,
    /** La tapicería ha sido instalada. */
    TAPICERIA,
    /** Las ruedas han sido instaladas. El vehículo está completo. */
    RUEDAS
}
