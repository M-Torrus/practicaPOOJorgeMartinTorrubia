# Enunciado — Fábrica de Vehículos (POO, UNED 2025-2026)

## Descripción general

Sistema de gestión de una fábrica de vehículos con dos unidades operativas: **cadenas de montaje** y **sistema de gestión**. El sistema simula la construcción de vehículos paso a paso mediante un planificador que actúa como reloj (1 acción por segundo).

## Entidades del sistema

### Vehículos

- `Vehiculo` (abstracta): color, numPlazas, tara, pesoMaxAutorizado, estado (EstadoVehiculo), motor, tapiceria, ruedas.
  - `BiplazaDeportivo`: plazas fijas = 2.
  - `Turismo`
  - `Furgoneta`
- `EstadoVehiculo` (enum): CHASIS, MOTOR, TAPICERIA, RUEDAS.
- Cada vehículo **tiene** un Motor, una Tapicería y Ruedas (composición).
- Cada tipo de vehículo tiene su propia cadena de montaje (3 cadenas en total).

### Motores

- `Motor` (abstracta): cilindrada, potencia, numCilindros.
  - `MotorElectrico`
  - `MotorGasolina`
  - `MotorHibrido`

### Tapicería

- `Tapiceria` (abstracta): color, metrosCuadrados.
  - `Tela`
  - `Cuero`
  - `Alcantara`

### Ruedas

- `Rueda` (abstracta): anchoMM, diametroLlanta, indiceCarga, codigoVelocidad.
  - `RuedaNormal`
  - `RuedaDeportiva`
  - `RuedaTodoterreno`

### Trabajadores

- `Trabajador` (abstracta): nombre, apellidos, dni, direccion, numSeguridadSocial, puesto, salario, fechaIngreso (Date).
  - `Operario` (abstracta): montajesRealizados, realizarTarea().
    - `OperarioEficiente`: >10 montajes → tarea en 1 segundo.
    - `OperarioEstandar`: ≤10 montajes → tarea en 3 segundos.
  - `GestorPlanta`: configurarCadena().
  - `AdminSistema`: restaurarSistema() → 2s para gestión + 3s para cadenas.
  - `MecanicoCinta` (abstracta): reparacionesRealizadas, repararCinta().
    - `MecanicoEficiente`: >20 reparaciones → repara en 1 segundo.
    - `MecanicoEstandar`: ≤20 reparaciones → repara en 2-5 segundos.

### Sistema de gestión

- `factory_main`: punto de entrada de la aplicación. Crea SistemaGestion.
- `SistemaGestion`: contiene cadenas[3], almacén (IAlmacen), dashboard, planificador, trabajadores[].
- `CadenaMontaje`: tipoVehiculo, robots[4], operarios[4], vehiculoEnConstruccion, estado.
- `Robot`: componente (String), operario (Operario), montarComponente(). Un robot por componente: chasis, motor, tapicería, ruedas.
- `IAlmacen` (interfaz): añadir(), consultar(), actualizar(). Desacopla el almacén del sistema.
- `Almacen` (implementa IAlmacen): motores[], tapicerias[], ruedas[], vehiculos[].
- `Dashboard`: visualizador (IVisualizacion), mostrarEstadoCadenas(), mostrarEstadoAlmacen(), actualizarVista().
- `IVisualizacion` (interfaz): mostrar(), actualizar(). Desacopla el dashboard de la vista.
- `VistaTextual` (implementa IVisualizacion).
- `Planificador`: controla las 3 cadenas. simulacionSimple(), simulacionCompleja(), simulacionMuyCompleja().

## Relaciones clave

- SistemaGestion usa `IAlmacen` (no Almacen directamente) → desacoplamiento.
- Dashboard usa `IVisualizacion` (no VistaTextual directamente) → desacoplamiento.
- factory_main crea SistemaGestion.
- SistemaGestion tiene 3 CadenaMontaje.
- Cada CadenaMontaje tiene 4 Robot.
- Planificador controla las 3 CadenaMontaje.
- Dashboard monitoriza CadenaMontaje y Almacen.

---

## Nivel 1 — Diseño de clases (hasta 3 puntos)

### Objetivo

Definir todas las clases, jerarquías de herencia, interfaces y relaciones entre ellas.

### Requisitos

1. Crear todas las clases listadas en "Entidades del sistema" con sus atributos.
2. Establecer las relaciones de herencia (extends), implementación (implements) y composición.
3. Definir constructores y métodos públicos como esqueletos (sin implementar, con returns placeholder).
4. Usar correctamente: abstracción, encapsulamiento, herencia y polimorfismo.
5. Comentarios Javadoc en todas las clases y métodos públicos.

### Criterio de completitud

Todas las clases compilables en BlueJ, con atributos correctos, jerarquías de herencia bien definidas e interfaces creadas.

---

## Nivel 2 — Gestión de datos (hasta 7 puntos)

> [!important] Requisito previo
> Nivel 1 completamente implementado.

### Objetivo

Dar funcionalidad real a las clases: gestión de almacén, trabajadores y simulación simple.

### Requisitos

1. **Gestión de almacén:**
   - Añadir motores, tapicerías, ruedas y vehículos al almacén.
   - Consultar el stock de cualquier componente o vehículo.
   - Actualizar datos de componentes y vehículos existentes.

2. **Gestión de trabajadores:**
   - Dar de alta los distintos tipos de empleados con todos sus datos personales.
   - Almacenarlos en el sistema.

3. **Simulación Simple del planificador:**
   - No se producen problemas en las cintas.
   - Selección aleatoria de operarios para cada cadena.
   - El planificador avanza segundo a segundo:
     - Segundo 1: robots de chasis montan chasis en las 3 cadenas.
     - Segundo 2: robots de motor montan motores.
     - Segundo 3: robots de tapicería montan tapicerías.
     - Segundo 4: robots de ruedas montan ruedas.
   - Tener en cuenta los tiempos de cada operario (eficiente = 1s, estándar = 3s).
   - Cada vez que un robot termina, se cambia el estado del vehículo (EstadoVehiculo).
   - Al terminar, el vehículo se almacena en el almacén.

4. **Búsquedas de empleados:**
   - Buscar trabajadores por nombre, DNI, tipo de perfil, etc.

5. **Consultas de stock:**
   - Consultar y actualizar el stock de vehículos y componentes del sistema.

### Criterio de completitud

Se pueden dar de alta trabajadores y componentes, ejecutar una simulación simple completa, y consultar datos del sistema.

---

## Nivel 3 — Interfaz textual y funcionalidad completa (hasta 10 puntos)

> [!important] Requisito previo
> Niveles 1 y 2 completamente implementados.

### Objetivo

Sistema completo con menú textual, todas las simulaciones y listados estadísticos.

### Requisitos

1. **Interfaz textual:**
   - Menú por consola que permita acceder a todas las funcionalidades.
   - El gestor de planta configura las cadenas, selecciona componentes, indica unidades.
   - El sistema comprueba que hay piezas suficientes antes de iniciar.

2. **Simulación Compleja:**
   - Entran en juego los mecánicos.
   - Al menos 1 mecánico de cada perfil (eficiente y estándar) debe reparar al menos 2 problemas en cada cinta.

3. **Simulación Muy Compleja:**
   - Entran en juego operarios, mecánicos estándar y administrador del sistema.
   - De 2 a 3 problemas por cadena para reparar.
   - Al menos 1 caída de luz que resuelve el AdminSistema (2s gestión + 3s cadenas = todos parados hasta que restaure).

4. **Dashboard completo:**
   - Mostrar en cada segundo de simulación el estado de las cadenas y del almacén.
   - Cada vez que se ensambla un componente, el dashboard se actualiza.
   - Diseño desacoplado mediante IVisualizacion.

5. **Almacén completo:**
   - Almacenar todas las entidades del sistema e información de cadenas de montaje.
   - Todo el proceso de montaje almacenado y consultable por fecha a nivel de componente.
   - Diseño desacoplado mediante IAlmacen.

6. **Listados y estadísticas:**
   - Listado de operarios con filtrado por productividad y ordenación alfabética.
   - Listado de vehículos ensamblados con filtrado por componentes y ordenación alfabética.
   - Listado de configuraciones de vehículos con mayor tasa de ensamblaje.
   - Listado de cadenas de montaje filtrado por fecha, mostrando vehículos producidos con sus componentes.

### Criterio de completitud

Todas las funcionalidades accesibles desde el menú textual, las tres simulaciones funcionando correctamente, dashboard actualizado en tiempo real, y todos los listados operativos.
