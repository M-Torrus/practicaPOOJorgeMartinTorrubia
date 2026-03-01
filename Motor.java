
/**
 * Write a description of class Motor here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Motor {
    private double cilindrada;
    private double potencia;
    private int numCilindros;

    public Motor(double cilindrada, double potencia, int numCilindros) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.numCilindros = numCilindros;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getNumCilindros() {
        return numCilindros;
    }
}
