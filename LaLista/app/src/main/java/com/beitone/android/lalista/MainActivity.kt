package com.beitone.android.lalista

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        

    }

    class MovieVH(itemView: View): RecyclerView.ViewHolder(itemView){
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieYear: TextView = itemView.findViewById(R.id.movieYear)
        val moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)
    }

    class MovieAdapter(val context: Context): RecyclerView.Adapter<MovieVH>() {

        private var peliculas: Array<Pelicula> = emptyArray()

        fun establecerPeliculas(nuevasPeliculas: Array<Pelicula>) {
            this.peliculas = nuevasPeliculas
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
            val inflater = LayoutInflater.from(context)
            val vista = inflater.inflate(R.layout.movie_item, parent,false)
            return MovieVH(vista)
        }

        override fun onBindViewHolder(holder: MovieVH, position: Int) {
            val pelicula = peliculas[position]
            holder.movieTitle.text = pelicula.titulo
            holder.movieYear.text = pelicula.fecha
            holder.moviePoster.setImageResource(pelicula.imagen)
        }

        override fun getItemCount(): Int {
            return peliculas.size
        }

    }

}