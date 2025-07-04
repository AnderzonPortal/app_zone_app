<h1 align="center">🎮 GameVault</h1>
<h3 align="center">Gestor de videojuegos con Firebase Authentication y Realtime Database</h3>

<p align="center">
  <img src="app/src/imagenes/galeria1.jpg" alt="Vista previa" width="50%">
</p>

---

## 🔥 Configuración Firebase Database

Configura Firebase paso a paso para comenzar a trabajar con GameVault:

1. **Habilitar Realtime Database en Firebase Console**  
   ![Realtime Database](app/src/imagenes/firebase-enable-db.jpg)

2. **Configurar reglas de seguridad**  
   ![Reglas de seguridad](app/src/imagenes/firebase-rules.jpg)

3. **Agregar dependencia en `build.gradle`**  
   ![Gradle Firebase](app/src/imagenes/gradle-dependency.jpg)

---

## 💾 Registro de Juegos

Todo comienza con un formulario intuitivo para agregar juegos a tu biblioteca personal.

- 🧩 **Crear modelo `Game.kt`**  
  ![Game Model](./imagenes/modelo-game.jpg)

- 🛠️ **Implementar `AddGameActivity.kt`**  
  ![AddGameActivity](./imagenes/add-game-activity.jpg)

- ✅ **Crear formulario con validaciones**  
  ![Formulario con validaciones](./imagenes/formulario-validado.jpg)

---

## 📋 Lista de Juegos

Visualiza tus juegos registrados en una lista dinámica con datos en tiempo real.

- 🧱 **RecyclerView con `GameAdapter`**  
  ![RecyclerView](./imagenes/game-adapter.jpg)


- 🙋‍♂️ **Mostrar datos del usuario autenticado**  
  ![Datos del usuario](./imagenes/datos-usuario.jpg)

| Funcionalidad              | Imagen                                                                 |
|---------------------------|------------------------------------------------------------------------|
| ✏️ Editar juegos           | ![](./imagenes/editar-juego1.jpg)<br>![](./imagenes/editar-juego2.jpg)<br>![](./imagenes/editar-juego3.jpg) |
| 🗑️ Eliminar juegos         | ![](./imagenes/eliminar-juego1.jpg)<br>![](./imagenes/eliminar-juego2.jpg) |
| 🎯 Filtro por género       | ![](./imagenes/filtro-genero1.jpg)<br>![](./imagenes/filtro-genero2.jpg) |
| 🔍 Búsqueda por título     | ![](./imagenes/busqueda-titulo.jpg)                                    |

---

## 🛠 Tecnologías Utilizadas

- 🧩 Kotlin
- 🔐 Firebase Authentication
- 🌐 Firebase Realtime Database
- 📱 Android Studio
- 📦 RecyclerView

---

