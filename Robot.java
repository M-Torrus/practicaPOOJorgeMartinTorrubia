
/**
 * Write a description of class Robot here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Robot {
    private String componente;
    private Operario operario;

    public Robot(String componente, Operario operario) {
        this.componente = componente;
        this.operario = operario;
    }

    public void montarComponente() {
        // TODO: Nivel 2
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }
}