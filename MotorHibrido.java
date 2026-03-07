/**
 * Motor híbrido que combina propulsión de gasolina y eléctrica.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class MotorHibrido extends Motor {

    /**
     * Constructor de MotorHibrido.
     *
     * @param cilindrada   Cilindrada del bloque de combustión en cc.
     * @param potencia     Potencia combinada en CV.
     * @param numCilindros Número de cilindros del bloque de combustión.
     */
    public MotorHibrido(double cilindrada, double potencia, int numCilindros) {
        super(cilindrada, potencia, numCilindros);
    }
}
