# Instalación y configuración de SIPU

## 1. Ambiente de desarrollo

| Componente | Versión |
|---|---|
| Java | 17 como nivel de compilación; probado con Java 21.0.2 LTS |
| Maven | 3.9.6 o superior |
| Tomcat | 10.1 u 11 |
| Jakarta Servlet API | 6.0.0 |
| JUnit Jupiter | 5.11.4 |
| Git | Versión compatible con GitHub |

Clonar y seleccionar la rama de integración:

```powershell
git clone https://github.com/Elias1030/SIPU-Patitas-Unidas-Dgo.git
Set-Location .\SIPU-Patitas-Unidas-Dgo
git checkout develop
```

Compilar y probar:

```powershell
mvn clean package
```

## 2. Paquetes Maven

El archivo `pom.xml` administra:

- `jakarta.servlet-api` para Servlets;
- `junit-jupiter` para pruebas;
- `maven-compiler-plugin` para Java 17;
- `maven-surefire-plugin` para ejecutar JUnit;
- `maven-war-plugin` para generar `sipu.war`.

No deben copiarse manualmente archivos JAR al proyecto.

## 3. Pruebas manuales

Después del despliegue:

1. Abrir la página principal.
2. Entrar a **Administrar animales**.
3. Registrar un caso ficticio con todos los campos.
4. Verificar folio, datos y estado.
5. Ejecutar una transición válida.
6. Intentar una transición no permitida y confirmar el rechazo.
7. Reiniciar Tomcat y comprobar la limitación documentada de persistencia.

## 4. Archivos de configuración

| Archivo | Propósito |
|---|---|
| `pom.xml` | Dependencias, Java, pruebas y empaquetado WAR. |
| `.travis.yml` | Integración continua con Java y Maven. |
| `.gitignore` | Exclusión de archivos generados y temporales. |
| `README.md` | Resumen y navegación de la documentación. |
| `server.xml` de Tomcat | Puerto y conectores del servidor local. |

El puerto local se define en el `server.xml` externo al repositorio. En el
ambiente comprobado se utiliza `8090`.

## 5. Variables

| Variable | Uso |
|---|---|
| `JAVA_HOME` | Ruta del JDK. |
| `CATALINA_HOME` | Instalación de Tomcat. |
| `CATALINA_BASE` | Configuración de la instancia. |
| `PORT` | Puerto asignado en nube. |
| `DATABASE_URL` | Conexión futura a PostgreSQL. |
| `DB_USER` y `DB_PASSWORD` | Credenciales futuras, nunca incluidas en Git. |
| `SIPU_ENV` | Ambiente `development`, `test` o `production`. |

## 6. Producción local

La solución puede instalarse en un equipo servidor dentro de la organización.
Requiere dirección local estable, firewall limitado, PostgreSQL, autenticación,
HTTPS y respaldos. No se debe exponer directamente el puerto de Tomcat a
Internet.

## 7. Nube

Para Heroku o una plataforma equivalente se planea empaquetar SIPU con Docker,
configurar el puerto dinámico, utilizar PostgreSQL administrado y proporcionar
los secretos mediante variables protegidas. El despliegue no se considera listo
hasta implementar persistencia, autenticación, roles y HTTPS.

## 8. Configuración por ambiente

| Ambiente | Configuración |
|---|---|
| Desarrollo | HTTP local, datos ficticios y mensajes detallados. |
| Pruebas | Información ficticia y ejecución JUnit/Travis CI. |
| Producción | PostgreSQL, HTTPS, roles, bitácora, secretos y respaldos. |
