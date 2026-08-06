# Manual para usuario final de SIPU

## 1. Objetivo

Este manual explica el uso de la versión Beta del Sistema Integral Patitas
Unidas. Está dirigido a Bilay Campos y al personal autorizado para validar el
registro y seguimiento básico de animales rescatados.

> La versión actual es demostrativa. No se deben ingresar domicilios, teléfonos,
> datos de adoptantes, comprobantes ni información sensible.

## 2. Acceso

1. Confirmar con el administrador que Tomcat se encuentra encendido.
2. Abrir Chrome, Edge o Firefox.
3. Escribir la dirección proporcionada por el administrador. En el ambiente de
   prueba local se utiliza `http://localhost:8090/sipu/`.
4. Comprobar que aparezca la página principal de SIPU.
5. Seleccionar **Administrar animales**.

## 3. Registrar un expediente

1. Localizar la sección **Nuevo expediente**.
2. Capturar el nombre del animal.
3. Seleccionar especie y sexo.
4. Escribir la edad aproximada.
5. Indicar la fecha de ingreso.
6. Seleccionar el estado inicial.
7. Describir brevemente la condición al ingresar.
8. Presionar **Guardar expediente**.

Todos los campos son obligatorios. Al guardarse, el sistema asigna un folio
interno y muestra el expediente en el catálogo.

## 4. Consultar expedientes

Los expedientes aparecen debajo del formulario. Cada tarjeta presenta:

- folio SIPU;
- nombre, especie, sexo y edad aproximada;
- fecha y condición de ingreso;
- estado actual.

En esta iteración los registros se muestran del más reciente al más antiguo.

## 5. Cambiar el estado

1. Localizar la tarjeta del animal.
2. Seleccionar el nuevo estado.
3. Presionar **Cambiar estado**.

El sistema únicamente permite transiciones coherentes:

| Estado actual | Cambio permitido |
|---|---|
| Rescatado | En tratamiento o disponible |
| En tratamiento | Disponible |
| Disponible | En evaluación |
| En evaluación | Disponible o adoptado |
| Adoptado | En seguimiento |
| En seguimiento | Sin cambio posterior en la Beta |

Si el cambio no está permitido, el sistema rechaza la operación para conservar
la coherencia del expediente.

## 6. Cierre y limitaciones

No existe un botón para cerrar sesión porque la autenticación forma parte de la
siguiente iteración. Al terminar la prueba se puede cerrar el navegador.

Los registros actuales se almacenan temporalmente en memoria. Al apagar o
reiniciar Tomcat se eliminan. La base de datos PostgreSQL será obligatoria antes
del uso operativo.

## 7. Reporte de problemas

Al reportar una falla se debe proporcionar:

- acción que se estaba realizando;
- datos de prueba utilizados, sin información sensible;
- mensaje mostrado;
- captura de pantalla;
- fecha y hora aproximadas.

El reporte se registra como issue en GitHub para conservar su seguimiento.
