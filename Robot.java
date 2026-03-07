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
     * El operario realiza la tarea y el robot espera el tiempo correspondiente
     * (1 segundo para OperarioEficiente, 3 segundos para OperarioEstandar).
     */
    public void montarComponente() {
        int tiempo = operario.realizarTarea();
        try {
            Thread.sleep(tiempo * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
