# Instrucciones de trabajo — Fábrica de Vehículos (POO, UNED 2025-2026)

## Contexto del proyecto

Práctica obligatoria de **Programación Orientada a Objetos** (UNED, curso 2025-2026). Fábrica de vehículos simulada en Java. El enunciado completo está en `ENUNCIADO.md`.

## Restricciones del entorno

- **Entorno:** BlueJ. No usar características de IDEs avanzados (Maven, Gradle, módulos).
- **Lenguaje:** Java SE estándar. Sin dependencias externas ni librerías de terceros.
- **Clase principal:** `factory_main` con método `public static void main(String[] args)`.
- **Idioma del código:** nombres de clases, atributos, métodos y comentarios en **español**, salvo términos técnicos universales (get, set, extends, implements, etc.).
- **Estructura de archivos:** cada clase pública en su propio archivo `.java`, todo en el mismo directorio (estructura plana, sin paquetes — BlueJ por defecto).

## Estilo de código

### Comentarios Javadoc

Todas las clases deben tener un comentario Javadoc al inicio:

```java
/**
 * Descripción breve de qué representa esta clase y para qué sirve.
 *
 * @author [nombre del alumno]
 * @version 1.0
 */
```

Todos los métodos públicos deben tener Javadoc:

```java
/**
 * Descripción breve de qué hace este método.
 *
 * @param nombreParam Descripción del parámetro.
 * @return Descripción de lo que retorna (si aplica).
 */
```

### Comentarios inline

- Solo donde la lógica no sea obvia.
- No comentar lo evidente (`i++ // incrementa i` → NO).
- Usar `//` para comentarios de una línea dentro de métodos.

### Convenciones de nombres

- Clases: PascalCase (`CadenaMontaje`, `OperarioEficiente`).
- Métodos y variables: camelCase (`montajesRealizados`, `añadirMotor()`).
- Constantes: UPPER_SNAKE_CASE.
- Enum: PascalCase para el tipo, UPPER_SNAKE_CASE para los valores (`EstadoVehiculo.CHASIS`).

### Encapsulamiento

- Atributos siempre `private`.
- Acceso mediante getters y setters cuando sea necesario.
- Métodos internos como `private` o `protected` según corresponda.

## Flujo de trabajo por niveles

> **REGLA CRÍTICA:** Los niveles son secuenciales y acumulativos. NO avanzar al siguiente nivel sin haber completado totalmente el anterior. Ante la duda, preguntar antes de continuar.

### Proceso para cada nivel

1. **Leer** los requisitos del nivel en `ENUNCIADO.md`.
2. **Implementar** todas las funcionalidades del nivel.
3. **Verificar** que compila y funciona correctamente.
4. **Comentar** todas las clases y métodos nuevos o modificados con Javadoc.
5. **Actualizar `MEMORIA.md`** con la sección correspondiente al nivel completado.
6. **Confirmar** al usuario que el nivel está completo y esperar aprobación antes de continuar.

### Qué incluir en MEMORIA.md al completar cada nivel

Para cada nivel completado, añadir a la sección correspondiente de `MEMORIA.md`:

- **Clases implementadas/modificadas:** listado con descripción breve de cada una.
- **Métodos públicos principales:** qué hace cada uno.
- **Decisiones de diseño:** por qué se hizo así y no de otra forma. Justificaciones.
- **Relaciones entre clases:** herencia, composición, uso de interfaces, y por qué.
- **Dificultades o consideraciones:** cualquier aspecto relevante.

El tono debe ser técnico pero claro, como si explicases tu trabajo a un profesor.

## Restricciones de implementación

- No usar herencia múltiple (Java no lo permite). Usar interfaces cuando haga falta.
- Mantener el desacoplamiento: SistemaGestion trabaja con `IAlmacen`, no con `Almacen`. Dashboard trabaja con `IVisualizacion`, no con `VistaTextual`.
- No modificar la estructura de clases ya existente sin motivo justificado. Si hay que cambiar algo, explicar por qué.
- Los métodos marcados con `// TODO: Nivel X` solo se implementan al llegar a ese nivel.
- No añadir clases que no estén contempladas en `ENUNCIADO.md` sin consultar primero.

## Archivos del proyecto

- `ENUNCIADO.md` → Enunciado desglosado por niveles (referencia, no modificar).
- `MEMORIA.md` → Memoria de la práctica (actualizar al completar cada nivel).
- `INSTRUCCIONES.md` → Este archivo (instrucciones de trabajo, no modificar).
- `*.java` → Código fuente del proyecto.
