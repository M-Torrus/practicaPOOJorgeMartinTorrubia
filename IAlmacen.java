/**
 * Interfaz para comunicarse con el almacén de datos. Desacopla el
 * sistema de gestión de la implementación concreta AlmacenDatos.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public interface IAlmacen {

    /**
     * Añade un elemento al almacén.
     *
     * @param elemento Objeto a almacenar.
     */
    void añadir(Object elemento);

    /**
     * Consulta los datos de un tipo concreto de elementos del almacén.
     *
     * @param tipo Identificador del tipo de elemento a consultar.
     * @return Objeto con los datos consultados.
     */
    Object consultar(String tipo);

    /**
     * Actualiza los datos de un elemento ya existente en el almacén.
     *
     * @param elemento Objeto con los datos actualizados.
     */
    void actualizar(Object elemento);
}
