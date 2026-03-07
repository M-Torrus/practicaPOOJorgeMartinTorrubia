/**
 * Planificador del proceso de producción. Controla las tres cadenas de montaje
 * y orquesta las simulaciones segundo a segundo. Ofrece tres modos de simulación
 * con niveles de complejidad creciente.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Planificador {
    private CadenaMontaje[] cadenas;

    /**
     * Constructor de Planificador.
     *
     * @param cadenas Array de 3 cadenas de montaje a controlar.
     */
    public Planificador(CadenaMontaje[] cadenas) {
        this.cadenas = cadenas;
    }

    /**
     * Ejecuta la simulación simple: sin averías, operarios seleccionados aleatoriamente.
     * Avanza segundo a segundo montando chasis, motor, tapicería y ruedas en las 3 cadenas.
     * La implementación completa se realiza en el Nivel 2.
     */
    public void simulacionSimple() {
        // TODO: Nivel 2
    }

    /**
     * Ejecuta la simulación compleja: incluye averías en las cintas atendidas por mecánicos.
     * La implementación completa se realiza en el Nivel 3.
     */
    public void simulacionCompleja() {
        // TODO: Nivel 3
    }

    /**
     * Ejecuta la simulación muy compleja: incluye averías, operarios estándar y caída de luz
     * gestionada por el administrador del sistema.
     * La implementación completa se realiza en el Nivel 3.
     */
    public void simulacionMuyCompleja() {
        // TODO: Nivel 3
    }

    /**
     * Obtiene el array de cadenas de montaje controladas por el planificador.
     *
     * @return Array de 3 cadenas de montaje.
     */
    public CadenaMontaje[] getCadenas() {
        return cadenas;
    }

    /**
     * Establece las cadenas de montaje a controlar.
     *
     * @param cadenas Nuevo array de cadenas de montaje.
     */
    public void setCadenas(CadenaMontaje[] cadenas) {
        this.cadenas = cadenas;
    }
}
