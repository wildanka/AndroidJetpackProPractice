package com.wildanka.moviecatalogue.util

import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.remote.model.entity.MovieDetail
import com.wildanka.moviecatalogue.remote.model.entity.TVShowDetail
import okhttp3.internal.toImmutableList

object MovieDetailConverter{
    fun convertToTVShowFavorites(movie: MovieDetail): FavoriteMovie {
        var genreList : String? = ""
        movie.genres.forEach{
            genreList = genreList+", "+it?.genreName
        }
        return FavoriteMovie(
            movie.idMovie,
            movie.adult,
            movie.backdropPath,
            genreList,
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
        var genreList : String? = ""

        tvShow.genres.forEach{
            genreList = genreList+", "+it?.genreName
        }

        return FavoriteTVShow(
            tvShow.idMovie,
            tvShow.backdropPath,
            genreList,
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