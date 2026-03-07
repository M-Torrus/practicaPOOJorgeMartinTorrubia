
/**
 * Write a description of interface IAlmacen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public interface IAlmacen {
    void añadir(Object elemento);

    Object consultar(String tipo);

    void actualizar(Object elemento);
}