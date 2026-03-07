/**
 * Cadena de montaje especializada en un tipo de vehículo.
 * Contiene 4 robots (uno por componente: chasis, motor, tapicería y ruedas)
 * y 4 operarios asignados a supervisarlos. Gestiona el vehículo en construcción
 * y el estado operativo de la cadena.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class CadenaMontaje {
    private String tipoVehiculo;
    private Robot[] robots;
    private Operario[] operarios;
    private Vehiculo vehiculoEnConstruccion;
    private String estado;

    /**
     * Constructor de CadenaMontaje. Inicializa los arrays de robots y operarios
     * con capacidad para 4 elementos. El estado inicial es "parada".
     *
     * @param tipoVehiculo Tipo de vehículo que produce esta cadena
     *                     ("BiplazaDeportivo", "Turismo" o "Furgoneta").
     */
    public CadenaMontaje(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        this.robots = new Robot[4];
        this.operarios = new Operario[4];
        this.estado = "parada";
    }

    /**
     * Obtiene el tipo de vehículo que produce esta cadena.
     *
     * @return Tipo de vehículo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehículo que produce esta cadena.
     *
     * @param tipoVehiculo Nuevo tipo de vehículo.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Obtiene el array de robots de la cadena (índice 0=chasis, 1=motor, 2=tapicería, 3=ruedas).
     *
     * @return Array de 4 robots.
     */
    public Robot[] getRobots() {
        return robots;
    }

    /**
     * Establece el array de robots de la cadena.
     *
     * @param robots Nuevo array de robots.
     */
    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }

    /**
     * Obtiene el array de operarios asignados a la cadena.
     *
     * @return Array de 4 operarios.
     */
    public Operario[] getOperarios() {
        return operarios;
    }

    /**
     * Establece el array de operarios de la cadena.
     *
     * @param operarios Nuevo array de operarios.
     */
    public void setOperarios(Operario[] operarios) {
        this.operarios = operarios;
    }

    /**
     * Obtiene el vehículo que se está construyendo actualmente en esta cadena.
     *
     * @return Vehículo en construcción, o null si la cadena está parada.
     */
    public Vehiculo getVehiculoEnConstruccion() {
        return vehiculoEnConstruccion;
    }

    /**
     * Establece el vehículo en construcción de esta cadena.
     *
     * @param vehiculoEnConstruccion Vehículo a construir.
     */
    public void setVehiculoEnConstruccion(Vehiculo vehiculoEnConstruccion) {
        this.vehiculoEnConstruccion = vehiculoEnConstruccion;
    }

    /**
     * Obtiene el estado operativo de la cadena ("parada", "activa", "avería").
     *
     * @return Estado de la cadena.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado operativo de la cadena.
     *
     * @param estado Nuevo estado de la cadena.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
