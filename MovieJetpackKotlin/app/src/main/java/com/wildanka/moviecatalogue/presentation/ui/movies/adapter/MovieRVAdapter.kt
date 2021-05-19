package com.wildanka.moviecatalogue.presentation.ui.movies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.presentation.ui.movies.DetailActivity

class MovieRVAdapter : RecyclerView.Adapter<MovieRVAdapter.MovieViewHolder>() {
    private var movieList : MutableList<MovieData>? = null

    fun setupMovieList(movies: MutableList<MovieData>?) {
        movieList = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList?.get(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(movie: MovieData) {
            when {
                movie.voteAverage!! > 7 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGreen
                    )
                )
                movie.voteAverage > 4 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorYellow
                    )
                )
                else -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorRed
                    )
                )
            }
            tvTitle.text = movie.title
            tvRating.text = movie.voteAverage.toString()
            tvReleaseDate.text = movie.releaseDate
            tvShortDesc.text = movie.overview
            Glide.with(itemView.context).load(URL_IMG_APP+movie.posterPath).into(ivPoster)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, DetailActivity::class.java)
                        .putExtra("dataType", "MOVIE")
                        .putExtra("movieID", movie.idMovie)
                )
            }
        }


    }
}