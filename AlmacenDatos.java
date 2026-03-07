import java.util.ArrayList;

/**
 * Clase AlmacenDatos de datos, se encarga de los datos de motores, tapicerías, 
 * ruedas y vehículos en listas independientes, implementa la interfaz IAlmacen para mantener el desacoplamiento con SistemaGestion.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class AlmacenDatos implements IAlmacen {
    private ArrayList<Motor> motores;
    private ArrayList<Tapiceria> tapicerias;
    private ArrayList<Rueda> ruedas;
    private ArrayList<Vehiculo> vehiculos;

    /**
     * Constructor de la clase, inicializa las colecciones vacías.
     */
    public AlmacenDatos() {
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
        if (elemento instanceof Motor) {
            motores.add((Motor) elemento);
        } else if (elemento instanceof Tapiceria) {
            tapicerias.add((Tapiceria) elemento);
        } else if (elemento instanceof Rueda) {
            ruedas.add((Rueda) elemento);
        } else if (elemento instanceof Vehiculo) {
            vehiculos.add((Vehiculo) elemento);
        }
    }

    /**
     * Consulta el stock de un tipo de elemento del almacén.
     *
     * @param tipo Identificador del tipo ("motor", "tapiceria", "rueda" o "vehiculo").
     * @return Lista de elementos del tipo indicado, o null si el tipo no existe.
     */
    @Override
    public Object consultar(String tipo) {
        switch (tipo.toLowerCase()) {
            case "motor":     return motores;
            case "tapiceria": return tapicerias;
            case "rueda":     return ruedas;
            case "vehiculo":  return vehiculos;
            default:          return null;
        }
    }

    /**
     * Actualiza los datos de un elemento ya existente en el almacén.
     * Busca el elemento por referencia en su lista y lo reemplaza.
     *
     * @param elemento Objeto con los datos actualizados.
     */
    @Override
    public void actualizar(Object elemento) {
        if (elemento instanceof Motor) {
            int idx = motores.indexOf(elemento);
            if (idx >= 0) motores.set(idx, (Motor) elemento);
        } else if (elemento instanceof Tapiceria) {
            int idx = tapicerias.indexOf(elemento);
            if (idx >= 0) tapicerias.set(idx, (Tapiceria) elemento);
        } else if (elemento instanceof Rueda) {
            int idx = ruedas.indexOf(elemento);
            if (idx >= 0) ruedas.set(idx, (Rueda) elemento);
        } else if (elemento instanceof Vehiculo) {
            int idx = vehiculos.indexOf(elemento);
            if (idx >= 0) vehiculos.set(idx, (Vehiculo) elemento);
        }
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
