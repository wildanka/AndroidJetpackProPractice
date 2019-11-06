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
import com.wildanka.moviecatalogue.model.entity.TVShowData
import com.wildanka.moviecatalogue.view.DetailActivity

class TVShowRVAdapter(private val mContext: Context) : RecyclerView.Adapter<TVShowRVAdapter.TVShowViewHolder>(){
    private var movieList : MutableList<TVShowData>? = null

    fun setupTVShowList(movies : MutableList<TVShowData>?){
        movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        return TVShowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val movie = movieList?.get(position)
        movie?.let { holder.bind(it, position) }
    }

    inner class TVShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvTitle= itemView.findViewById<TextView>(R.id.tv_item_title)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tv_item_release_date)
        private val tvShortDesc = itemView.findViewById<TextView>(R.id.tv_item_short_desc)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.iv_item_movie_poster)

        fun bind(tvShow : TVShowData, position : Int){
            when {
                tvShow.voteAverage!!.toInt() > 70 -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorGreen
                ))
                tvShow.voteAverage.toInt() > 40 -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorYellow
                ))
                else -> tvRating.setTextColor(ContextCompat.getColor(mContext,
                    R.color.colorRed
                ))
            }
            tvTitle.text = tvShow.title
            tvRating.text = tvShow.voteAverage
            tvReleaseDate.text = tvShow.airDate
            tvShortDesc.text = tvShow.overview
//            ivPoster.setImageResource(tvShow.posterPath!!)

            itemView.setOnClickListener {
                mContext.startActivity(
                    Intent(mContext, DetailActivity::class.java)
                        .putExtra("dataType", "TV_SHOW")
                        .putExtra("index", position)
                )
            }

        }
    }
}