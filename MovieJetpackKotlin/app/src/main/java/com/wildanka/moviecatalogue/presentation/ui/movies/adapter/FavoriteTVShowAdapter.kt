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
import com.wildanka.moviecatalogue.domain.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.presentation.ui.movies.DetailActivity

class FavoriteTVShowAdapter() : RecyclerView.Adapter<FavoriteTVShowAdapter.FavoriteTVShowViewHolder>() {
    private var favoriteTVShow: List<FavoriteTVShow>? = null


    fun setupFavoriteTVShowData(favoriteTVShow: List<FavoriteTVShow>?){
        if (favoriteTVShow != null) {
            this.favoriteTVShow = favoriteTVShow
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTVShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return FavoriteTVShowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favoriteTVShow?.size ?: 0
    }

    override fun onBindViewHolder(holder: FavoriteTVShowViewHolder, position: Int) {
        val selectedItem = favoriteTVShow?.get(position)
        if (selectedItem != null) {
            holder.bind(selectedItem)
        }
    }

    inner class FavoriteTVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(favoriteTVShow: FavoriteTVShow){
            when {
                favoriteTVShow.voteAverage!! > 7 -> tvRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGreen
                    )
                )
                favoriteTVShow.voteAverage > 4 -> tvRating.setTextColor(
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
            tvTitle.text = favoriteTVShow.title
            tvRating.text = favoriteTVShow.voteAverage.toString()
            tvReleaseDate.text = favoriteTVShow.firstAirDate
            tvShortDesc.text = favoriteTVShow.overview
            Glide.with(itemView.context).load(BuildConfig.URL_IMG_APP +favoriteTVShow.posterPath).into(ivPoster)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, DetailActivity::class.java)
                        .putExtra("dataType", "MOVIE")
                        .putExtra("tvShowID", favoriteTVShow.idTVShow)
                )
            }
        }
    }
}