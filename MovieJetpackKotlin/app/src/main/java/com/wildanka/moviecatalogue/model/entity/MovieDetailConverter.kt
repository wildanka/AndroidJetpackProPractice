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
    fun convertToMovieFavorites(tvShow: TVShowDetail): FavoriteTVShow{
        val genreList : String? = tvShow.genres.joinToString()
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