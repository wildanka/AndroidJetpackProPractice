package com.wildanka.moviecatalogue

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.BuildConfig.API_V3_KEY
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.MovieFeeds
import com.wildanka.moviecatalogue.model.entity.TVShowData
import com.wildanka.moviecatalogue.model.entity.TVShowFeeds
import com.wildanka.moviecatalogue.model.network.ApiMovie
import com.wildanka.moviecatalogue.model.network.ApiMovie.Companion.MOVIE_CATEGORY
import com.wildanka.moviecatalogue.util.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {
    val TAG = "Fixture Repository"

    companion object {
        val instance = MoviesRepository
    }

    private val placeHolderApi: ApiMovie

    init {
        placeHolderApi = ApiClient.createService(ApiMovie::class.java)
    }

    fun fetchMovieData(): MutableLiveData<MutableList<MovieData>>? {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        val call = placeHolderApi.loadMovieList(MOVIE_CATEGORY, API_V3_KEY, "en")
        call.enqueue(object : Callback<MovieFeeds?> {
            override fun onFailure(call: Call<MovieFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieFeeds?>, response: Response<MovieFeeds?>) {
//                Log.e("MoviesRepository", response.body().toString())
                movieList.value = response.body()?.movieList
                Log.e("MoviesRepository", movieList.value?.get(0).toString())
            }
        })

        return movieList
    }

    fun fetchTvShowData(): MutableLiveData<MutableList<TVShowData>>? {
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        val call = placeHolderApi.loadTVShowList(API_V3_KEY, "en")
        call.enqueue(object : Callback<TVShowFeeds?> {
            override fun onFailure(call: Call<TVShowFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowFeeds?>, response: Response<TVShowFeeds?>) {
                tvShowList.value = response.body()?.tvShowList
            }
        })

        return tvShowList
    }

    fun fetchMovieDataDetail(): MutableLiveData<MovieData>? {
        val movie = MutableLiveData<MovieData>()
        val call = placeHolderApi.loadMovieData(API_V3_KEY, "en")
        call.enqueue(object : Callback<MovieData?> {
            override fun onFailure(call: Call<MovieData?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieData?>, response: Response<MovieData?>) {
                movie.value = response.body()
            }
        })

        return movie
    }

    fun fetchTvShowDataDetail(): MutableLiveData<TVShowData>? {
        val tvShow = MutableLiveData<TVShowData>()
        val call = placeHolderApi.loadTVShowData(API_V3_KEY, "en")
        call.enqueue(object : Callback<TVShowData?> {
            override fun onFailure(call: Call<TVShowData?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowData?>, response: Response<TVShowData?>) {
                tvShow.value = response.body()
            }
        })

        return tvShow
    }
}