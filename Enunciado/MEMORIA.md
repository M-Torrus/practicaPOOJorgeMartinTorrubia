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

[Describir cada funcionalidad: gestión de almacén, alta de trabajadores, simulación simple, búsquedas, consultas de stock]

### Clases modificadas

[Listar las clases que se modificaron y qué se añadió]

### Métodos públicos principales

[Para cada clase modificada, listar sus métodos públicos y qué hacen]

### Decisiones de diseño

[Justificar las decisiones: estructura de datos elegida para el almacén, cómo funciona el planificador, cómo se seleccionan los operarios aleatoriamente, etc.]

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
