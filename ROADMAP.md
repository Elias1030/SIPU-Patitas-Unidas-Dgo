# Roadmap de SIPU

## Estado actual

La iteración demostrativa permite registrar expedientes básicos, consultar
animales y controlar transiciones de estado. Maven genera el WAR y JUnit/Travis
CI validan reglas iniciales.

## Etapa Beta

### Base técnica

- [x] Repositorio y ramas principales.
- [x] Tablero, issues, etiquetas y milestones.
- [x] Proyecto Maven WAR.
- [x] Pruebas JUnit e integración Travis CI.
- [x] Prototipo funcional de expedientes.
- [ ] Modelo relacional y PostgreSQL.
- [ ] Persistencia JDBC y migraciones.
- [ ] Autenticación, sesiones y roles.
- [ ] Bitácora de cambios.

### Funcionalidad prioritaria

- [ ] Fotografías y expediente completo.
- [ ] Historial de salud, tratamientos y gastos.
- [ ] Catálogo público de adopción.
- [ ] Solicitudes y evaluación de adoptantes.
- [ ] Seguimiento posterior a la adopción.
- [ ] Donativos y transparencia resumida.
- [ ] Registro y asignación de voluntarios.
- [ ] Directorio de veterinarias colaboradoras.
- [ ] Reportes administrativos básicos.

### Validación

- [ ] Pruebas de integración.
- [ ] Corrección de hallazgos.
- [ ] Validación con Bilay Campos.
- [ ] Despliegue Beta controlado.

## General Availability (GA)

- [ ] Fortalecer seguridad y privacidad.
- [ ] Implementar respaldos y restauración.
- [ ] Mejorar rendimiento y accesibilidad.
- [ ] Ejecutar regresión y aceptación.
- [ ] Completar documentación técnica y manuales.
- [ ] Integrar `develop` en `master` mediante pull request.
- [ ] Publicar versión estable.

## Fuera de la primera versión

- pagos en línea;
- publicaciones automáticas en Facebook;
- aplicación móvil nativa;
- notificaciones por WhatsApp o correo;
- portal independiente para veterinarias;
- inventario avanzado de alimento y medicinas;
- analítica predictiva o inteligencia artificial;
- geolocalización detallada.

Estas funciones permanecen documentadas para evaluación futura y no forman
parte de los criterios de aceptación de la primera versión.
