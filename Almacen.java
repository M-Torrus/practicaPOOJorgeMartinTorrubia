import java.util.ArrayList;

/**
 * Implementación concreta del almacén de la fábrica.
 * Almacena motores, tapicerías, ruedas y vehículos en listas independientes.
 * Implementa la interfaz IAlmacen para mantener el desacoplamiento con SistemaGestion.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Almacen implements IAlmacen {
    private ArrayList<Motor> motores;
    private ArrayList<Tapiceria> tapicerias;
    private ArrayList<Rueda> ruedas;
    private ArrayList<Vehiculo> vehiculos;

    /**
     * Constructor de Almacen. Inicializa las colecciones vacías.
     */
    public Almacen() {
        motores = new ArrayList<>();
        tapicerias = new ArrayList<>();
        ruedas = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    /**
     * Añade un elemento al almacén según su tipo (Motor, Tapiceria, Rueda o Vehiculo).
     *
     * @param elemento Objeto a almacenar.
     */
    @Override
    public void añadir(Object elemento) {
        // TODO: Nivel 2
    }

    /**
     * Consulta el stock de un tipo de elemento del almacén.
     *
     * @param tipo Identificador del tipo ("motor", "tapiceria", "rueda" o "vehiculo").
     * @return Lista de elementos del tipo indicado, o null si el tipo no existe.
     */
    @Override
    public Object consultar(String tipo) {
        // TODO: Nivel 2
        return null;
    }

    /**
     * Actualiza los datos de un elemento ya existente en el almacén.
     *
     * @param elemento Objeto con los datos actualizados.
     */
    @Override
    public void actualizar(Object elemento) {
        // TODO: Nivel 2
    }

    /**
     * Obtiene la lista de motores almacenados.
     *
     * @return Lista de motores.
     */
    public ArrayList<Motor> getMotores() {
        return motores;
    }

    /**
     * Establece la lista de motores del almacén.
     *
     * @param motores Nueva lista de motores.
     */
    public void setMotores(ArrayList<Motor> motores) {
        this.motores = motores;
    }

    /**
     * Obtiene la lista de tapicerías almacenadas.
     *
     * @return Lista de tapicerías.
     */
    public ArrayList<Tapiceria> getTapicerias() {
        return tapicerias;
    }

    /**
     * Establece la lista de tapicerías del almacén.
     *
     * @param tapicerias Nueva lista de tapicerías.
     */
    public void setTapicerias(ArrayList<Tapiceria> tapicerias) {
        this.tapicerias = tapicerias;
    }

    /**
     * Obtiene la lista de ruedas almacenadas.
     *
     * @return Lista de ruedas.
     */
    public ArrayList<Rueda> getRuedas() {
        return ruedas;
    }

    /**
     * Establece la lista de ruedas del almacén.
     *
     * @param ruedas Nueva lista de ruedas.
     */
    public void setRuedas(ArrayList<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    /**
     * Obtiene la lista de vehículos almacenados.
     *
     * @return Lista de vehículos.
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos del almacén.
     *
     * @param vehiculos Nueva lista de vehículos.
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
