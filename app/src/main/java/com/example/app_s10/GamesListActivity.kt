package com.example.app_s10

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DatabaseError

class GamesListActivity : AppCompatActivity(), GameAdapter.OnGameActionListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private lateinit var genreSpinner: Spinner
    private lateinit var searchEditText: EditText

    private var gamesList: MutableList<Game> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        recyclerView = findViewById(R.id.recyclerViewGames)
        genreSpinner = findViewById(R.id.spinnerGenre)
        searchEditText = findViewById(R.id.editTextSearch)

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        gameAdapter = GameAdapter(gamesList, this) // Pasar listener para las acciones de editar/eliminar
        recyclerView.adapter = gameAdapter

        // Configurar filtro de géneros
        setupGenreFilter()

        // Configurar búsqueda de juego
        setupSearch()

        // Obtener juegos desde Firebase
        getGames()
    }

    private fun setupGenreFilter() {
        // Obtener géneros únicos de Firebase
        val genreList = mutableListOf<String>()
        genreList.add("Todos los géneros")

        database.child("games").child(auth.currentUser?.uid ?: return).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (gameSnapshot in snapshot.children) {
                    val game = gameSnapshot.getValue(Game::class.java)
                    game?.let {
                        if (!genreList.contains(it.genre)) {
                            genreList.add(it.genre)
                        }
                    }
                }

                // Configurar el Spinner con los géneros disponibles
                val adapter = ArrayAdapter(this@GamesListActivity, android.R.layout.simple_spinner_item, genreList)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                genreSpinner.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@GamesListActivity, "Error al cargar géneros: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })

        // Establecer el listener explícito para el Spinner
        genreSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedGenre = parentView?.getItemAtPosition(position).toString()
                filterGamesByGenre(selectedGenre)
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Opcional: Puedes dejar esto vacío si no necesitas hacer nada cuando no se selecciona un ítem
            }
        })
    }

    private fun setupSearch() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().toLowerCase()
                filterGamesBySearch(query)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun getGames() {
        database.child("games").child(auth.currentUser?.uid ?: return).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                gamesList.clear()

                for (gameSnapshot in snapshot.children) {
                    val game = gameSnapshot.getValue(Game::class.java)
                    game?.let {
                        gamesList.add(it)
                    }
                }

                gameAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@GamesListActivity, "Error al cargar los juegos: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun filterGamesByGenre(genre: String) {
        val filteredGames = if (genre == "Todos los géneros") {
            gamesList
        } else {
            gamesList.filter { it.genre == genre }
        }
        gameAdapter.updateGames(filteredGames)
    }

    private fun filterGamesBySearch(query: String) {
        val filteredGames = gamesList.filter { it.title.toLowerCase().contains(query) }
        gameAdapter.updateGames(filteredGames)
    }

    // Implementación de la interfaz OnGameActionListener
    override fun onEditGame(game: Game) {
        // Lógica para editar el juego
        val intent = Intent(this, AddGameActivity::class.java)
        intent.putExtra("gameToEdit", game) // Pasar el juego a editar
        startActivity(intent)
    }



    override fun onDeleteGame(game: Game) {
        // Lógica para eliminar el juego
        Toast.makeText(this, "Eliminar juego: ${game.title}", Toast.LENGTH_SHORT).show()
        // Aquí puedes eliminar el juego de la base de datos
        deleteGame(game)
    }

    private fun deleteGame(game: Game) {
        val gameRef = database.child("games").child(auth.currentUser?.uid ?: return).child(game.id)
        gameRef.removeValue().addOnSuccessListener {
            Toast.makeText(this, "Juego eliminado exitosamente", Toast.LENGTH_SHORT).show()
            // Actualizar la lista de juegos
            getGames()
        }.addOnFailureListener { exception ->
            Toast.makeText(this, "Error al eliminar juego: ${exception.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
