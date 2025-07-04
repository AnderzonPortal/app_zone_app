package com.example.app_s10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// app/src/main/java/com/example/app_s10/GameAdapter.kt
class GameAdapter(private var games: List<Game>, private val listener: OnGameActionListener) :
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    interface OnGameActionListener {
        fun onEditGame(game: Game)
        fun onDeleteGame(game: Game)
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvGameTitle)
        val tvGenre: TextView = itemView.findViewById(R.id.tvGameGenre)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBarItem)
        val btnEdit: Button = itemView.findViewById(R.id.btnEditGame)
        val btnDelete: Button = itemView.findViewById(R.id.btnDeleteGame)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.tvTitle.text = game.title
        holder.tvGenre.text = game.genre
        holder.ratingBar.rating = game.rating

        // Manejar el evento de Editar
        holder.btnEdit.setOnClickListener {
            listener.onEditGame(game)
        }

        // Manejar el evento de Eliminar
        holder.btnDelete.setOnClickListener {
            listener.onDeleteGame(game)
        }
    }

    override fun getItemCount() = games.size

    fun updateGames(newGames: List<Game>) {
        games = newGames
        notifyDataSetChanged()
    }
}
