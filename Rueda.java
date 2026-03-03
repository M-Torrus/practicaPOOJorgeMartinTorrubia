
/**
 * Write a description of class Rueda here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Rueda {
    private double anchoMilimetros;
    private double diametroLlantaPulgadas;
    private double cargaKG;
    private double codVelocidadKMPorHora;

    public Rueda(double anchoMilimetros, double diametroLlantaPulgadas, double cargaKG,
            double codVelocidadKMPorHora) {
        this.anchoMilimetros = anchoMilimetros;
        this.diametroLlantaPulgadas = diametroLlantaPulgadas;
        this.cargaKG = cargaKG;
        this.codVelocidadKMPorHora = codVelocidadKMPorHora;
    }

    public double getAnchoMilimetros() {
        return anchoMilimetros;
    }

    public void setAnchoMilimetros(double anchoMilimetros) {
        this.anchoMilimetros = anchoMilimetros;
    }

    public double getDiametroLlantaPulgadas() {
        return diametroLlantaPulgadas;
    }

    public void setDiametroLlantaPulgadas(double diametroLlantaPulgadas) {
        this.diametroLlantaPulgadas = diametroLlantaPulgadas;
    }

    public double getCargaKG() {
        return cargaKG;
    }

    public void setCargaKG(double cargaKG) {
        this.cargaKG = cargaKG;
    }

    public double getCodVelocidadKMPorHora() {
        return codVelocidadKMPorHora;
    }

    public void setCodVelocidadKMPorHora(double codVelocidadKMPorHora) {
        this.codVelocidadKMPorHora = codVelocidadKMPorHora;
    }

}
