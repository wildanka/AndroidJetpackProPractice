package com.wildanka.moviecatalogue.util

import androidx.recyclerview.widget.DiffUtil
import com.wildanka.moviecatalogue.model.entity.MovieData

class FavMovieDiffCallback(oldMovieList : List<MovieData>, newMovieList : List<MovieData> ) : DiffUtil.Callback() {
    private var mOldFavoriteMovieData : List<MovieData>? = null
    private var mNewFavoriteMovieData : List<MovieData>? = null

    init {
        this.mOldFavoriteMovieData = oldMovieList
        this.mNewFavoriteMovieData = newMovieList
    }

    override fun getOldListSize(): Int {
        return mOldFavoriteMovieData?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return mNewFavoriteMovieData?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFavoriteMovieData?.get(oldItemPosition)?.idMovie == mNewFavoriteMovieData?.get(newItemPosition)?.idMovie
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldFavMovies : MovieData = mOldFavoriteMovieData?.get(oldItemPosition)!!
        val newFavMovies : MovieData = mNewFavoriteMovieData?.get(oldItemPosition)!!
        return oldFavMovies.title.equals(newFavMovies.title)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}