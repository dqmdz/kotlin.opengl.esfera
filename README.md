# kotlin.opengl.esfera

Una aplicación 3D desarrollada con Kotlin y LibGDX que muestra una esfera rebotando en un espacio tridimensional.

## Descripción

Este proyecto implementa una simulación 3D de una esfera que rebota en un espacio definido, utilizando principios SOLID y buenas prácticas de programación. La aplicación demuestra el uso de gráficos 3D, física básica y manejo de iluminación.

## Características

- Renderizado 3D usando LibGDX
- Física de rebote en tres dimensiones
- Iluminación dinámica con luces direccionales y puntuales
- Implementación siguiendo principios SOLID
- Movimiento aleatorio después de cada rebote

## Estructura del Proyecto

```
src/main/kotlin/
├── physics/
│   └── BallPhysics.kt     # Manejo de la física de la pelota
├── rendering/
│   ├── BallRenderer.kt    # Renderizado de la esfera
│   └── Scene3D.kt         # Configuración de la escena 3D
├── BouncingBallGame.kt    # Clase principal del juego
├── GameScreen.kt          # Pantalla principal del juego
└── Main.kt               # Punto de entrada de la aplicación
```

## Requisitos

- Java JDK 17 o superior
- Gradle 8.0 o superior
- Kotlin 1.8.0 o superior

## Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/tuusuario/kotlin.opengl.esfera.git
```

2. Navega al directorio del proyecto:
```bash
cd kotlin.opengl.esfera
```

3. Ejecuta la aplicación:
```bash
./gradlew run
```

## Tecnologías Utilizadas

- Kotlin 1.8.0
- LibGDX 1.11.0
- OpenGL (a través de LibGDX)

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.