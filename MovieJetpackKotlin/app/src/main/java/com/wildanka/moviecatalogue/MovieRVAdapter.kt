package com.wildanka.moviecatalogue

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieRVAdapter(private val mContext: Context) : RecyclerView.Adapter<MovieRVAdapter.MovieViewHolder>(){
    private var movieList = mutableListOf<Movie>()

    fun setupMovieList(movies : MutableList<Movie>){
        movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvTitle= itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(movie : Movie){
            tvTitle.text = movie.title
            tvRating.text = movie.rating
            tvReleaseDate.text = movie.releaseDate
            tvShortDesc.text = movie.shortDesc
            Log.e("MovieViewHolder", movie.posterUrl.toString())
            ivPoster.setImageResource(movie.posterUrl!!)
        }
    }
}