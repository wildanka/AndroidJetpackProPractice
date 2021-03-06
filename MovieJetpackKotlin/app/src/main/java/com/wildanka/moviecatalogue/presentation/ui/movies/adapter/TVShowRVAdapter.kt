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
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.presentation.ui.movies.DetailActivity

class TVShowRVAdapter : RecyclerView.Adapter<TVShowRVAdapter.TVShowViewHolder>() {
    private var tvShowList: MutableList<TVShowData>? = null

    fun setupTVShowList(tvShows: MutableList<TVShowData>?) {
        tvShowList = tvShows
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        return TVShowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return tvShowList?.size ?: 0
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val movie = tvShowList?.get(position)
        movie?.let(holder::bind)
    }

    inner class TVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(tvShow: TVShowData) {
            when {
                tvShow.voteAverage!! > 7 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGreen
                    )
                )
                tvShow.voteAverage > 4 -> tvRating.setTextColor(
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
            tvTitle.text = tvShow.title
            tvRating.text = tvShow.voteAverage.toString()
            tvReleaseDate.text = tvShow.airDate
            tvShortDesc.text = tvShow.overview
            Glide.with(itemView.context).load(BuildConfig.URL_IMG_APP + tvShow.posterPath)
                .into(ivPoster)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, DetailActivity::class.java)
                        .putExtra("dataType", "TV_SHOW")
                        .putExtra("tvShowID", tvShow.idTVShow)
                )
            }

        }
    }
}