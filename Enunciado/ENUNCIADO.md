# Enunciado — Fábrica de Vehículos (POO, UNED 2025-2026)

> **Nota sobre nombres:** Este documento es una adaptación del PDF original de la práctica generada con IA. Los nombres de clases, atributos y métodos que aparecen aquí son **orientativos**. El PDF original no impone nombres concretos. Los nombres elegidos en el código del proyecto son válidos siempre que sean coherentes, descriptivos y sigan las convenciones de estilo indicadas en `INSTRUCCIONES.md`.

## Descripción general

Sistema de gestión de una fábrica de vehículos con dos unidades operativas: **cadenas de montaje** y **sistema de gestión**. El sistema simula la construcción de vehículos paso a paso mediante un planificador que actúa como reloj (1 acción por segundo).

## Entidades del sistema

### Vehículos

- `Vehiculo` (abstracta): color (String), numPlazas (int), tara (double), pesoMaxAutorizado (double), estado (EstadoVehiculo), motor (Motor), tapiceria (Tapiceria), ruedas (Rueda).
  - `BiplazaDeportivo`: plazas fijas = 2.
  - `Turismo`
  - `Furgoneta`
- `EstadoVehiculo` (enum): CHASIS, MOTOR, TAPICERIA, RUEDAS.
- Cada vehículo **tiene** un Motor, una Tapicería y Ruedas (composición).
- Cada tipo de vehículo tiene su propia cadena de montaje (3 cadenas en total).

### Motores

- `Motor` (abstracta): cilindrada (double), potencia (double), numCilindros (int).
  - `MotorElectrico`
  - `MotorGasolina`
  - `MotorHibrido`

### Tapicería

- `Tapiceria` (abstracta): color (String), metrosCuadrados (double — metros cuadrados de tela/cuero/alcántara utilizados).
  - `Tela`
  - `Cuero`
  - `Alcantara`

### Ruedas

- `Rueda` (abstracta): anchoMM (int, en milímetros), diametroLlanta (double, en pulgadas), indiceCarga (int, en kg), codigoVelocidad (int, en km/h — velocidad máxima que el neumático soporta con seguridad durante un periodo determinado).
  - `RuedaNormal`
  - `RuedaDeportiva`
  - `RuedaTodoterreno`

### Trabajadores

- `Trabajador` (abstracta): nombre (String), apellidos (String), dni (String), direccion (String), numSeguridadSocial (String), puesto (String), salario (double), fechaIngreso (Date).
  - `Operario` (abstracta): montajesRealizados, realizarTarea(). La labor del operario es controlar el robot que monta el componente. En cada cadena hay un robot por componente y un operario por robot. Cada vez que un robot termina, se cambia el estado del vehículo.
    - `OperarioEficiente`: >10 montajes → tarea en 1 segundo.
    - `OperarioEstandar`: ≤10 montajes → tarea en 3 segundos (el triple que un eficiente).
    - **Nota:** Si hay distintos tipos de operarios en las cadenas, hay que considerar los tiempos individuales de cada operario para los ensamblajes. Las cadenas no avanzan al unísono si los operarios son de distinto tipo.
  - `GestorPlanta`: configurarCadena(). Se encarga de monitorizar la planta, configurar los componentes que utilizarán las cadenas de montaje, estar pendiente del dashboard para comprobar errores y llamar a los mecánicos de cinta cuando se produce una avería.
  - `AdminSistema`: restaurarSistema(). Vela por el correcto funcionamiento del software (cadenas de montaje y gestor de fábrica). Cuando se produce un error (ej: apagón), **todos los trabajadores permanecen quietos** en su puesto hasta que el admin restaure el sistema: 2s para reanudar el sistema de gestión + 3s para reanudar las cadenas de montaje.
  - `MecanicoCinta` (abstracta): reparacionesRealizadas, repararCinta(). Ambos perfiles se dedican a reparar la cinta cuando se produce un problema. Es el gestor de planta quien les avisa para que intervengan.
    - `MecanicoEficiente`: >20 reparaciones → repara en 1 segundo.
    - `MecanicoEstandar`: ≤20 reparaciones → repara en 2-5 segundos (aleatorio).

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

## Flujo de funcionamiento de la factoría

1. El **gestor de planta** configura mediante la aplicación los 3 tipos de vehículos que quiere construir.
2. Selecciona los **componentes** para cada vehículo (motor, tapicería, ruedas).
3. Introduce las **unidades** a fabricar.
4. El sistema **comprueba** que hay piezas suficientes en el almacén para realizar el pedido.
5. Las cadenas de montaje se ponen a **construir** las unidades demandadas.
6. El **planificador** avanza segundo a segundo, ejecutando una acción por cadena en cada segundo, siempre y cuando no se produzca ningún evento externo que lo retrase (averías, caídas de luz).
7. En cada paso, el **dashboard** muestra el estado actualizado de las cadenas y el almacén.
8. Los vehículos terminados se almacenan en el **almacén**.

---

## Nivel 1 — Diseño de clases (hasta 3 puntos)

### Objetivo

Definir todas las clases, jerarquías de herencia, interfaces y relaciones entre ellas.

### Requisitos

1. **Planteamiento del problema:** identificar actores participantes, relaciones entre actores y funcionalidad a cumplir.
2. Crear todas las clases listadas en "Entidades del sistema" con sus atributos y tipos de datos.
3. Establecer las relaciones de herencia (extends), implementación (implements) y composición.
4. Definir constructores y métodos públicos como esqueletos (sin implementar, con returns placeholder).
5. Usar correctamente las herramientas del paradigma POO: abstracción, encapsulamiento, herencia y polimorfismo.
6. Comentarios Javadoc en todas las clases y métodos públicos.
7. Elaborar la memoria correspondiente a este nivel.

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
   - Tener en cuenta los tiempos de cada operario (eficiente = 1s, estándar = 3s). Si hay mezcla de tipos, cada cadena avanza a su propio ritmo.
   - Cada vez que un robot termina, se cambia el estado del vehículo (EstadoVehiculo) y se aplican las modificaciones correspondientes en el estado del vehículo, la cadena de montaje y el almacén de piezas.
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

2. **Implementación completa del planificador y cadenas de montaje.**

3. **Simulación Compleja:**
   - Entran en juego los mecánicos.
   - Al menos 1 mecánico de cada perfil (eficiente y estándar) debe reparar al menos 2 problemas en cada cinta.

4. **Simulación Muy Compleja:**
   - Entran en juego operarios, mecánicos estándar y administrador del sistema.
   - De 2 a 3 problemas por cadena para reparar.
   - Al menos 1 caída de luz que resuelve el AdminSistema (2s gestión + 3s cadenas = todos los trabajadores permanecen quietos hasta que restaure).

5. **Dashboard completo:**
   - Mostrar en cada segundo de simulación el estado de las cadenas y del almacén.
   - Cada vez que se ensambla un componente, el dashboard muestra la modificación y la situación actual.
   - El cuadro de mandos es la herramienta del gestor de planta para consultar el estado.
   - Diseño desacoplado mediante IVisualizacion para permitir cambio de subsistema de visualización en el futuro.

6. **Almacén completo:**
   - Almacenar todas las entidades del sistema e información de cadenas de montaje.
   - Todo el proceso de montaje debe ser almacenado de manera que pueda ser consultado por fecha a nivel de componente.
   - Diseño desacoplado mediante IAlmacen para facilitar cambio de estructura de datos sin modificaciones severas en el diseño original.

7. **Listados y estadísticas:**
   - Listado de operarios con filtrado por productividad y ordenación alfabética.
   - Listado de vehículos ensamblados con filtrado por componentes y ordenación alfabética.
   - Listado de configuraciones de vehículos con mayor tasa de ensamblaje.
   - Listado de cadenas de montaje filtrado por fecha, mostrando vehículos producidos con sus componentes.

### Criterio de completitud

Todas las funcionalidades accesibles desde el menú textual, las tres simulaciones funcionando correctamente, dashboard actualizado en tiempo real, y todos los listados operativos.
