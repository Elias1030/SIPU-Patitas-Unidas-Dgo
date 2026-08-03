# SIPU – Patitas Unidas Dgo

Sistema web para gestionar adopciones, expedientes de animales, salud, gastos, donativos, voluntariado y transparencia de Patitas Unidas Dgo.

## Propósito

SIPU busca reducir la dispersión de información y mejorar el seguimiento de los animales rescatados. La solución permitirá publicar animales disponibles, gestionar solicitudes de adopción, conservar expedientes, registrar atenciones médicas y gastos, coordinar voluntariado y comunicar el uso de los apoyos recibidos.

## Tecnología inicial

- Java 17
- Jakarta Servlets y JSP
- Maven
- JUnit 5
- Base de datos relacional (planeada)
- Apache Tomcat (planeado)
- Travis CI

## Etapas

- **Beta:** construcción, integración y validación de los módulos.
- **General Availability (GA):** versión estable aprobada para liberación.

## Estrategia de ramas

- `develop`: integración del código Beta.
- `master`: código final de GA.
- `feature/<tarea>`: desarrollo individual de cada requerimiento mediante pull request hacia `develop`.

## Alcance futuro

La primera versión no procesará pagos, no publicará automáticamente en Facebook, no tendrá aplicación móvil nativa, geolocalización en tiempo real ni avisos automáticos por mensajería.

Consulta [la arquitectura](docs/ARQUITECTURA.md) para conocer los componentes previstos.
