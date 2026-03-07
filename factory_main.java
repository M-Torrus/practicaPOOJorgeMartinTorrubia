import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase principal de la aplicación. Punto de entrada del sistema de gestión
 * de la fábrica de vehículos. Crea el SistemaGestion y lanza el menú principal.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public class factory_main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaGestion sistema = new SistemaGestion();

    /**
     * Método principal. Inicializa el sistema y lanza el menú interactivo.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== FÁBRICA DE VEHÍCULOS ===");
            System.out.println("1. Gestión de trabajadores");
            System.out.println("2. Gestión de almacén");
            System.out.println("3. Ejecutar simulación simple");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = leerEntero();
            switch (opcion) {
                case 1: menuTrabajadores(); break;
                case 2: menuAlmacen();      break;
                case 3: sistema.getPlanificador().simulacionSimple(); break;
                case 0: System.out.println("Hasta pronto."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    // -------------------------------------------------------------------------
    // Menú de trabajadores
    // -------------------------------------------------------------------------

    /**
     * Submenú de gestión de trabajadores.
     */
    private static void menuTrabajadores() {
        int opcion;
        do {
            System.out.println("\n-- TRABAJADORES --");
            System.out.println("1. Dar de alta trabajador");
            System.out.println("2. Buscar por nombre / apellidos");
            System.out.println("3. Buscar por DNI");
            System.out.println("4. Buscar por tipo de perfil");
            System.out.println("5. Listar todos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero();
            switch (opcion) {
                case 1: altaTrabajador();     break;
                case 2: buscarPorNombre();    break;
                case 3: buscarPorDNI();       break;
                case 4: buscarPorTipo();      break;
                case 5: listarTrabajadores(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Da de alta un nuevo trabajador solicitando sus datos por consola.
     * Los nuevos empleados se incorporan siempre con experiencia cero,
     * por lo que operarios y mecánicos se crean en su perfil estándar.
     * El perfil eficiente se adquiere tras superar el umbral de experiencia
     * definido por el sistema (> 10 montajes para operarios, > 20 reparaciones
     * para mecánicos de cinta).
     */
    private static void altaTrabajador() {
        System.out.println("Tipo de trabajador:");
        System.out.println("  1. Operario");
        System.out.println("  2. GestorDePlanta");
        System.out.println("  3. AdministradorSistema");
        System.out.println("  4. MecanicoCinta");
        System.out.print("Tipo: ");
        int tipo = leerEntero();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Núm. Seguridad Social: ");
        String nss = scanner.nextLine();
        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
        System.out.print("Salario (€): ");
        double salario = leerDouble();
        Date fecha = new Date();

        Trabajador t = null;
        switch (tipo) {
            case 1: t = new OperarioEstandar(nombre, apellidos, dni, direccion, nss, puesto, salario, fecha);       break;
            case 2: t = new GestorDePlanta(nombre, apellidos, dni, direccion, nss, puesto, salario, fecha);         break;
            case 3: t = new AdministradorSistema(nombre, apellidos, dni, direccion, nss, puesto, salario, fecha);   break;
            case 4: t = new MecanicoCintaEstandar(nombre, apellidos, dni, direccion, nss, puesto, salario, fecha);  break;
            default: System.out.println("Tipo no válido."); return;
        }
        sistema.altaTrabajador(t);
        System.out.println("Trabajador dado de alta correctamente.");
    }

    /**
     * Busca trabajadores por nombre o apellidos e imprime los resultados.
     */
    private static void buscarPorNombre() {
        System.out.print("Nombre o apellidos: ");
        String texto = scanner.nextLine();
        ArrayList<Trabajador> resultado = sistema.buscarPorNombre(texto);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron trabajadores.");
        } else {
            for (Trabajador t : resultado) imprimirTrabajador(t);
        }
    }

    /**
     * Busca un trabajador por DNI e imprime el resultado.
     */
    private static void buscarPorDNI() {
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        Trabajador t = sistema.buscarPorDNI(dni);
        if (t == null) {
            System.out.println("No se encontró ningún trabajador con ese DNI.");
        } else {
            imprimirTrabajador(t);
        }
    }

    /**
     * Busca trabajadores por tipo de perfil e imprime los resultados.
     */
    private static void buscarPorTipo() {
        System.out.println("Tipos disponibles: OperarioEficiente, OperarioEstandar,");
        System.out.println("  GestorDePlanta, AdministradorSistema,");
        System.out.println("  MecanicoCintaEficiente, MecanicoCintaEstandar");
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        ArrayList<Trabajador> resultado = sistema.buscarPorTipo(tipo);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron trabajadores de ese tipo.");
        } else {
            for (Trabajador t : resultado) imprimirTrabajador(t);
        }
    }

    /**
     * Lista todos los trabajadores registrados en el sistema.
     */
    private static void listarTrabajadores() {
        ArrayList<Trabajador> todos = sistema.getTrabajadores();
        if (todos.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
        } else {
            System.out.println("\n--- LISTA DE TRABAJADORES ---");
            for (Trabajador t : todos) imprimirTrabajador(t);
        }
    }

    /**
     * Imprime los datos básicos de un trabajador.
     *
     * @param t Trabajador a mostrar.
     */
    private static void imprimirTrabajador(Trabajador t) {
        System.out.println("  [" + t.getClass().getSimpleName() + "] "
                + t.getNombre() + " " + t.getApellidos()
                + " — DNI: " + t.getDNI()
                + " — Puesto: " + t.getPuesto()
                + " — Salario: " + t.getSalario() + " €");
    }

    // -------------------------------------------------------------------------
    // Menú de almacén
    // -------------------------------------------------------------------------

    /**
     * Submenú de gestión del almacén.
     */
    private static void menuAlmacen() {
        int opcion;
        do {
            System.out.println("\n-- ALMACÉN --");
            System.out.println("1. Añadir motor");
            System.out.println("2. Añadir tapicería");
            System.out.println("3. Añadir rueda");
            System.out.println("4. Consultar stock");
            System.out.println("5. Restock para pruebas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero();
            switch (opcion) {
                case 1: añadirMotor();      break;
                case 2: añadirTapiceria();  break;
                case 3: añadirRueda();      break;
                case 4: consultarStock();   break;
                case 5: restockPruebas();   break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Solicita datos por consola y añade un motor al almacén.
     */
    private static void añadirMotor() {
        System.out.println("Tipo: 1. Eléctrico  2. Gasolina  3. Híbrido");
        System.out.print("Tipo: ");
        int tipo = leerEntero();
        System.out.print("Cilindrada (cc): ");
        double cilindrada = leerDouble();
        System.out.print("Potencia (CV): ");
        double potencia = leerDouble();
        System.out.print("Núm. cilindros: ");
        int cilindros = leerEntero();

        Motor motor = null;
        switch (tipo) {
            case 1: motor = new MotorElectrico(cilindrada, potencia, cilindros); break;
            case 2: motor = new MotorGasolina(cilindrada, potencia, cilindros);  break;
            case 3: motor = new MotorHibrido(cilindrada, potencia, cilindros);   break;
            default: System.out.println("Tipo no válido."); return;
        }
        sistema.getAlmacen().añadir(motor);
        System.out.println("Motor añadido al almacén.");
    }

    /**
     * Solicita datos por consola y añade una tapicería al almacén.
     */
    private static void añadirTapiceria() {
        System.out.println("Tipo: 1. Tela  2. Cuero  3. Alcántara");
        System.out.print("Tipo: ");
        int tipo = leerEntero();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Metros cuadrados: ");
        double metros = leerDouble();

        Tapiceria tap = null;
        switch (tipo) {
            case 1: tap = new TapiceriaTela(color, metros);      break;
            case 2: tap = new TapiceriaCuero(color, metros);     break;
            case 3: tap = new TapiceriaAlcantara(color, metros); break;
            default: System.out.println("Tipo no válido."); return;
        }
        sistema.getAlmacen().añadir(tap);
        System.out.println("Tapicería añadida al almacén.");
    }

    /**
     * Solicita datos por consola y añade una rueda al almacén.
     */
    private static void añadirRueda() {
        System.out.println("Tipo: 1. Normal  2. Deportivo  3. Todoterreno");
        System.out.print("Tipo: ");
        int tipo = leerEntero();
        System.out.print("Ancho (mm): ");
        double ancho = leerDouble();
        System.out.print("Diámetro llanta (pulgadas): ");
        double diametro = leerDouble();
        System.out.print("Índice de carga (kg): ");
        double indiceCarga = leerDouble();
        System.out.print("Código de velocidad (km/h): ");
        double codigoVelocidad = leerDouble();

        Rueda rueda = null;
        switch (tipo) {
            case 1: rueda = new RuedaNormal(ancho, diametro, indiceCarga, codigoVelocidad);       break;
            case 2: rueda = new RuedaDeportivo(ancho, diametro, indiceCarga, codigoVelocidad);    break;
            case 3: rueda = new RuedaTodoterreno(ancho, diametro, indiceCarga, codigoVelocidad);  break;
            default: System.out.println("Tipo no válido."); return;
        }
        sistema.getAlmacen().añadir(rueda);
        System.out.println("Rueda añadida al almacén.");
    }

    /**
     * Consulta e imprime el stock actual de todos los tipos de componentes y vehículos.
     */
    @SuppressWarnings("unchecked")
    private static void consultarStock() {
        IAlmacen almacen = sistema.getAlmacen();
        ArrayList<Motor> motores       = (ArrayList<Motor>)    almacen.consultar("motor");
        ArrayList<Tapiceria> tapicerias = (ArrayList<Tapiceria>) almacen.consultar("tapiceria");
        ArrayList<Rueda> ruedas        = (ArrayList<Rueda>)    almacen.consultar("rueda");
        ArrayList<Vehiculo> vehiculos  = (ArrayList<Vehiculo>) almacen.consultar("vehiculo");

        System.out.println("\n--- STOCK DEL ALMACÉN ---");
        System.out.println("Motores:    " + motores.size());
        System.out.println("Tapicerías: " + tapicerias.size());
        System.out.println("Ruedas:     " + ruedas.size());
        System.out.println("Vehículos:  " + vehiculos.size());
        if (!vehiculos.isEmpty()) {
            System.out.println("  Vehículos completados:");
            for (Vehiculo v : vehiculos) {
                System.out.println("    - " + v.getClass().getSimpleName()
                        + " (" + v.getColor() + ") — " + v.getEstado());
            }
        }
    }

    /**
     * Añade al almacén 3 motores, 3 tapicerías y 3 ruedas con valores por defecto
     * para facilitar las pruebas sin tener que introducir datos manualmente.
     */
    private static void restockPruebas() {
        IAlmacen almacen = sistema.getAlmacen();
        for (int i = 0; i < 3; i++) {
            almacen.añadir(new MotorGasolina(1600.0, 120.0, 4));
            almacen.añadir(new TapiceriaTela("gris", 4.5));
            almacen.añadir(new RuedaNormal(205.0, 16.0, 500.0, 210.0));
        }
        System.out.println("Restock completado: 3 motores, 3 tapicerías y 3 ruedas añadidos.");
    }

    // -------------------------------------------------------------------------
    // Utilidades de lectura
    // -------------------------------------------------------------------------

    /**
     * Lee un entero de la consola. Si la entrada no es válida devuelve -1.
     *
     * @return Entero leído, o -1 si la entrada no es un número entero.
     */
    private static int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lee un número decimal de la consola. Si la entrada no es válida devuelve 0.
     *
     * @return Double leído, o 0 si la entrada no es un número válido.
     */
    private static double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
