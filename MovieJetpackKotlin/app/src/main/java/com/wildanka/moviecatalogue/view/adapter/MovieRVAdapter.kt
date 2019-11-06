package com.wildanka.moviecatalogue.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.view.DetailActivity

class MovieRVAdapter(private val mContext: Context) : RecyclerView.Adapter<MovieRVAdapter.MovieViewHolder>() {
    private var movieList : MutableList<MovieData>? = null

    fun setupMovieList(movies: MutableList<MovieData>?) {
        movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return if (movieList != null) {
            movieList!!.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList?.get(position)
        if (movie != null) {
            holder.bind(movie, position)
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(movie: MovieData, position: Int) {
            when {
                movie.voteAverage!!.toInt() > 70 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.colorGreen
                    )
                )
                movie.voteAverage.toInt() > 40 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.colorYellow
                    )
                )
                else -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.colorRed
                    )
                )
            }
            tvTitle.text = movie.title
            tvRating.text = movie.voteAverage
            tvReleaseDate.text = movie.releaseDate
            tvShortDesc.text = movie.overview
//            ivPoster.setImageResource(movie.posterPath!!) use glide or picasso

            itemView.setOnClickListener {
                mContext.startActivity(
                    Intent(mContext, DetailActivity::class.java)
                        .putExtra("dataType", "MOVIE")
                        .putExtra("index", position)
                )
            }
        }


    }
}