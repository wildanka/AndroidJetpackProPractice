package com.wildanka.moviecatalogue.data.datasource.remote

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.BuildConfig
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowFeeds
import com.wildanka.moviecatalogue.domain.entity.MovieFeeds
import com.wildanka.moviecatalogue.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource().apply { instance = this }
            }
    }

    fun fetchMovieData(callback: LoadMoviesCallback){
        val movieList = MutableLiveData<MutableList<MovieData>>()
        val call = ApiClient.getMovieService().loadMovieList(BuildConfig.API_V3_KEY, "en")
        call.enqueue(object : Callback<MovieFeeds?> {
            override fun onFailure(call: Call<MovieFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieFeeds?>, response: Response<MovieFeeds?>) {
                movieList.value = response.body()?.movieList!!
                callback.onAllMovieReceived(movieList.value!!)
            }
        })

    }

    fun fetchTVShowData(callback: LoadTVShowsCallback){
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        val call = ApiClient.getMovieService().loadTVShowList(BuildConfig.API_V3_KEY, "en")
        call.enqueue(object : Callback<TVShowFeeds?> {
            override fun onFailure(call: Call<TVShowFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowFeeds?>, response: Response<TVShowFeeds?>) {
                tvShowList.value = response.body()?.tvShowList!!
                callback.onAllTVShowReceived(tvShowList.value!!)
            }
        })

    }

    interface LoadMoviesCallback{
        fun onAllMovieReceived(movieResponse: MutableList<MovieData>)
    }
    interface LoadTVShowsCallback{
        fun onAllTVShowReceived(tvShowResponses: MutableList<TVShowData>)
    }
}