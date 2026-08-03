# Arquitectura de SIPU

SIPU se desarrollará como una aplicación web Java con arquitectura por capas.

## Componentes

- Navegador web: portal público y panel privado responsivo.
- Servidor web y de aplicaciones: Apache Tomcat compatible con Jakarta Servlet y JSP.
- Aplicación Java: controladores, servicios, validaciones y acceso a datos.
- Base de datos relacional: usuarios, animales, solicitudes, atenciones, gastos, donativos y bitácoras.
- Almacenamiento de archivos: fotografías y comprobantes; la base de datos conservará sus referencias.
- Repositorio GitHub: código, ramas, issues y pull requests.
- Travis CI: compilación y ejecución automática de pruebas JUnit.

## Ramas

- `develop`: integración del trabajo de la etapa Beta.
- `master`: código aprobado para General Availability (GA).
- Cada requerimiento se desarrolla en una rama `feature/<nombre>` y se integra mediante pull request hacia `develop`.

## Alcance de la primera versión

Incluye seguridad por roles, expedientes, adopciones, salud y gastos, donativos, voluntariado, veterinarias y reportes básicos.

No incluye pagos en línea, publicación automática en Facebook, aplicación móvil nativa, geolocalización en tiempo real ni avisos automáticos por mensajería. Estas funciones se conservan como trabajo futuro.
