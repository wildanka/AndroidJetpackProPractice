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
import com.wildanka.moviecatalogue.model.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.model.entity.TVShowData
import com.wildanka.moviecatalogue.view.DetailActivity

class FavoriteTVPagedListAdapter() :
    PagedListAdapter<FavoriteTVShow, FavoriteTVPagedListAdapter.FavoriteTVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<FavoriteTVShow>() {
            override fun areItemsTheSame(oldItem: FavoriteTVShow, newItem: FavoriteTVShow) =
                oldItem.idTVShow == newItem.idTVShow

            override fun areContentsTheSame(oldItem: FavoriteTVShow, newItem: FavoriteTVShow) = oldItem == newItem
            // Favorite TVShow may have changed if reloaded from the database,
            // but ID is fixed.

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTVShowViewHolder {
        return FavoriteTVShowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: FavoriteTVShowViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let(holder::bind)
    }

    inner class FavoriteTVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(tvShow: FavoriteTVShow) {
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
            tvReleaseDate.text = tvShow.firstAirDate
            tvShortDesc.text = tvShow.overview
            Glide.with(itemView.context).load(BuildConfig.URL_IMG_APP + tvShow.posterPath).into(ivPoster)

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