package com.wildanka.moviecatalogue.data.datasource.remote

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.BuildConfig.API_V3_KEY
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowFeeds
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
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
        val call = ApiClient.getMovieService().loadMovieList(API_V3_KEY, "en")
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
        val call = ApiClient.getMovieService().loadTVShowList(API_V3_KEY, "en")
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

    fun fetchMovieDataDetail(movieId: String, callback: LoadMovieDetailCallback): MutableLiveData<MovieDetail> {
        val movie = MutableLiveData<MovieDetail>()
        val call = ApiClient.getMovieService().loadMovieDetail(movieId, API_V3_KEY)
        call.enqueue(object : Callback<MovieDetail?> {
            override fun onFailure(call: Call<MovieDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieDetail?>, response: Response<MovieDetail?>) {
                movie.value = response.body()
                movie.value?.let { callback.onMovieDetailReceived(it) }
            }
        })
        return movie
    }

    fun fetchTvShowDataDetail(tvShowId: String?, callback: LoadTVShowDetailCallback): MutableLiveData<TVShowDetail> {
        val tvShow = MutableLiveData<TVShowDetail>()
        val call = ApiClient.getMovieService().loadTVShowDetail(tvShowId, API_V3_KEY)
        call.enqueue(object : Callback<TVShowDetail?> {
            override fun onFailure(call: Call<TVShowDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowDetail?>, response: Response<TVShowDetail?>) {
                tvShow.value = response.body()
                callback.onTVShowDetailReceived(tvShow.value!!)
            }
        })

        return tvShow
    }

    fun fetchMovieDetailCredits(movieId: String?, callback: LoadMovieDetailCreditCallback): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        val call = ApiClient.getMovieService().loadMovieCredits(movieId, API_V3_KEY)
        call.enqueue(object : Callback<MovieCredits?> {
            override fun onFailure(call: Call<MovieCredits?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieCredits?>, response: Response<MovieCredits?>) {
                movieCredits.value = response.body()
                movieCredits.value?.let { callback.onMovieDetailCreditReceived(it) }
            }
        })
        return movieCredits
    }

    fun fetchTVShowDetailCredits(tvShowId: String?, callback: LoadTVShowDetailCreditCallback): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        val call = ApiClient.getMovieService().loadTVShowCredits(tvShowId, API_V3_KEY)
        call.enqueue(object : Callback<MovieCredits?> {
            override fun onFailure(call: Call<MovieCredits?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieCredits?>, response: Response<MovieCredits?>) {
                movieCredits.value = response.body()
                movieCredits.value?.let { callback.onTVShowDetailCreditReceived(it) }
            }
        })
        return movieCredits
    }

    fun searchMovies(query: String, callback: LoadMovieSearchCallback): MutableLiveData<MutableList<MovieData>> {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        val call = ApiClient.getMovieService().searchMovie(API_V3_KEY, "en", query)
        call.enqueue(object : Callback<MovieFeeds?> {
            override fun onFailure(call: Call<MovieFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieFeeds?>, response: Response<MovieFeeds?>) {
                movieList.value = response.body()?.movieList!!
                callback.onMovieFound(movieList.value!!)
            }
        })

        return movieList
    }

    fun searchTVShows(query: String, callback: LoadTVShowSearchCallback): MutableLiveData<MutableList<TVShowData>> {
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        val call = ApiClient.getMovieService().searchTv(API_V3_KEY, "en", query)
        call.enqueue(object : Callback<TVShowFeeds?> {
            override fun onFailure(call: Call<TVShowFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowFeeds?>, response: Response<TVShowFeeds?>) {
                tvShowList.value = response.body()?.tvShowList!!
                callback.onTVShowFound(tvShowList.value!!)
            }
        })

        return tvShowList
    }

    interface LoadMoviesCallback{
        fun onAllMovieReceived(movieResponse: MutableList<MovieData>)
    }
    interface LoadMovieDetailCallback{
        fun onMovieDetailReceived(movieResponse: MovieDetail)
    }
    interface LoadMovieDetailCreditCallback{
        fun onMovieDetailCreditReceived(movieResponse: MovieCredits)
    }
    interface LoadMovieSearchCallback{
        fun onMovieFound(movieResponse: MutableList<MovieData>)
    }
    interface LoadTVShowsCallback{
        fun onAllTVShowReceived(tvShowResponses: MutableList<TVShowData>)
    }
    interface LoadTVShowDetailCallback{
        fun onTVShowDetailReceived(tvShowResponses: TVShowDetail)
    }
    interface LoadTVShowDetailCreditCallback{
        fun onTVShowDetailCreditReceived(tvShowResponses: MovieCredits)
    }
    interface LoadTVShowSearchCallback{
        fun onTVShowFound(tvShowResponses: MutableList<TVShowData>)
    }
}