import java.util.ArrayList;

/**
 * Sistema central de gestión de la fábrica de vehículos.
 * Coordina las tres cadenas de montaje, el almacén de datos, el dashboard
 * y el planificador. Es el punto de entrada a todas las funcionalidades del sistema.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class SistemaGestion {
    private CadenaMontaje[] cadenas;
    private IAlmacen almacen;
    private Dashboard dashboard;
    private Planificador planificador;

    /**
     * Constructor de SistemaGestion. Inicializa las tres cadenas de montaje
     * (BiplazaDeportivo, Turismo y Furgoneta), el almacén de datos, el dashboard
     * y el planificador.
     */
    public SistemaGestion() {
        this.almacen = new AlmacenDatos();
        this.dashboard = new Dashboard();
        this.cadenas = new CadenaMontaje[3];
        cadenas[0] = new CadenaMontaje("BiplazaDeportivo");
        cadenas[1] = new CadenaMontaje("Turismo");
        cadenas[2] = new CadenaMontaje("Furgoneta");
        this.planificador = new Planificador(cadenas, almacen);
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
    @SuppressWarnings("unchecked")
    public ArrayList<Trabajador> getTrabajadores() {
        return (ArrayList<Trabajador>) almacen.consultar("trabajador");
    }

    /**
     * Da de alta un trabajador en el sistema (lo almacena en el almacén de datos).
     *
     * @param trabajador Trabajador a registrar.
     */
    public void altaTrabajador(Trabajador trabajador) {
        almacen.añadir(trabajador);
    }

    /**
     * Busca trabajadores cuyo nombre o apellidos contengan el texto indicado
     * (sin distinción de mayúsculas/minúsculas).
     *
     * @param nombre Texto a buscar en nombre o apellidos.
     * @return Lista de trabajadores que coinciden con la búsqueda.
     */
    public ArrayList<Trabajador> buscarPorNombre(String nombre) {
        ArrayList<Trabajador> resultado = new ArrayList<>();
        String busqueda = nombre.toLowerCase();
        for (Trabajador t : getTrabajadores()) {
            if (t.getNombre().toLowerCase().contains(busqueda)
                    || t.getApellidos().toLowerCase().contains(busqueda)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    /**
     * Busca un trabajador por su DNI.
     *
     * @param dni DNI a buscar.
     * @return Trabajador encontrado, o null si no existe.
     */
    public Trabajador buscarPorDNI(String dni) {
        for (Trabajador t : getTrabajadores()) {
            if (t.getDNI().equalsIgnoreCase(dni)) return t;
        }
        return null;
    }

    /**
     * Busca trabajadores por tipo de perfil (nombre simple de la clase).
     * Ejemplos: "OperarioEficiente", "GestorDePlanta", "MecanicoCintaEstandar".
     *
     * @param tipo Nombre simple de la clase del perfil buscado.
     * @return Lista de trabajadores del tipo indicado.
     */
    public ArrayList<Trabajador> buscarPorTipo(String tipo) {
        ArrayList<Trabajador> resultado = new ArrayList<>();
        for (Trabajador t : getTrabajadores()) {
            if (t.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}
