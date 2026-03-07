/**
 * Motor de propulsión eléctrica. No consume combustible fósil.
 * La cilindrada se usa para indicar la capacidad de la batería equivalente.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class MotorElectrico extends Motor {

    /**
     * Constructor de MotorElectrico.
     *
     * @param cilindrada   Capacidad equivalente en cc.
     * @param potencia     Potencia en CV.
     * @param numCilindros Número de cilindros (0 en motores puramente eléctricos).
     */
    public MotorElectrico(double cilindrada, double potencia, int numCilindros) {
        super(cilindrada, potencia, numCilindros);
    }
}
