package com.wildanka.moviecatalogue.data

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.BuildConfig.API_V3_KEY
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowFeeds
import com.wildanka.moviecatalogue.domain.entity.*
import com.wildanka.moviecatalogue.data.datasource.remote.service.ApiMovie
import com.wildanka.moviecatalogue.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {

    private val placeHolderApi: ApiMovie = ApiClient.createService(
        ApiMovie::class.java
    )

    fun fetchMovieData(): MutableLiveData<MutableList<MovieData>> {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        val call = placeHolderApi.loadMovieList(API_V3_KEY, "en")
        call.enqueue(object : Callback<MovieFeeds?> {
            override fun onFailure(call: Call<MovieFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieFeeds?>, response: Response<MovieFeeds?>) {
                movieList.value = response.body()?.movieList
            }
        })

        return movieList
    }

    fun fetchTvShowData(): MutableLiveData<MutableList<TVShowData>> {
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

    fun fetchMovieDataDetail(movieId: String?): MutableLiveData<MovieDetail> {
        val movie = MutableLiveData<MovieDetail>()
        val call = placeHolderApi.loadMovieDetail(movieId, API_V3_KEY)
        call.enqueue(object : Callback<MovieDetail?> {
            override fun onFailure(call: Call<MovieDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieDetail?>, response: Response<MovieDetail?>) {
                movie.value = response.body()
            }
        })
        return movie
    }

    fun fetchMovieDetailCredits(movieId: String?): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        val call = placeHolderApi.loadMovieCredits(movieId, API_V3_KEY)
        call.enqueue(object : Callback<MovieCredits?> {
            override fun onFailure(call: Call<MovieCredits?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieCredits?>, response: Response<MovieCredits?>) {
                movieCredits.value = response.body()
            }
        })
        return movieCredits
    }

    fun fetchTVShowDetailCredits(tvShowId: String?): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        val call = placeHolderApi.loadTVShowCredits(tvShowId, API_V3_KEY)
        call.enqueue(object : Callback<MovieCredits?> {
            override fun onFailure(call: Call<MovieCredits?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieCredits?>, response: Response<MovieCredits?>) {
                movieCredits.value = response.body()
            }
        })
        return movieCredits
    }

    fun fetchTvShowDataDetail(tvShowId: String?): MutableLiveData<TVShowDetail> {
        val tvShow = MutableLiveData<TVShowDetail>()
        val call = placeHolderApi.loadTVShowDetail(tvShowId, API_V3_KEY)
        call.enqueue(object : Callback<TVShowDetail?> {
            override fun onFailure(call: Call<TVShowDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowDetail?>, response: Response<TVShowDetail?>) {
                tvShow.value = response.body()
            }
        })

        return tvShow
    }
}