/**
 * Motor de combustión interna que funciona con gasolina.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class MotorGasolina extends Motor {

    /**
     * Constructor de MotorGasolina.
     *
     * @param cilindrada   Cilindrada en cc.
     * @param potencia     Potencia en CV.
     * @param numCilindros Número de cilindros.
     */
    public MotorGasolina(double cilindrada, double potencia, int numCilindros) {
        super(cilindrada, potencia, numCilindros);
    }
}
