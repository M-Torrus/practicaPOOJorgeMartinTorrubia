# Memoria — Práctica de Programación Orientada a Objetos (2025-2026)

## Portada

- **Título:** Práctica de Programación Orientada a Objetos – Curso 2025-2026
- **Nombre:** [Tu nombre]
- **Apellidos:** [Tus apellidos]
- **Correo electrónico:** [Tu email]
- **Teléfono:** [Tu teléfono]

---

## Análisis de la aplicación

### Descripción general

[Describir brevemente qué hace la aplicación: un sistema de gestión de fábrica de vehículos que simula cadenas de montaje, gestiona almacén, trabajadores y muestra el estado del sistema mediante un dashboard.]

### Actores del sistema

[Describir los actores: GestorPlanta (configura y monitoriza), Operarios (controlan robots), Mecánicos (reparan cintas), AdminSistema (restaura el sistema).]

### Estrategias implementadas

[Describir las estrategias generales: desacoplamiento mediante interfaces, herencia para jerarquías de entidades, composición para vehículos, etc.]

---

## Diagrama de clases

[Incluir el diagrama de clases. Puede ser una captura del diagrama de BlueJ o una descripción textual detallada de las relaciones.]

### Tipos de relaciones

- **Herencia (extends):** [Listar las relaciones de herencia]
- **Implementación (implements):** [Listar qué clases implementan qué interfaces]
- **Composición:** [Listar las relaciones de composición, ej: Vehiculo tiene Motor, Tapiceria, Rueda]
- **Uso/Asociación:** [Listar otras relaciones, ej: SistemaGestion usa IAlmacen]

---

## Nivel 1 — Diseño de clases

### Clases implementadas

[Listar cada clase con una descripción breve de su propósito]

### Decisiones de diseño

[Explicar y justificar las decisiones tomadas: por qué estas jerarquías, por qué interfaces para almacén y visualización, por qué un enum para EstadoVehiculo, etc.]

---

## Nivel 2 — Gestión de datos

### Funcionalidades implementadas

1. **Gestión de almacén:** El almacén permite añadir motores, tapicerías, ruedas y vehículos, consultar el stock por tipo y actualizar elementos existentes. Cada tipo de componente se almacena en su propia `ArrayList`.

2. **Alta de trabajadores:** Desde el menú de la aplicación se pueden registrar los seis tipos de trabajadores (OperarioEficiente, OperarioEstandar, GestorDePlanta, AdministradorSistema, MecanicoCintaEficiente, MecanicoCintaEstandar) con todos sus datos personales y laborales.

3. **Búsquedas de trabajadores:** Búsqueda por nombre/apellidos (búsqueda parcial sin distinción de mayúsculas), por DNI exacto y por tipo de perfil.

4. **Consulta de stock:** El menú permite consultar el número de unidades disponibles de cada tipo de componente y listar los vehículos completados con su color y estado.

5. **Simulación simple:** El planificador lanza un hilo independiente por cada cadena de montaje. Cada hilo asigna un operario aleatorio (eficiente o estándar) a cada uno de los 4 robots, monta los componentes en orden (chasis → motor → tapicería → ruedas), actualiza el `EstadoVehiculo` tras cada paso y almacena el vehículo terminado en el almacén.

### Clases modificadas

| Clase | Cambios |
|---|---|
| `Almacen` | Implementados `añadir()`, `consultar()` y `actualizar()` |
| `Robot` | Implementado `montarComponente()` |
| `Planificador` | Añadido campo `IAlmacen almacen`; implementado `simulacionSimple()` con métodos privados auxiliares `crearVehiculo()` y `crearOperarioAleatorio()` |
| `SistemaGestion` | Constructor actualizado para pasar `almacen` al `Planificador`; añadidos `altaTrabajador()`, `buscarPorNombre()`, `buscarPorDNI()` y `buscarPorTipo()` |
| `factory_main` | Menú interactivo completo con `Scanner` |

### Métodos públicos principales

**`Almacen`**
- `añadir(Object elemento)` — detecta el tipo con `instanceof` y lo añade a la lista correspondiente.
- `consultar(String tipo)` — devuelve la `ArrayList` del tipo indicado (`"motor"`, `"tapiceria"`, `"rueda"`, `"vehiculo"`).
- `actualizar(Object elemento)` — localiza el elemento por referencia (`indexOf`) y lo reemplaza en su lista.

**`Robot`**
- `montarComponente()` — llama a `operario.realizarTarea()` para obtener el tiempo de montaje y bloquea el hilo el tiempo correspondiente con `Thread.sleep()`.

**`Planificador`**
- `simulacionSimple()` — comprueba stock, lanza un `Thread` por cadena, cada uno monta los 4 componentes en orden actualizando el estado del vehículo, y almacena el vehículo al terminar. Espera a que todos los hilos finalicen con `join()`.

**`SistemaGestion`**
- `altaTrabajador(Trabajador t)` — añade el trabajador a la lista.
- `buscarPorNombre(String nombre)` — búsqueda parcial case-insensitive en nombre y apellidos.
- `buscarPorDNI(String dni)` — búsqueda exacta por DNI.
- `buscarPorTipo(String tipo)` — filtra por nombre simple de la clase (`getClass().getSimpleName()`).

### Decisiones de diseño

- **`ArrayList` para el almacén:** Estructura sencilla, dinámica y directamente compatible con la interfaz `IAlmacen`. No se necesita ordenación ni acceso por clave en este nivel.
- **`instanceof` en `añadir`/`actualizar`:** Permite mantener la firma genérica `Object` exigida por `IAlmacen` sin romper el tipado en cada lista interna.
- **Un hilo por cadena en `simulacionSimple()`:** Refleja fielmente que las cadenas son independientes y no avanzan al unísono cuando los operarios son de distinto tipo (OperarioEficiente tarda 1 s por componente, OperarioEstandar tarda 3 s).
- **Operarios aleatorios generados internamente:** El planificador crea instancias anónimas de `OperarioEficiente` u `OperarioEstandar` con `Math.random()`, sin depender de la lista de trabajadores registrados, como indica el enunciado para la simulación simple.
- **`scanner.nextLine()` para toda la entrada:** Evita el clásico problema del salto de línea residual al mezclar `nextInt()` con `nextLine()`, haciendo el menú más robusto.

---

## Nivel 3 — Interfaz textual y funcionalidad completa

### Funcionalidades implementadas

[Describir: menú textual, simulaciones compleja y muy compleja, dashboard, listados]

### Clases modificadas

[Listar las clases que se modificaron y qué se añadió]

### Métodos públicos principales

[Para cada clase modificada, listar sus métodos públicos y qué hacen]

### Decisiones de diseño

[Justificar las decisiones: diseño del menú, cómo se generan los problemas en simulaciones, cómo se implementaron los listados con filtrado y ordenación, etc.]

---

## Descripción de clases

[Para cada clase del proyecto, incluir: nombre, propósito, atributos principales, métodos públicos con descripción de su funcionalidad. Organizar por grupos: Vehículos, Motores, Tapicería, Ruedas, Trabajadores, Sistema de gestión.]

---

## Anexo — Código fuente

[El código fuente completo de todas las clases se incluye en la carpeta adjunta del proyecto.]
