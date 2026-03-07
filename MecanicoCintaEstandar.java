import java.util.Date;

/**
 * Mecánico de cinta estándar: repara averías en un tiempo variable de 2 a 5 segundos.
 * Este perfil corresponde a mecánicos con 20 o menos reparaciones acumuladas.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class MecanicoCintaEstandar extends MecanicoCinta {

    /**
     * Constructor de MecanicoCintaEstandar.
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
    public MecanicoCintaEstandar(String nombre, String apellidos, String DNI, String direccion,
                                 String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Repara un problema en la cinta. Al ser estándar, tarda entre 2 y 5 segundos (aleatorio).
     *
     * @return Duración aleatoria entre 2 y 5 segundos.
     */
    @Override
    public int repararCinta() {
        incrementarReparaciones();
        return 2 + (int) (Math.random() * 4);
    }
}
