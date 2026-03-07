/**
 * Clase abstracta que representa un vehículo genérico de la fábrica.
 * Contiene los atributos comunes a todos los tipos de vehículos:
 * color, número de plazas, tara, peso máximo autorizado, estado de montaje
 * y los componentes ensamblados (motor, tapicería y ruedas).
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Vehiculo {
    private String color;
    private int numPlazas;
    private double tara;
    private double pesoMaxAutorizado;
    private EstadoVehiculo estado;
    private Motor motor;
    private Tapiceria tapiceria;
    private Rueda ruedas;

    /**
     * Constructor de Vehiculo. El estado inicial es CHASIS y los componentes
     * (motor, tapicería, ruedas) comienzan a null hasta ser ensamblados.
     *
     * @param color             Color de la carrocería del vehículo.
     * @param numPlazas         Número de plazas del vehículo.
     * @param tara              Peso en vacío del vehículo en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado del vehículo en kg.
     */
    public Vehiculo(String color, int numPlazas, double tara, double pesoMaxAutorizado) {
        this.color = color;
        this.numPlazas = numPlazas;
        this.tara = tara;
        this.pesoMaxAutorizado = pesoMaxAutorizado;
        this.estado = EstadoVehiculo.CHASIS;
        this.motor = null;
        this.tapiceria = null;
        this.ruedas = null;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return Color de la carrocería.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color Nuevo color de la carrocería.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el número de plazas del vehículo.
     *
     * @return Número de plazas.
     */
    public int getNumPlazas() {
        return numPlazas;
    }

    /**
     * Establece el número de plazas del vehículo.
     *
     * @param numPlazas Nuevo número de plazas.
     */
    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    /**
     * Obtiene la tara (peso en vacío) del vehículo.
     *
     * @return Tara en kg.
     */
    public double getTara() {
        return tara;
    }

    /**
     * Establece la tara del vehículo.
     *
     * @param tara Nueva tara en kg.
     */
    public void setTara(double tara) {
        this.tara = tara;
    }

    /**
     * Obtiene el peso máximo autorizado del vehículo.
     *
     * @return Peso máximo autorizado en kg.
     */
    public double getPesoMaxAutorizado() {
        return pesoMaxAutorizado;
    }

    /**
     * Establece el peso máximo autorizado del vehículo.
     *
     * @param pesoMaxAutorizado Nuevo peso máximo autorizado en kg.
     */
    public void setPesoMaxAutorizado(double pesoMaxAutorizado) {
        this.pesoMaxAutorizado = pesoMaxAutorizado;
    }

    /**
     * Obtiene el estado de montaje actual del vehículo.
     *
     * @return Estado actual (CHASIS, MOTOR, TAPICERIA o RUEDAS).
     */
    public EstadoVehiculo getEstado() {
        return estado;
    }

    /**
     * Establece el estado de montaje del vehículo.
     *
     * @param estado Nuevo estado de montaje.
     */
    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el motor instalado en el vehículo.
     *
     * @return Motor del vehículo, o null si aún no se ha montado.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Establece el motor del vehículo.
     *
     * @param motor Motor a instalar.
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Obtiene la tapicería instalada en el vehículo.
     *
     * @return Tapicería del vehículo, o null si aún no se ha montado.
     */
    public Tapiceria getTapiceria() {
        return tapiceria;
    }

    /**
     * Establece la tapicería del vehículo.
     *
     * @param tapiceria Tapicería a instalar.
     */
    public void setTapiceria(Tapiceria tapiceria) {
        this.tapiceria = tapiceria;
    }

    /**
     * Obtiene las ruedas instaladas en el vehículo.
     *
     * @return Ruedas del vehículo, o null si aún no se han montado.
     */
    public Rueda getRuedas() {
        return ruedas;
    }

    /**
     * Establece las ruedas del vehículo.
     *
     * @param ruedas Ruedas a instalar.
     */
    public void setRuedas(Rueda ruedas) {
        this.ruedas = ruedas;
    }
}
