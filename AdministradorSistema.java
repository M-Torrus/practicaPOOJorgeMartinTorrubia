import java.util.Date;

/**
 * Administrador del sistema: gestiona incidencias críticas como caídas de luz.
 * Al restaurar el sistema emplea 2 segundos en tareas de gestión y
 * 3 segundos adicionales para restablecer las cadenas de montaje.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class AdministradorSistema extends Trabajador {

    /**
     * Constructor de AdministradorSistema.
     *
     * @param nombre             Nombre del administrador.
     * @param apellidos          Apellidos del administrador.
     * @param DNI                DNI del administrador.
     * @param direccion          Dirección del administrador.
     * @param numSeguridadSocial Número de Seguridad Social.
     * @param puesto             Puesto de trabajo.
     * @param salario            Salario mensual bruto en euros.
     * @param fechaIngreso       Fecha de incorporación a la empresa.
     */
    public AdministradorSistema(String nombre, String apellidos, String DNI, String direccion,
                                String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Restaura el sistema tras una incidencia (ej. caída de luz).
     * Bloquea todas las cadenas durante 5 segundos en total:
     * 2s de gestión del sistema + 3s de restablecimiento de cadenas.
     * La implementación completa se realiza en el Nivel 3.
     */
    public void restaurarSistema() {
        // Para implementar en el nivel 3
    }
}
