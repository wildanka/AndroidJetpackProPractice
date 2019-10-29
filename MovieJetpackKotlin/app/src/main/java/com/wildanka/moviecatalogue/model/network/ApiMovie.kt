package com.wildanka.moviecatalogue.model.network

import com.wildanka.moviecatalogue.model.entity.Movie
import com.wildanka.moviecatalogue.model.entity.MovieFeeds
import com.wildanka.moviecatalogue.model.entity.TVShowFeeds
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMovie {
    @GET("discover/movie")
    fun loadMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String //en-US
    ): Call<MovieFeeds>

    @GET("discover/tv")
    fun loadTVShowList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String //en-US
    ): Call<TVShowFeeds>


    @GET("t/p/{POSTER_SIZE}/POSTER_FILENAME")
    fun loadMovieImages(
        @Path("POSTER_SIZE") posterSize: String,
        @Path("POSTER_FILENAME") posterFilename: String
    ): Call<Movie>


    @GET("search/movie")
    fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String, //en-US
        @Query("query") searchQuery: String
    ): Call<MovieFeeds>

    @GET("search/tv")
    fun searchTVShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String, //en-US
        @Query("query") searchQuery: String
    ): Call<TVShowFeeds>
}