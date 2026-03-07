import java.util.ArrayList;

/**
 * Sistema central de gestión de la fábrica de vehículos.
 * Agrupa y coordina las tres cadenas de montaje, el almacén, el dashboard,
 * el planificador y la lista de trabajadores. Es el punto de entrada
 * a todas las funcionalidades del sistema.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class SistemaGestion {
    private CadenaMontaje[] cadenas;
    private IAlmacen almacen;
    private Dashboard dashboard;
    private Planificador planificador;
    private ArrayList<Trabajador> trabajadores;

    /**
     * Constructor de SistemaGestion. Inicializa las tres cadenas de montaje
     * (BiplazaDeportivo, Turismo y Furgoneta), el almacén, el dashboard con
     * vista textual, el planificador y la lista de trabajadores.
     */
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

    /**
     * Obtiene el array de cadenas de montaje del sistema.
     *
     * @return Array de 3 cadenas de montaje.
     */
    public CadenaMontaje[] getCadenas() {
        return cadenas;
    }

    /**
     * Establece las cadenas de montaje del sistema.
     *
     * @param cadenas Nuevo array de cadenas de montaje.
     */
    public void setCadenas(CadenaMontaje[] cadenas) {
        this.cadenas = cadenas;
    }

    /**
     * Obtiene el almacén del sistema (mediante la interfaz IAlmacen).
     *
     * @return Almacén del sistema.
     */
    public IAlmacen getAlmacen() {
        return almacen;
    }

    /**
     * Establece el almacén del sistema.
     *
     * @param almacen Nueva implementación de IAlmacen.
     */
    public void setAlmacen(IAlmacen almacen) {
        this.almacen = almacen;
    }

    /**
     * Obtiene el dashboard de monitorización.
     *
     * @return Dashboard del sistema.
     */
    public Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * Establece el dashboard de monitorización.
     *
     * @param dashboard Nuevo dashboard.
     */
    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    /**
     * Obtiene el planificador de simulaciones.
     *
     * @return Planificador del sistema.
     */
    public Planificador getPlanificador() {
        return planificador;
    }

    /**
     * Establece el planificador de simulaciones.
     *
     * @param planificador Nuevo planificador.
     */
    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }

    /**
     * Obtiene la lista de trabajadores registrados en el sistema.
     *
     * @return Lista de trabajadores.
     */
    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    /**
     * Establece la lista de trabajadores del sistema.
     *
     * @param trabajadores Nueva lista de trabajadores.
     */
    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
