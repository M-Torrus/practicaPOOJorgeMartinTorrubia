/**
 * Clase abstracta que representa un motor genérico de vehículo.
 * Define los atributos comunes a todos los tipos de motor:
 * cilindrada, potencia y número de cilindros.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Motor {
    private double cilindrada;
    private double potencia;
    private int numCilindros;

    /**
     * Constructor de Motor.
     *
     * @param cilindrada   Cilindrada del motor en cc.
     * @param potencia     Potencia del motor en CV.
     * @param numCilindros Número de cilindros del motor.
     */
    public Motor(double cilindrada, double potencia, int numCilindros) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.numCilindros = numCilindros;
    }

    /**
     * Obtiene la cilindrada del motor.
     *
     * @return Cilindrada en cc.
     */
    public double getCilindrada() {
        return cilindrada;
    }

    /**
     * Establece la cilindrada del motor.
     *
     * @param cilindrada Nueva cilindrada en cc.
     */
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Obtiene la potencia del motor.
     *
     * @return Potencia en CV.
     */
    public double getPotencia() {
        return potencia;
    }

    /**
     * Establece la potencia del motor.
     *
     * @param potencia Nueva potencia en CV.
     */
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    /**
     * Obtiene el número de cilindros del motor.
     *
     * @return Número de cilindros.
     */
    public int getNumCilindros() {
        return numCilindros;
    }

    /**
     * Establece el número de cilindros del motor.
     *
     * @param numCilindros Nuevo número de cilindros.
     */
    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }
}
