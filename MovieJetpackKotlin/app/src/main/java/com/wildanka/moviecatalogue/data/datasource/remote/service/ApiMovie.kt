package com.wildanka.moviecatalogue.data.datasource.remote.service

import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowFeeds
import com.wildanka.moviecatalogue.domain.entity.*
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

    @GET("search/movie")
    fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String, //en-US
        @Query("query") query: String
    ): Call<MovieFeeds>

    @GET("search/tv")
    fun searchTv(
        @Query("api_key") apiKey: String,
        @Query("language") language: String, //en-US
        @Query("query") query: String
    ): Call<TVShowFeeds>
}