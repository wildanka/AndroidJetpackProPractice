package com.wildanka.moviecatalogue.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class TVShowRVAdapter(private val mContext: Context) : RecyclerView.Adapter<TVShowRVAdapter.TVShowViewHolder>(){
    private var movieList = mutableListOf<TvShow>()

    fun setupTVShowList(movies : MutableList<TvShow>){
        movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        return TVShowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    inner class TVShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvTitle= itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(tvShow : TvShow){
            when {
                tvShow.rating!!.toInt() > 70 -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorGreen
                ))
                tvShow.rating.toInt() > 40 -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorYellow
                ))
                else -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorRed
                ))
            }
            tvTitle.text = tvShow.title
            tvRating.text = tvShow.rating
            tvReleaseDate.text = tvShow.releaseDate
            tvShortDesc.text = tvShow.shortDesc
            Log.e("TVShowViewHolder", tvShow.posterUrl.toString())
            ivPoster.setImageResource(tvShow.posterUrl!!)
        }
    }
}