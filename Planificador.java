/**
 * Planificador del proceso de producción. Controla las tres cadenas de montaje
 * y orquesta las simulaciones segundo a segundo. Ofrece tres modos de simulación
 * con niveles de complejidad creciente.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class Planificador {
    private CadenaMontaje[] cadenas;
    private IAlmacen almacen;

    /**
     * Constructor de Planificador.
     *
     * @param cadenas Array de 3 cadenas de montaje a controlar.
     * @param almacen Almacén del sistema para consultar y actualizar componentes.
     */
    public Planificador(CadenaMontaje[] cadenas, IAlmacen almacen) {
        this.cadenas = cadenas;
        this.almacen = almacen;
    }

    /**
     * Ejecuta la simulación simple: sin averías, operarios seleccionados aleatoriamente.
     * Cada cadena corre en su propio hilo. Los tiempos de montaje dependen del tipo de
     * operario asignado (OperarioEficiente: 1s, OperarioEstandar: 3s por componente).
     */
    @SuppressWarnings("unchecked")
    public void simulacionSimple() {
        java.util.ArrayList<Motor> motores =
            (java.util.ArrayList<Motor>) almacen.consultar("motor");
        java.util.ArrayList<Tapiceria> tapicerias =
            (java.util.ArrayList<Tapiceria>) almacen.consultar("tapiceria");
        java.util.ArrayList<Rueda> ruedas =
            (java.util.ArrayList<Rueda>) almacen.consultar("rueda");

        if (motores.size() < cadenas.length
                || tapicerias.size() < cadenas.length
                || ruedas.size() < cadenas.length) {
            System.out.println("Stock insuficiente para iniciar la simulación.");
            return;
        }

        System.out.println("\n=== INICIANDO SIMULACIÓN SIMPLE ===");

        Thread[] hilos = new Thread[cadenas.length];
        for (int i = 0; i < cadenas.length; i++) {
            final int idx = i;
            final Motor motor = motores.remove(0);
            final Tapiceria tapiceria = tapicerias.remove(0);
            final Rueda rueda = ruedas.remove(0);

            hilos[i] = new Thread(() -> {
                CadenaMontaje cadena = cadenas[idx];
                Vehiculo vehiculo = crearVehiculo(cadena.getTipoVehiculo());
                cadena.setVehiculoEnConstruccion(vehiculo);
                cadena.setEstado("activa");

                // Asignar operarios aleatorios a los 4 robots
                String[] componentes = {"chasis", "motor", "tapiceria", "ruedas"};
                for (int j = 0; j < 4; j++) {
                    cadena.getRobots()[j] = new Robot(componentes[j], crearOperarioAleatorio());
                }

                // Montar chasis
                System.out.println("[" + cadena.getTipoVehiculo() + "] Montando chasis...");
                cadena.getRobots()[0].montarComponente();
                System.out.println("[" + cadena.getTipoVehiculo() + "] Chasis listo. Estado: " + vehiculo.getEstado());

                // Montar motor
                System.out.println("[" + cadena.getTipoVehiculo() + "] Montando motor...");
                cadena.getRobots()[1].montarComponente();
                vehiculo.setMotor(motor);
                vehiculo.setEstado(EstadoVehiculo.MOTOR);
                System.out.println("[" + cadena.getTipoVehiculo() + "] Motor listo. Estado: " + vehiculo.getEstado());

                // Montar tapicería
                System.out.println("[" + cadena.getTipoVehiculo() + "] Montando tapicería...");
                cadena.getRobots()[2].montarComponente();
                vehiculo.setTapiceria(tapiceria);
                vehiculo.setEstado(EstadoVehiculo.TAPICERIA);
                System.out.println("[" + cadena.getTipoVehiculo() + "] Tapicería lista. Estado: " + vehiculo.getEstado());

                // Montar ruedas
                System.out.println("[" + cadena.getTipoVehiculo() + "] Montando ruedas...");
                cadena.getRobots()[3].montarComponente();
                vehiculo.setRuedas(rueda);
                vehiculo.setEstado(EstadoVehiculo.RUEDAS);
                System.out.println("[" + cadena.getTipoVehiculo() + "] Ruedas listas. Estado: " + vehiculo.getEstado());

                // Vehículo completado
                cadena.setEstado("parada");
                cadena.setVehiculoEnConstruccion(null);
                almacen.añadir(vehiculo);
                System.out.println("[" + cadena.getTipoVehiculo() + "] Vehículo completado y almacenado.\n");
            });
        }

        for (Thread hilo : hilos) hilo.start();
        for (Thread hilo : hilos) {
            try { hilo.join(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println("=== SIMULACIÓN COMPLETADA ===");
    }

    /**
     * Crea un vehículo del tipo indicado con valores por defecto.
     *
     * @param tipo Tipo de vehículo ("BiplazaDeportivo", "Turismo" o "Furgoneta").
     * @return Nueva instancia del vehículo correspondiente.
     */
    private Vehiculo crearVehiculo(String tipo) {
        switch (tipo) {
            case "BiplazaDeportivo": return new BiplazaDeportivo("rojo",  2, 1100.0, 1400.0);
            case "Turismo":          return new Turismo("gris",           5, 1500.0, 2000.0);
            case "Furgoneta":        return new Furgoneta("blanco",       3, 2000.0, 3500.0);
            default:                 return new Turismo("gris",           5, 1500.0, 2000.0);
        }
    }

    /**
     * Crea un operario de tipo aleatorio (eficiente o estándar) con datos genéricos.
     *
     * @return Nueva instancia de OperarioEficiente u OperarioEstandar.
     */
    private Operario crearOperarioAleatorio() {
        java.util.Date ahora = new java.util.Date();
        if (Math.random() < 0.5) {
            return new OperarioEficiente("Op", "Eficiente", "00000000A",
                    "Fabrica", "000000000000", "Operario", 1500.0, ahora);
        } else {
            return new OperarioEstandar("Op", "Estandar", "00000000B",
                    "Fabrica", "000000000001", "Operario", 1300.0, ahora);
        }
    }

    /**
     * Obtiene el array de cadenas de montaje controladas por el planificador.
     *
     * @return Array de 3 cadenas de montaje.
     */
    public CadenaMontaje[] getCadenas() {
        return cadenas;
    }

    /**
     * Establece las cadenas de montaje a controlar.
     *
     * @param cadenas Nuevo array de cadenas de montaje.
     */
    public void setCadenas(CadenaMontaje[] cadenas) {
        this.cadenas = cadenas;
    }

    /**
     * Obtiene el almacén asociado al planificador.
     *
     * @return Implementación de IAlmacen en uso.
     */
    public IAlmacen getAlmacen() {
        return almacen;
    }

    /**
     * Establece el almacén asociado al planificador.
     *
     * @param almacen Nueva implementación de IAlmacen.
     */
    public void setAlmacen(IAlmacen almacen) {
        this.almacen = almacen;
    }
}
