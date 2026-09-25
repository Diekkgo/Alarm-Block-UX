# AlarmBlock Mobile

Aplicación móvil desarrollada en **Android con Kotlin y Jetpack Compose** para la gestión y seguimiento de alarmas.

AlarmBlock busca complementar el funcionamiento tradicional de una alarma incorporando funcionalidades como alarmas recurrentes, seguimiento de rachas y misiones obligatorias que deben completarse para poder posponer una alarma.

## Tecnologías

El proyecto utiliza principalmente:

- Kotlin
- Android SDK
- Jetpack Compose
- Material 3
- Navigation Compose
- Gradle

## Funcionalidades

La aplicación incluye las siguientes funcionalidades y pantallas:

### Inicio

La pantalla principal permite:

- Visualizar las alarmas configuradas.
- Activar o desactivar una alarma.
- Crear una nueva alarma.
- Consultar la racha actual.
- Acceder al detalle y progreso de la racha.
- Simular la activación de una alarma para probar el flujo de la aplicación.

### Creación de alarmas

La aplicación cuenta con un flujo para configurar nuevas alarmas, incluyendo diferentes parámetros y límites asociados a su funcionamiento.

### Alarma activa

Al simular una alarma se muestra la pantalla correspondiente a una alarma activa.

Desde esta pantalla el usuario puede:

- **Apagar** la alarma.
- **Posponer** la alarma.

Al apagar la alarma se muestra una pantalla de confirmación y se actualiza visualmente el progreso de la racha.

### Misión obligatoria

Cuando se selecciona la opción **Posponer**, la aplicación dirige al usuario a una misión obligatoria.

Para continuar, basta con presionar el botón **Verificar**, resolver la operación es opcional.


### Confirmación de alarma pospuesta

Después de completar correctamente la misión obligatoria, la aplicación informa que la alarma fue pospuesta y muestra la cantidad de oportunidades restantes para posponerla.

### Detalle de racha

Desde la pantalla principal se puede acceder al detalle de la racha.

Esta pantalla muestra:

- Cantidad de días consecutivos sin posponer la alarma.
- Historial visual de los últimos días.
- Días en los que la alarma no fue pospuesta.
- Días en los que fue pospuesta.
- Días sin información.
- Mensaje relacionado con el progreso de la racha.

## Ejecución

Para ejecutar el proyecto:

1. Abrir el proyecto en **Android Studio**.
2. Esperar a que Gradle sincronice las dependencias.
3. Seleccionar un emulador o dispositivo Android disponible con Android 11 (API 30). Para las pruebas en emulador se recomienda utilizar un Pixel 5 con Android 11 (API 30).
4. Ejecutar la aplicación mediante **Run 'app'**.

## Flujo recomendado para probar la aplicación

### Para comprobar el flujo de la alarma:

1. Iniciar la aplicación.
2. En la pantalla principal seleccionar **Simular alarma**.
3. En la pantalla de la alarma seleccionar **Posponer**.
4. Se mostrará la pantalla **Misión obligatoria**.
5. Presionar **Verificar** (Resolver la operación es opcional).
6. Se mostrará la confirmación de que la alarma fue pospuesta.

### Para probar el flujo de apagado:

1. Seleccionar **Simular alarma**.
2. Presionar **Apagar**.
3. Se mostrará la pantalla de confirmación correspondiente.
4. Presionar **Volver al Inicio**.

### Para crear una nueva alarma

1. Seleccionar **Nueva Alarma**.
2. Utilizar los botones (+) y (-) para aumentar o disminuir la hora de la alarma (opcional).
3. Ingresar un nombre para la alarma (opcional).
4. Seleccionar un sonido (opcional).
5. Presionar **Siguiente**.
6. En la pantalla de configuración del límite de posposición, utilizar los botones (+) y (-) para aumentar o disminuir el número de veces que la alarma puede posponerse.
7. Presionar **Guardar alarma**.

### Para ver la racha

1. En la pantalla principal, seleccionar la tarjeta que muestra los días consecutivos sin posponer la alarma.
2. Se mostrará el detalle de la racha del usuario y el historial de los últimos días.

## Commits

Cada integrante del equipo adoptó una estrategia de trabajo y publicación de commits de acuerdo con la organización definida durante el desarrollo de la aplicación.

- **Carlos Zerpa:** realizó sus cambios en la rama `feat/mobile-screens-czerpa`, en la cual se encuentran los commits correspondientes al desarrollo de las pantallas asignadas.

- **Diego Gómez:** realizó y publicó sus commits directamente sobre la rama `main`.