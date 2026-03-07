import java.util.Date;

/**
 * Clase abstracta que representa a un mecánico de cinta de montaje.
 * Extiende Trabajador añadiendo el contador de reparaciones realizadas
 * y el método abstracto repararCinta(), cuya duración depende del subtipo.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class MecanicoCinta extends Trabajador {
    private int reparacionesRealizadas;

    /**
     * Constructor de MecanicoCinta. Inicializa el contador de reparaciones a 0.
     *
     * @param nombre             Nombre del mecánico.
     * @param apellidos          Apellidos del mecánico.
     * @param DNI                DNI del mecánico.
     * @param direccion          Dirección del mecánico.
     * @param numSeguridadSocial Número de Seguridad Social.
     * @param puesto             Puesto de trabajo.
     * @param salario            Salario mensual bruto en euros.
     * @param fechaIngreso       Fecha de incorporación a la empresa.
     */
    public MecanicoCinta(String nombre, String apellidos, String DNI, String direccion,
                         String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
        this.reparacionesRealizadas = 0;
    }

    /**
     * Repara un problema en la cinta de montaje.
     * La duración depende del subtipo concreto de mecánico.
     *
     * @return Duración de la reparación en segundos.
     */
    public abstract int repararCinta();

    /**
     * Obtiene el número de reparaciones realizadas por este mecánico.
     *
     * @return Número de reparaciones realizadas.
     */
    public int getReparacionesRealizadas() {
        return reparacionesRealizadas;
    }

    /**
     * Establece el número de reparaciones realizadas.
     *
     * @param reparacionesRealizadas Nuevo número de reparaciones.
     */
    public void setReparacionesRealizadas(int reparacionesRealizadas) {
        this.reparacionesRealizadas = reparacionesRealizadas;
    }

    /**
     * Incrementa en uno el contador de reparaciones realizadas.
     */
    public void incrementarReparaciones() {
        this.reparacionesRealizadas++;
    }
}
