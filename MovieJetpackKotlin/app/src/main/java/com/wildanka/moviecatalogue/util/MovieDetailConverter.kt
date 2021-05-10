package com.wildanka.moviecatalogue.util

import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.domain.entity.TVShowDetail

object MovieDetailConverter{
    fun convertToTVShowFavorites(movie: MovieDetail): FavoriteMovie {
        val genreList: MutableList<String> = mutableListOf()
        movie.genres.forEachIndexed { _, genre ->
            genreList.add(genre?.genreName.toString())
        }

        return FavoriteMovie(
            movie.idMovie,
            movie.adult,
            movie.backdropPath,
            genreList.joinToString(),
            movie.homePageUrl,
            movie.originalLanguage,
            movie.overview,
            movie.popularity,
            movie.posterPath,
            movie.releaseDate,
            movie.revenue,
            movie.duration,
            movie.status,
            movie.tagline,
            movie.title,
            movie.voteAverage,
            movie.voteCount
        )
    }
    fun convertToTVShowFavorites(tvShow: TVShowDetail): FavoriteTVShow {
        val genreList: MutableList<String> = mutableListOf()
        tvShow.genres.forEachIndexed { _, genre ->
            genreList.add(genre?.genreName.toString())
        }

        return FavoriteTVShow(
            tvShow.idMovie,
            tvShow.backdropPath,
            genreList.joinToString(),
            tvShow.homePageUrl,
            tvShow.originalLanguage,
            tvShow.overview,
            tvShow.popularity,
            tvShow.posterPath,
            tvShow.firstAirDate,
            tvShow.lastAirDate,
            tvShow.revenue,
            tvShow.duration,
            tvShow.status,
            tvShow.tagline,
            tvShow.title,
            tvShow.voteAverage,
            tvShow.voteCount
        )
    }
}