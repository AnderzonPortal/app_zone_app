<h1 align="center">🎮 GameVault</h1>
<h3 align="center">Gestor de videojuegos con Firebase Authentication y Realtime Database</h3>

<p align="center">
  <img src="./imagenes/galeria1.png" alt="Vista previa" width="70%">
</p>

---

## 🔥 Configuración Firebase Database

Configura Firebase paso a paso para comenzar a trabajar con GameVault:

1. **Habilitar Realtime Database en Firebase Console**  
   ![Realtime Database](./imagenes/firebase-enable-db.png)

2. **Configurar reglas de seguridad**  
   ![Reglas de seguridad](./imagenes/firebase-rules.png)

3. **Agregar dependencia en `build.gradle`**  
   ![Gradle Firebase](./imagenes/gradle-dependency.png)

---

## 💾 Registro de Juegos

Todo comienza con un formulario intuitivo para agregar juegos a tu biblioteca personal.

- 🧩 **Crear modelo `Game.kt`**  
  ![Game Model](./imagenes/modelo-game.png)

- 🛠️ **Implementar `AddGameActivity.kt`**  
  ![AddGameActivity](./imagenes/add-game-activity.png)

- ✅ **Crear formulario con validaciones**  
  ![Formulario con validaciones](./imagenes/formulario-validado.png)

---

## 📋 Lista de Juegos

Visualiza tus juegos registrados en una lista dinámica con datos en tiempo real.

- 🧱 **RecyclerView con `GameAdapter`**  
  ![RecyclerView](./imagenes/game-adapter.png)

- 🔄 **Lectura en tiempo real desde Firebase**  
  ![Lectura en tiempo real](./imagenes/lectura-realtime.png)

- 🙋‍♂️ **Mostrar datos del usuario autenticado**  
  ![Datos del usuario](./imagenes/datos-usuario.png)

---

## ✨ Funcionalidades Extra (Opcionales)

Mejora tu experiencia con estas características adicionales:

| Funcionalidad              | Imagen                                 |
|---------------------------|----------------------------------------|
| ✏️ Editar juegos           | ![](./imagenes/editar-juego.png)       |
| 🗑️ Eliminar juegos         | ![](./imagenes/eliminar-juego.png)     |
| 🎯 Filtro por género       | ![](./imagenes/filtro-genero.png)      |
| 🔍 Búsqueda por título     | ![](./imagenes/busqueda-titulo.png)    |

---

## 🖼️ Galería de la Aplicación

> Echa un vistazo a cómo luce GameVault en acción:

<p align="center">
  <img src="./imagenes/galeria2.png" width="300">
  <img src="./imagenes/galeria3.png" width="300">
</p>

---

## 🛠 Tecnologías Utilizadas

- 🧩 Kotlin
- 🔐 Firebase Authentication
- 🌐 Firebase Realtime Database
- 📱 Android Studio
- 📦 RecyclerView

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.  
Puedes usarlo, modificarlo y compartirlo libremente.

---

## 🤝 Contribuciones

¿Quieres colaborar?

1. Haz un **fork** del repositorio
2. Crea una rama con tu funcionalidad: `feature/nueva-feature`
3. Haz commit de tus cambios
4. Abre un **Pull Request**

---

