
/**
 * Write a description of class CadenaMontaje here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CadenaMontaje {

    private String tipoVehiculo;
    private Robot[] robots;
    private Operario[] operarios;
    private Vehiculo vehiculoEnConstruccion;
    private String estado;

    public CadenaMontaje(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        this.robots = new Robot[4];
        this.operarios = new Operario[4];
        this.estado = "parada";
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Robot[] getRobots() {
        return robots;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }

    public Operario[] getOperarios() {
        return operarios;
    }

    public void setOperarios(Operario[] operarios) {
        this.operarios = operarios;
    }

    public Vehiculo getVehiculoEnConstruccion() {
        return vehiculoEnConstruccion;
    }

    public void setVehiculoEnConstruccion(Vehiculo vehiculoEnConstruccion) {
        this.vehiculoEnConstruccion = vehiculoEnConstruccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}