package com.wildanka.moviecatalogue.remote.model.network

import com.wildanka.moviecatalogue.remote.model.entity.*
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

}