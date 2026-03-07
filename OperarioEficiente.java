import java.util.Date;

/**
 * Operario eficiente: realiza cada tarea de montaje en 1 segundo.
 * Este perfil corresponde a operarios con más de 10 montajes acumulados.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class OperarioEficiente extends Operario {

    /**
     * Constructor de OperarioEficiente.
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
    public OperarioEficiente(String nombre, String apellidos, String DNI, String direccion,
                             String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Realiza la tarea de montaje. Al ser eficiente, siempre tarda 1 segundo.
     *
     * @return 1 (duración en segundos).
     */
    @Override
    public int realizarTarea() {
        incrementarMontajes();
        return 1;
    }
}
