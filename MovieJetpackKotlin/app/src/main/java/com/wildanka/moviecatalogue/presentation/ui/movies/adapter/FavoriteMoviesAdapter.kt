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
import com.wildanka.moviecatalogue.BuildConfig
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.presentation.ui.movies.DetailActivity

class FavoriteMoviesAdapter :
    RecyclerView.Adapter<FavoriteMoviesAdapter.FavoriteMoviesViewHolder>() {
    private var favoriteMovies: List<FavoriteMovie>? = null


    fun setupFavoriteMoviesData(favoriteMovies: List<FavoriteMovie>?) {
        if (favoriteMovies != null) {
            this.favoriteMovies = favoriteMovies
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return FavoriteMoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favoriteMovies?.size ?: 0
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val selectedItem = favoriteMovies?.get(position)
        if (selectedItem != null) {
            holder.bind(selectedItem)
        }
    }

    inner class FavoriteMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(favoriteMovie: FavoriteMovie) {
            if (favoriteMovie.voteAverage != null) {
                when {
                    favoriteMovie.voteAverage!! > 7 -> tvRating.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorGreen
                        )
                    )
                    favoriteMovie.voteAverage!! > 4 -> tvRating.setTextColor(
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
            }
            tvTitle.text = favoriteMovie.title
            tvRating.text = favoriteMovie.voteAverage.toString()
            tvReleaseDate.text = favoriteMovie.releaseDate
            tvShortDesc.text = favoriteMovie.overview
            Glide.with(itemView.context).load(BuildConfig.URL_IMG_APP + favoriteMovie.posterPath)
                .into(ivPoster)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, DetailActivity::class.java)
                        .putExtra("dataType", "MOVIE")
                        .putExtra("movieID", favoriteMovie.idMovie)
                )
            }
        }
    }
}