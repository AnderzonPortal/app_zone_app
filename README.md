<h1 align="center">🎮 GameVault</h1>
<h3 align="center">Gestor de videojuegos con Firebase Authentication y Realtime Database</h3>

<p align="center">
  <img src="app/src/imagenes/galeria1.jpg" alt="Vista previa" width="40%">
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
  ![Game Model](app/src/imagenes/modelo-game.jpg)

- 🛠️ **Implementar `AddGameActivity.kt`**  
  ![AddGameActivity](app/src/imagenes/add-game-activity.jpg)

- ✅ **Crear formulario con validaciones**  
  <img src="app/src/imagenes/formulario-validado.jpg" width="40%">

---

## 📋 Lista de Juegos

Visualiza tus juegos registrados en una lista dinámica con datos en tiempo real.

- 🧱 **RecyclerView con `GameAdapter`**  
  ![RecyclerView](app/src/imagenes/game-adapter.jpg)


- 🙋‍♂️ **Mostrar datos del usuario autenticado**  
  <img src="app/src/imagenes/datos-usuario.jpg" width="40%">

| Funcionalidad              | Imagen                                                                 |
|---------------------------|------------------------------------------------------------------------|
| ✏️ Editar juegos           | <img src="app/src/imagenes/editar-juego1.jpg" width="35%"> &nbsp; <img src="app/src/imagenes/editar-juego2.jpg" width="35%"> &nbsp; <img src="app/src/imagenes/editar-juego3.jpg" width="35%"> |
| 🗑️ Eliminar juegos         | <img src="app/src/imagenes/eliminar-juego1.jpg" width="35%"> &nbsp;&nbsp; <img src="app/src/imagenes/eliminar-juego2.jpg" width="35%"> |
| 🎯 Filtro por género       | <img src="app/src/imagenes/filtro-genero1.jpg" width="35%"> &nbsp;&nbsp; <img src="app/src/imagenes/filtro-genero2.jpg" width="35%"> |
| 🔍 Búsqueda por título     | <img src="app/src/imagenes/busqueda-titulo.jpg" width="35%"> |

---

## 🛠 Tecnologías Utilizadas

- 🧩 Kotlin
- 🔐 Firebase Authentication
- 🌐 Firebase Realtime Database
- 📱 Android Studio
- 📦 RecyclerView

---

