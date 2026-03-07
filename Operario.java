import java.util.Date;

/**
 * Clase abstracta que representa a un operario de cadena de montaje.
 * Extiende Trabajador añadiendo el contador de montajes realizados
 * y el método abstracto realizarTarea(), cuya duración depende del subtipo.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Operario extends Trabajador {
    private int montajesRealizados;

    /**
     * Constructor de Operario. Inicializa el contador de montajes a 0.
     *
     * @param nombre             Nombre del operario.
     * @param apellidos          Apellidos del operario.
     * @param DNI                DNI del operario.
     * @param direccion          Dirección del operario.
     * @param numSeguridadSocial Número de Seguridad Social.
     * @param puesto             Puesto de trabajo.
     * @param salario            Salario mensual bruto en euros.
     * @param fechaIngreso       Fecha de incorporación a la empresa.
     */
    public Operario(String nombre, String apellidos, String DNI, String direccion,
                    String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
        this.montajesRealizados = 0;
    }

    /**
     * Ejecuta la tarea de montaje asignada al operario.
     * La duración de la tarea depende del subtipo concreto de operario.
     *
     * @return Duración de la tarea en segundos.
     */
    public abstract int realizarTarea();

    /**
     * Obtiene el número de montajes realizados por este operario.
     *
     * @return Número de montajes realizados.
     */
    public int getMontajesRealizados() {
        return montajesRealizados;
    }

    /**
     * Establece el número de montajes realizados.
     *
     * @param montajesRealizados Nuevo número de montajes.
     */
    public void setMontajesRealizados(int montajesRealizados) {
        this.montajesRealizados = montajesRealizados;
    }

    /**
     * Incrementa en uno el contador de montajes realizados.
     */
    public void incrementarMontajes() {
        this.montajesRealizados++;
    }
}
