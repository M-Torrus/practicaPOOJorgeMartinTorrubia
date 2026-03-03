
/**
 * Clase abstracta que representa a los trabjadores de la fabrica de coches
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Trabajador {
    private String nombre;
    private String DNI;
    private String dirección;
    private String numSeguridadSocial;
    private String puesto;
    private double salario;
    private String fechaIngreso;

    public Trabajador(String nombre, String DNI, String dirección, String numSeguridadSocial, String puesto,
            double salario, String fechaIngreso) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.dirección = dirección;
        this.numSeguridadSocial = numSeguridadSocial;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
