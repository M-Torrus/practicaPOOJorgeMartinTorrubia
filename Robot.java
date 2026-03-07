/**
 * Robot de cadena de montaje. Cada robot es responsable de montar un componente
 * concreto (chasis, motor, tapicería o ruedas) y trabaja asistido por un operario.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Robot {
    private String componente;
    private Operario operario;

    /**
     * Constructor de Robot.
     *
     * @param componente Nombre del componente que monta este robot
     *                   ("chasis", "motor", "tapiceria" o "ruedas").
     * @param operario   Operario asignado a supervisar este robot.
     */
    public Robot(String componente, Operario operario) {
        this.componente = componente;
        this.operario = operario;
    }

    /**
     * Ejecuta el montaje del componente asignado sobre el vehículo en construcción.
     * El tiempo de montaje depende del tipo de operario asignado.
     * La implementación completa se realiza en el Nivel 2.
     */
    public void montarComponente() {
        // TODO: Nivel 2
    }

    /**
     * Obtiene el nombre del componente que monta este robot.
     *
     * @return Nombre del componente.
     */
    public String getComponente() {
        return componente;
    }

    /**
     * Establece el componente que monta este robot.
     *
     * @param componente Nuevo nombre del componente.
     */
    public void setComponente(String componente) {
        this.componente = componente;
    }

    /**
     * Obtiene el operario asignado a este robot.
     *
     * @return Operario asignado.
     */
    public Operario getOperario() {
        return operario;
    }

    /**
     * Asigna un operario a este robot.
     *
     * @param operario Nuevo operario asignado.
     */
    public void setOperario(Operario operario) {
        this.operario = operario;
    }
}
