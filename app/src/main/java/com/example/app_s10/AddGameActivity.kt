package com.example.app_s10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddGameActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var etTitle: EditText
    private lateinit var etGenre: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var btnSave: Button

    private var gameToEdit: Game? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        // Inicializar Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        // Inicializar las vistas
        etTitle = findViewById(R.id.etGameTitle)
        etGenre = findViewById(R.id.etGameGenre)
        ratingBar = findViewById(R.id.ratingBar)
        btnSave = findViewById(R.id.btnSaveGame)

        // Obtener el juego a editar, si lo hay
        gameToEdit = intent.getParcelableExtra("gameToEdit")

        // Si hay un juego a editar, llenar los campos
        if (gameToEdit != null) {
            fillFieldsWithGameData(gameToEdit!!)
        }

        // Configurar el botón guardar
        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val genre = etGenre.text.toString().trim()
            val rating = ratingBar.rating

            if (validateInput(title, genre)) {
                if (gameToEdit != null) {
                    // Si es un juego existente, actualizarlo
                    updateGame(gameToEdit!!, title, genre, rating)
                } else {
                    // Si es un nuevo juego, crear uno
                    saveGame(title, genre, rating)
                }
            }
        }
    }

    private fun fillFieldsWithGameData(game: Game) {
        // Llenar los campos con los datos del juego
        etTitle.setText(game.title)
        etGenre.setText(game.genre)
        ratingBar.rating = game.rating
    }

    private fun validateInput(title: String, genre: String): Boolean {
        if (title.isEmpty()) {
            showError("El título es obligatorio")
            return false
        }
        if (genre.isEmpty()) {
            showError("El género es obligatorio")
            return false
        }
        return true
    }

    private fun saveGame(title: String, genre: String, rating: Float) {
        val userId = auth.currentUser?.uid ?: return
        val gameId = database.child("games").child(userId).push().key ?: return

        val game = Game(
            id = gameId,
            title = title,
            genre = genre,
            rating = rating,
            userId = userId
        )

        database.child("games").child(userId).child(gameId).setValue(game)
            .addOnSuccessListener {
                showSuccess("¡Juego guardado exitosamente!")
                finish()
            }
            .addOnFailureListener { exception ->
                showError("Error al guardar: ${exception.message}")
            }
    }

    private fun updateGame(game: Game, title: String, genre: String, rating: Float) {
        val updatedGame = game.copy(title = title, genre = genre, rating = rating)

        database.child("games").child(game.userId).child(game.id).setValue(updatedGame)
            .addOnSuccessListener {
                showSuccess("¡Juego actualizado exitosamente!")
                finish()
            }
            .addOnFailureListener { exception ->
                showError("Error al actualizar: ${exception.message}")
            }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
