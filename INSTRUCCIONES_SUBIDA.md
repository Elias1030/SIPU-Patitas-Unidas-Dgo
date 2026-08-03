# Instrucciones de publicación

1. Descomprime `SIPU-Patitas-Unidas-Dgo.zip`.
2. Abre la carpeta descomprimida.
3. Haz clic derecho dentro de la carpeta y selecciona **Abrir en Terminal**.
4. Ejecuta:

   ```powershell
   powershell -ExecutionPolicy Bypass -File .\INSTALAR_EN_GITHUB.ps1
   ```

5. Si GitHub solicita autorización, inicia sesión con la cuenta `Elias1030`.

El script crea el commit inicial, publica `master` y crea `develop`. La rama `main` original permanecerá sin cambios y podrá conservarse como evidencia de la creación inicial del repositorio.

Si Git no está instalado, descárgalo desde https://git-scm.com/download/win y repite el procedimiento.
