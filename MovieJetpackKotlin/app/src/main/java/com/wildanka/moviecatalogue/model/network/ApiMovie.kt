package com.wildanka.moviecatalogue.model.network

import android.graphics.Movie
import com.wildanka.moviecatalogue.model.entity.*
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

   @GET("discover/movie")
    fun loadMovieData(
        @Query("api_key") apiKey: String,
        @Query("language") language: String //en-US
    ): Call<MovieData>

    @GET("discover/tv")
    fun loadTVShowData(
        @Query("api_key") apiKey: String,
        @Query("language") language: String //en-US
    ): Call<TVShowData>


    @GET("t/p/{POSTER_SIZE}/POSTER_FILENAME")
    fun loadMovieImages(
        @Path("POSTER_SIZE") posterSize: String,
        @Path("POSTER_FILENAME") posterFilename: String
    ): Call<MovieData>


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