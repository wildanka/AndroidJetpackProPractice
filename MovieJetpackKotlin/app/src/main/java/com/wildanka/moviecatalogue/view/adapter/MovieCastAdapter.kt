package com.wildanka.moviecatalogue.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildanka.moviecatalogue.BuildConfig
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.model.entity.MovieCast

class MovieCastAdapter(private val mContext: Context?) : RecyclerView.Adapter<MovieCastAdapter.MovieCastViewHolder>() {
    private var movieCast : MutableList<MovieCast>? = null

    fun setupMovieCastData(movieCast: MutableList<MovieCast>?){
        this.movieCast = movieCast
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.item_cast, parent, false)
        return MovieCastViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return if (movieCast != null) {
            movieCast!!.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: MovieCastViewHolder, position: Int) {
        val cast = movieCast?.get(position)
        holder.bind(cast)
    }

    inner class MovieCastViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        private val tvCastName = itemView!!.findViewById<TextView>(R.id.tv_cast_name)
        private val tvCastRole = itemView!!.findViewById<TextView>(R.id.tv_cast_role)
        private val ivCastPict = itemView!!.findViewById<ImageView>(R.id.iv_cast_pict)

        fun bind(movieCast: MovieCast?){
            tvCastName.text = movieCast?.name
            tvCastRole.text = movieCast?.character
            if (mContext != null) {
                Glide.with(mContext).load(BuildConfig.URL_IMG_APP_92+movieCast?.profilePath).into(ivCastPict)
            }
        }
    }
}