import java.util.Date;

/**
 * Gestor de planta: responsable de configurar y supervisar las cadenas de montaje.
 * Es el perfil encargado de seleccionar los componentes e indicar las unidades
 * a producir antes de iniciar cada simulación.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class GestorDePlanta extends Trabajador {

    /**
     * Constructor de GestorDePlanta.
     *
     * @param nombre             Nombre del gestor.
     * @param apellidos          Apellidos del gestor.
     * @param DNI                DNI del gestor.
     * @param direccion          Dirección del gestor.
     * @param numSeguridadSocial Número de Seguridad Social.
     * @param puesto             Puesto de trabajo.
     * @param salario            Salario mensual bruto en euros.
     * @param fechaIngreso       Fecha de incorporación a la empresa.
     */
    public GestorDePlanta(String nombre, String apellidos, String DNI, String direccion,
                          String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        super(nombre, apellidos, DNI, direccion, numSeguridadSocial, puesto, salario, fechaIngreso);
    }

    /**
     * Configura una cadena de montaje: selecciona componentes e indica unidades a producir.
     * La implementación completa se realiza en el Nivel 3.
     *
     * @param cadena La cadena de montaje a configurar.
     */
    public void configurarCadena(CadenaMontaje cadena) {
        // Para implementar en el nivel 3
    }
}
