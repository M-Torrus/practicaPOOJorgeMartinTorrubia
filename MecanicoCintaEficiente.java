import java.util.Date;

/**
 * Mecánico de cinta eficiente: repara cualquier avería en 1 segundo.
 * Este perfil corresponde a mecánicos con más de 20 reparaciones acumuladas.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class MecanicoCintaEficiente extends MecanicoCinta {

    /**
     * Constructor de MecanicoCintaEficiente.
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
    public MecanicoCintaEficiente(String nombre, String apellidos, String DNI, String direccion,
                                  String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Repara un problema en la cinta. Al ser eficiente, siempre tarda 1 segundo.
     *
     * @return 1 (duración en segundos).
     */
    @Override
    public int repararCinta() {
        incrementarReparaciones();
        return 1;
    }
}
