# Guía de contribución a SIPU

## Flujo obligatorio

Los cambios no se incorporan directamente en `develop` o `master`. Cada tarea
se desarrolla en una rama independiente y se revisa mediante pull request.

## 1. Clonar el repositorio

```bash
git clone https://github.com/Elias1030/SIPU-Patitas-Unidas-Dgo.git
cd SIPU-Patitas-Unidas-Dgo
```

## 2. Actualizar develop

```bash
git checkout develop
git pull origin develop
```

## 3. Crear una rama

```bash
git checkout -b feature/B-XX-descripcion-corta
```

El nombre debe relacionarse con el issue correspondiente. También pueden usarse
`fix/` para correcciones y `docs/` para documentación.

## 4. Desarrollar y comprobar

```bash
mvn clean test
mvn clean package
```

No se enviarán cambios con pruebas fallidas, credenciales, datos personales,
archivos generados en `target` o configuraciones particulares del equipo.

## 5. Registrar los cambios

```bash
git status
git add ruta/del/archivo
git commit -m "tipo: descripción breve"
git push -u origin feature/B-XX-descripcion-corta
```

Tipos sugeridos: `feat`, `fix`, `docs`, `test`, `refactor` y `chore`.

## 6. Crear el pull request

1. Abrir el repositorio en GitHub.
2. Seleccionar **Pull requests** y **New pull request**.
3. Usar `develop` como base y la rama de la tarea como compare.
4. Explicar qué cambió, por qué, cómo se probó y qué issue atiende.
5. Crear el pull request.
6. Esperar revisión y atender observaciones.
7. Comprobar que Travis CI termine satisfactoriamente.

## 7. Merge

El merge se realiza únicamente cuando:

- las pruebas son satisfactorias;
- no existen conflictos;
- la documentación está actualizada;
- se cumplieron los criterios de aceptación;
- el cambio fue revisado.

Después del merge se elimina la rama remota y se actualiza `develop`. La rama
`develop` se integra en `master` únicamente para una liberación GA aprobada.

## Estilo y seguridad

- nombres de clases en PascalCase y métodos/variables en camelCase;
- validación del lado servidor;
- textos y archivos en UTF-8;
- prohibido incluir contraseñas o tokens;
- prohibido utilizar información real en pruebas;
- documentar cambios que afecten instalación o configuración.
