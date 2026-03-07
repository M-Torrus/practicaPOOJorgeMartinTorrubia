/**
 * Interfaz que define el contrato del almacén de la fábrica.
 * Desacopla el sistema de gestión de la implementación concreta del almacén,
 * permitiendo cambiar la implementación sin modificar el resto del sistema.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public interface IAlmacen {

    /**
     * Añade un elemento (motor, tapicería, rueda o vehículo) al almacén.
     *
     * @param elemento Objeto a almacenar.
     */
    void añadir(Object elemento);

    /**
     * Consulta el stock o los datos de un tipo de elemento del almacén.
     *
     * @param tipo Identificador del tipo de elemento a consultar.
     * @return Objeto o colección con los datos consultados.
     */
    Object consultar(String tipo);

    /**
     * Actualiza los datos de un elemento ya existente en el almacén.
     *
     * @param elemento Objeto con los datos actualizados.
     */
    void actualizar(Object elemento);
}
