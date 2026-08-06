# Guion para el video demostrativo de SIPU

Duración sugerida: 5 a 8 minutos.

## 1. Presentación (30 segundos)

Presentar SIPU, Patitas Unidas Dgo y el problema de coordinación de expedientes,
adopciones, salud y apoyos.

## 2. Repositorio y administración (1 minuto)

Mostrar el repositorio, ramas `develop` y `master`, issues, milestones Beta/GA,
tablero y un pull request integrado.

## 3. Documentación (1 minuto)

Abrir el README, recorrer la tabla de contenidos, arquitectura, requerimientos,
manuales, contribución y roadmap.

## 4. Calidad e integración continua (1 minuto)

Mostrar Travis CI con `Passed` y el registro que indica pruebas ejecutadas, cero
fallos, cero errores y `BUILD SUCCESS`.

## 5. Demostración funcional (2 a 3 minutos)

1. Abrir la página inicial.
2. Entrar a **Administrar animales**.
3. Registrar un animal ficticio.
4. Mostrar folio y expediente.
5. Ejecutar un cambio permitido de estado.
6. Explicar brevemente la regla de transición.

## 6. Producto entregable (30 segundos)

Mostrar la construcción con `mvn clean package`, el archivo `target\sipu.war` y
explicar que se despliega en Tomcat.

## 7. Cierre (30 segundos)

Explicar con honestidad que la Beta actual almacena datos temporalmente y que
PostgreSQL, autenticación y módulos adicionales aparecen en el roadmap antes del
uso real por la organización.

## Recomendaciones

- grabar pantalla a 1080p;
- aumentar el zoom del navegador y la consola;
- evitar mostrar correos, tokens, contraseñas o datos personales;
- utilizar datos ficticios;
- comprobar audio antes de grabar;
- mantener el orden del guion y evitar pausas largas.
