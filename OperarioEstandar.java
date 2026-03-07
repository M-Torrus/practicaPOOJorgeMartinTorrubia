import java.util.Date;

/**
 * Operario estándar: realiza cada tarea de montaje en 3 segundos.
 * Este perfil corresponde a operarios con 10 o menos montajes acumulados.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class OperarioEstandar extends Operario {

    /**
     * Constructor de OperarioEstandar.
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
    public OperarioEstandar(String nombre, String apellidos, String DNI, String direccion,
                            String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Realiza la tarea de montaje. Al ser estándar, siempre tarda 3 segundos.
     *
     * @return 3 (duración en segundos).
     */
    @Override
    public int realizarTarea() {
        incrementarMontajes();
        return 3;
    }
}
