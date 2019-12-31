package com.wildanka.moviecatalogue.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildanka.moviecatalogue.BuildConfig
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.model.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.view.DetailActivity

class FavoriteMoviePagedListAdapter() :
    PagedListAdapter<FavoriteMovie, FavoriteMoviePagedListAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<FavoriteMovie>() {
            override fun areItemsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie) =
                oldItem.idMovie == newItem.idMovie

            override fun areContentsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie) = oldItem == newItem
            // Favorite Movie may have changed if reloaded from the database,
            // but ID is fixed.

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        return FavoriteMoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let(holder::bind)
    }

    inner class FavoriteMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(favoriteMovie: FavoriteMovie) {
            when {
                favoriteMovie.voteAverage!! > 7 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGreen
                    )
                )
                favoriteMovie.voteAverage > 4 -> tvRating.setTextColor(
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
            tvTitle.text = favoriteMovie.title
            tvRating.text = favoriteMovie.voteAverage.toString()
            tvReleaseDate.text = favoriteMovie.releaseDate
            tvShortDesc.text = favoriteMovie.overview
            Glide.with(itemView.context).load(BuildConfig.URL_IMG_APP + favoriteMovie.posterPath).into(ivPoster)

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