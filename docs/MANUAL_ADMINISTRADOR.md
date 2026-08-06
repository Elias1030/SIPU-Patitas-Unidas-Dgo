# Manual del administrador de SIPU

## 1. Responsabilidades

El administrador prepara el ambiente, compila el proyecto, ejecuta pruebas,
despliega el WAR, inicia o detiene Tomcat y revisa los registros del servidor.

## 2. Requisitos

- Windows 11 o sistema equivalente;
- JDK 17 o superior;
- Maven 3.9 o superior;
- Apache Tomcat 10.1 u 11;
- Git;
- acceso al repositorio.

## 3. Variables de entorno en PowerShell

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
$env:CATALINA_HOME = "$HOME\Apache Software Foundation\Tomcat 11.0"
$env:CATALINA_BASE = $env:CATALINA_HOME
```

Comprobar Java y Maven:

```powershell
java -version
mvn -version
```

## 4. Construcción y pruebas

Desde la raíz del repositorio:

```powershell
mvn clean package
```

El resultado aceptable es `BUILD SUCCESS`, con cero fallos y errores. Maven
genera `target\sipu.war`.

Para ejecutar únicamente las pruebas:

```powershell
mvn clean test
```

## 5. Despliegue local

```powershell
Copy-Item ".\target\sipu.war" "$env:CATALINA_HOME\webapps\sipu.war" -Force
& "$env:CATALINA_HOME\bin\startup.bat"
```

Abrir `http://localhost:8090/sipu/` o sustituir `8090` por el puerto configurado.

Para detener el servidor:

```powershell
& "$env:CATALINA_HOME\bin\shutdown.bat"
```

## 6. Actualización

1. Detener Tomcat.
2. Actualizar el código desde la rama aprobada.
3. Ejecutar `mvn clean package`.
4. Confirmar las pruebas.
5. Sustituir `webapps\sipu.war`.
6. Iniciar Tomcat.
7. realizar una prueba de humo: abrir inicio, registrar un caso ficticio y
   consultar el expediente.

## 7. Diagnóstico

Los registros de Tomcat se encuentran en:

```text
%CATALINA_HOME%\logs
```

Revisar principalmente `catalina`, `localhost` y la consola de inicio. Los
problemas habituales son:

| Síntoma | Revisión |
|---|---|
| Maven utiliza Java incorrecto | Revisar `JAVA_HOME` y `mvn -version`. |
| Tomcat no inicia | Revisar `CATALINA_HOME` y si el puerto está ocupado. |
| Error 404 | Confirmar que `sipu.war` esté en `webapps`. |
| Error 500 | Revisar consola y archivos de `logs`. |
| No aparecen datos después de reiniciar | Comportamiento conocido del almacenamiento temporal. |

## 8. Seguridad y respaldos

La Beta no está autorizada para almacenar datos reales. Antes de producción se
deben habilitar autenticación, roles, HTTPS, PostgreSQL, bitácora y respaldos.
Cuando exista base de datos, el administrador deberá comprobar periódicamente la
restauración de los respaldos, no solo su creación.
