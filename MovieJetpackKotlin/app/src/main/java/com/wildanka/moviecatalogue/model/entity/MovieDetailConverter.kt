package com.wildanka.moviecatalogue.model.entity

object MovieDetailConverter{
    fun convertToMovieFavorites(movie: MovieDetail): FavoriteMovie{
        val genreList : String? = movie.genres.joinToString()
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
}