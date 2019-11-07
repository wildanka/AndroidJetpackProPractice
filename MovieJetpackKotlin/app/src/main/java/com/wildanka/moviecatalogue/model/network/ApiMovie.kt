package com.wildanka.moviecatalogue.model.network

import com.wildanka.moviecatalogue.model.entity.*
import retrofit2.Call
import retrofit2.http.*


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

    @GET("movie/{movieId}")
    fun loadMovieDetail(
        @Path("movieId") movieId: String?,
        @Query("api_key") apiKey: String
    ): Call<MovieDetail>

    @GET("tv/{tvShowId}")
    fun loadTVShowDetail(
        @Path("tvShowId") tvShowId: String?,
        @Query("api_key") apiKey: String
    ): Call<TVShowDetail>

    @GET("movie/{movieId}/credits")
    fun loadMovieCredits(
        @Path("movieId") movieId: String?,
        @Query("api_key") apiKey: String
    ): Call<MovieCredits>

    @GET("tv/{tvShowId}/credits")
    fun loadTVShowCredits(
        @Path("tvShowId") tvShowId: String?,
        @Query("api_key") apiKey: String
    ): Call<MovieCredits>

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