# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Proyecto

Práctica obligatoria de **Programación Orientada a Objetos** (UNED, curso 2025-2026). Simulación de una fábrica de vehículos en Java. Enunciado completo en `Enunciado/ENUNCIADO.md`. Instrucciones de trabajo en `Enunciado/INSTRUCCIONES.md`.

> Los nombres de clases y atributos del enunciado son orientativos (el PDF original no los impone). Los nombres usados en el código son los válidos.

## Entorno y restricciones

- **IDE:** BlueJ. Estructura plana: **todos los `.java` en el mismo directorio**, sin paquetes.
- **Java SE estándar.** Sin Maven, Gradle ni dependencias externas.
- **No compilar desde terminal.** BlueJ compila directamente. No hay comando de build ni tests automatizados.
- **Idioma del código:** español (nombres de clases, atributos, métodos, comentarios), salvo términos técnicos universales (`get`, `set`, `extends`, etc.).

## Convenciones de código

- Clases: PascalCase. Métodos y variables: camelCase. Constantes: UPPER_SNAKE_CASE.
- Atributos siempre `private`, acceso mediante getters/setters.
- Javadoc obligatorio en todas las clases y métodos públicos: `@author Jorge Martín Torrubia`, `@version 1.0`, `@param`, `@return`.
- Comentarios inline solo donde la lógica no sea obvia.

## Flujo de trabajo por niveles

Los niveles son **secuenciales y acumulativos**. No avanzar al siguiente sin completar el anterior y esperar aprobación explícita del usuario.

1. Implementar todas las funcionalidades del nivel.
2. Verificar que compila en BlueJ.
3. Añadir/actualizar Javadoc.
4. Actualizar `Enunciado/MEMORIA.md` con la sección del nivel completado.
5. Confirmar al usuario y esperar su aprobación antes de continuar.

**Solo implementar lo que el enunciado pide explícitamente para el nivel actual.** No añadir lógica, interpretar requisitos ni adelantar funcionalidades de niveles posteriores sin consultar.

## Arquitectura del sistema

### Jerarquías de herencia (nombres en el código)

- `Vehiculo` (abstracta) → `BiplazaDeportivo`, `Turismo`, `Furgoneta`
- `Motor` (abstracta) → `MotorElectrico`, `MotorGasolina`, `MotorHibrido`
- `Tapiceria` (abstracta) → `TapiceriaTela`, `TapiceriaCuero`, `TapiceriaAlcantara`
- `Rueda` (abstracta) → `RuedaNormal`, `RuedaDeportivo`, `RuedaTodoterreno`
- `Trabajador` (abstracta) → `Operario` (abstracta) → `OperarioEficiente`, `OperarioEstandar`
- `Trabajador` → `GestorDePlanta`, `AdministradorSistema`
- `Trabajador` → `MecanicoCinta` (abstracta) → `MecanicoCintaEficiente`, `MecanicoCintaEstandar`

### Atributos clave

**Vehiculo:** `color`, `numPlazas`, `tara`, `pesoMaxAutorizado`, `estado` (EstadoVehiculo), `motor`, `tapiceria`, `ruedas` — los tres últimos `null` hasta ser ensamblados.

**Trabajador:** `nombre`, `apellidos`, `DNI`, `direccion`, `numSeguridadSocial`, `puesto`, `salario`, `fechaIngreso` (`java.util.Date` — requiere `import java.util.Date` en Trabajador y todas sus subclases).

**Operario:** `montajesRealizados`, `realizarTarea()` → `int`. `OperarioEficiente` → 1s; `OperarioEstandar` → 3s. Las cadenas **no avanzan al unísono** si hay mezcla de tipos.

**MecanicoCinta:** `reparacionesRealizadas`, `repararCinta()` → `int`. `MecanicoCintaEficiente` → 1s; `MecanicoCintaEstandar` → 2-5s aleatorio (`Math.random()`).

**GestorDePlanta:** `configurarCadena(CadenaMontaje)`. Monitoriza planta, configura componentes, avisa mecánicos ante averías.

**AdministradorSistema:** `restaurarSistema()`. Ante un apagón, **todos los trabajadores permanecen quietos** hasta restaurar: 2s sistema de gestión + 3s cadenas.

### Interfaces y desacoplamiento clave

- `IAlmacen` ← `Almacen`: `SistemaGestion` trabaja con `IAlmacen`, nunca con `Almacen` directamente.
- `IVisualizacion` ← `VistaTextual`: `Dashboard` trabaja con `IVisualizacion`, nunca con `VistaTextual` directamente.

### Sistema de gestión

`factory_main` → crea `SistemaGestion`, que contiene:
- `CadenaMontaje[3]` (una por tipo de vehículo): cada una tiene `Robot[4]` y `Operario[4]`
- `IAlmacen` (implementado por `Almacen`: ArrayLists de motores, tapicerías, ruedas, vehículos)
- `Dashboard` (usa `IVisualizacion`; muestra estado en cada segundo de simulación)
- `Planificador` (controla las 3 cadenas, tiene 3 modos de simulación)
- `ArrayList<Trabajador>`

`Robot`: `componente` (String), `operario` (Operario), `montarComponente()`. Un robot por componente: chasis, motor, tapicería, ruedas.

`EstadoVehiculo` (enum): CHASIS → MOTOR → TAPICERIA → RUEDAS.

## Estado de implementación

**Nivel 1 — Completado.** Todas las clases con atributos, constructores, getters/setters y Javadoc.

**Nivel 2 — Pendiente.** Métodos con `// TODO: Nivel 2`:
- `Almacen.añadir()`, `Almacen.consultar()`, `Almacen.actualizar()`
- `Robot.montarComponente()`
- `Planificador.simulacionSimple()`
- Menú básico en `factory_main`

**Nivel 3 — Pendiente.** Métodos con `// TODO: Nivel 3`:
- `VistaTextual.mostrar()`, `VistaTextual.actualizar()`
- `Dashboard.mostrarEstadoCadenas()`, `Dashboard.mostrarEstadoAlmacen()`
- `GestorDePlanta.configurarCadena()`, `AdministradorSistema.restaurarSistema()`
- `Planificador.simulacionCompleja()`, `Planificador.simulacionMuyCompleja()`
- Menú textual completo en `factory_main`

## Archivos de referencia

- `Enunciado/ENUNCIADO.md` — Requisitos por nivel (no modificar).
- `Enunciado/INSTRUCCIONES.md` — Reglas de trabajo (no modificar).
- `Enunciado/MEMORIA.md` — Memoria de la práctica (actualizar al completar cada nivel).
