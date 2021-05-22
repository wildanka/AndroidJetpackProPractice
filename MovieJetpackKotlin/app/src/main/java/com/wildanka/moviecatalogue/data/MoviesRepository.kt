package com.wildanka.moviecatalogue.data

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.BuildConfig.API_V3_KEY
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowFeeds
import com.wildanka.moviecatalogue.data.datasource.remote.RemoteDataSource
import com.wildanka.moviecatalogue.data.datasource.remote.service.ApiMovie
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.domain.entity.MovieFeeds
import com.wildanka.moviecatalogue.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    companion object {
        @Volatile
        private var instance: MoviesRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource
        ): MoviesRepository =
            instance ?: synchronized(this) {
                MoviesRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    private val placeHolderApi: ApiMovie = ApiClient.createService(
        ApiMovie::class.java
    )

    override fun fetchMovieData(): MutableLiveData<MutableList<MovieData>> {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        remoteDataSource.fetchMovieData(object: RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: MutableList<MovieData>) {
                movieList.value = movieResponse
            }
        })
        return movieList
    }

    override fun fetchMovieDataDetail(movieId: String): MutableLiveData<MovieDetail> {
        val movie = MutableLiveData<MovieDetail>()
        remoteDataSource.fetchMovieDataDetail(movieId, object: RemoteDataSource.LoadMovieDetailCallback{
            override fun onMovieDetailReceived(movieResponse: MovieDetail) {
                movie.value = movieResponse
            }
        })
        return movie
    }

    override fun fetchMovieDetailCredits(movieId: String): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        remoteDataSource.fetchMovieDetailCredits(movieId, object: RemoteDataSource.LoadMovieDetailCreditCallback{
            override fun onMovieDetailCreditReceived(movieResponse: MovieCredits) {
                movieCredits.value = movieResponse
            }
        })
        return movieCredits
    }

    override fun fetchTVShowData(): MutableLiveData<MutableList<TVShowData>> {
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        remoteDataSource.fetchTVShowData(object : RemoteDataSource.LoadTVShowsCallback {
            override fun onAllTVShowReceived(tvShowResponses: MutableList<TVShowData>) {
                tvShowList.value = tvShowResponses
            }
        })
        return tvShowList
    }

    override fun fetchTvShowDataDetail(tvShowId: String): MutableLiveData<TVShowDetail> {
        val tvShow = MutableLiveData<TVShowDetail>()
        remoteDataSource.fetchTvShowDataDetail(tvShowId, object: RemoteDataSource.LoadTVShowDetailCallback{
            override fun onTVShowDetailReceived(tvShowResponses: TVShowDetail) {
                tvShow.value = tvShowResponses
            }
        })
        return tvShow
    }

    override fun fetchTVShowDetailCredits(tvShowId: String): MutableLiveData<MovieCredits> {
        val movieCredits = MutableLiveData<MovieCredits>()
        remoteDataSource.fetchTVShowDetailCredits(tvShowId, object: RemoteDataSource.LoadTVShowDetailCreditCallback{
            override fun onTVShowDetailCreditReceived(tvShowResponses: MovieCredits) {
                movieCredits.value = tvShowResponses
            }

        })
        return movieCredits
    }

    override fun searchMovies(query: String): MutableLiveData<MutableList<MovieData>> {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        val call = placeHolderApi.searchMovie(API_V3_KEY, "en", query)
        call.enqueue(object : Callback<MovieFeeds?> {
            override fun onFailure(call: Call<MovieFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieFeeds?>, response: Response<MovieFeeds?>) {
                movieList.value = response.body()?.movieList!!
            }
        })

        return movieList
    }

    override fun searchTVShows(query: String): MutableLiveData<MutableList<TVShowData>> {
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        val call = placeHolderApi.searchTv(API_V3_KEY, "en", query)
        call.enqueue(object : Callback<TVShowFeeds?> {
            override fun onFailure(call: Call<TVShowFeeds?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowFeeds?>, response: Response<TVShowFeeds?>) {
                tvShowList.value = response.body()?.tvShowList!!
            }
        })

        return tvShowList
    }

}