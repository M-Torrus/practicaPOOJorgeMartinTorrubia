import java.util.ArrayList;

/**
 * Write a description of class SistemaGestion here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class SistemaGestion {
    private CadenaMontaje[] cadenas;
    private IAlmacen almacen;
    private Dashboard dashboard;
    private Planificador planificador;
    private ArrayList<Trabajador> trabajadores;

    public SistemaGestion() {
        this.almacen = new Almacen();
        this.dashboard = new Dashboard(new VistaTextual());
        this.cadenas = new CadenaMontaje[3];
        cadenas[0] = new CadenaMontaje("BiplazaDeportivo");
        cadenas[1] = new CadenaMontaje("Turismo");
        cadenas[2] = new CadenaMontaje("Furgoneta");
        this.planificador = new Planificador(cadenas);
        this.trabajadores = new ArrayList<>();
    }

    public CadenaMontaje[] getCadenas() {
        return cadenas;
    }

    public void setCadenas(CadenaMontaje[] cadenas) {
        this.cadenas = cadenas;
    }

    public IAlmacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(IAlmacen almacen) {
        this.almacen = almacen;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

}