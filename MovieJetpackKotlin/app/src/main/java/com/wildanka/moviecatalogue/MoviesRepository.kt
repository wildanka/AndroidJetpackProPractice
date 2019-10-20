package com.wildanka.moviecatalogue

import android.content.Context
import android.util.Log
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class MoviesRepository(private val context: Context) {

    fun getAllMovies(): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        val dataPoster = context.resources.obtainTypedArray(R.array.data_poster)

        for ((index, value) in context.resources.getStringArray(R.array.data_title).withIndex()) {
            Log.e("TES", "$index $value")
            movieList.add(
                Movie(
                    value,
                    context.resources.getStringArray(R.array.data_year)[index],
                    context.resources.getStringArray(R.array.data_rating)[index],
                    context.resources.getStringArray(R.array.data_short_desc)[index],
                    context.resources.getStringArray(R.array.data_ov)[index],
                    dataPoster.getResourceId(index, 0)
                )
            )
        }
        dataPoster.recycle() //recycle obatinTypedArray after being used
        return movieList
    }
    fun getAllTVShow(): MutableList<TvShow> {
        val movieList = mutableListOf<TvShow>()
        val dataPoster = context.resources.obtainTypedArray(R.array.data_poster)

        for ((index, value) in context.resources.getStringArray(R.array.data_title).withIndex()) {
            Log.e("TES", "$index $value")
            movieList.add(
                TvShow(
                    value,
                    context.resources.getStringArray(R.array.tv_data_year)[index],
                    context.resources.getStringArray(R.array.tv_data_rating)[index],
                    context.resources.getStringArray(R.array.tv_data_short_desc)[index],
                    context.resources.getStringArray(R.array.tv_data_ov)[index],
                    dataPoster.getResourceId(index, 0)
                )
            )
        }
        dataPoster.recycle() //recycle obatinTypedArray after being used
        return movieList
    }
}