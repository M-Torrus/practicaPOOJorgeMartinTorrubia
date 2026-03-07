
/**
 * Write a description of class Vehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Vehiculo
{
    private String color;
    private int numPlazas;
    private double tara;
    private double pesoMax;

    /**
     * Constructor for objects of class Vehiculo
     */
    public Vehiculo(String color, int numPlazas, double tara, double pesoMax)
    {
        // initialise instance variables
        this.color = color;
        this.numPlazas = numPlazas;
        this.tara = tara;
        this.pesoMax = pesoMax;
    }

    public String getColor() {
        return color;
    }
    
    public int getNumPlazas() {
        return numPlazas;
    }

    public double getTara() {
        return tara;
    }

    public double getPesoMax() {
        return pesoMax;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }
    
    
    
}
