package com.wildanka.moviecatalogue.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.wildanka.moviecatalogue.MoviesRepository;
import com.wildanka.moviecatalogue.model.db.FavoritesRepository;
import com.wildanka.moviecatalogue.model.entity.MovieCredits;
import com.wildanka.moviecatalogue.model.entity.MovieData;
import com.wildanka.moviecatalogue.model.entity.MovieDetail;
import com.wildanka.moviecatalogue.model.entity.TVShowDetail;

import java.util.List;

public class FavViewModel extends AndroidViewModel {
    private FavoritesRepository favoritesRepository;
    private MoviesRepository repo;
    private LiveData<MovieData> favoriteMovieLiveData;

    public FavViewModel(@NonNull Application application) {
        super(application);
        favoritesRepository = new FavoritesRepository(application);
        repo = new MoviesRepository();
    }

    //region local
    public LiveData<MovieData> checkIsFavorite(String movieID) {
        favoriteMovieLiveData = favoritesRepository.getFavoriteMoviesDetails(movieID);
        return favoriteMovieLiveData;
    }

    public LiveData<List<MovieData>> getAllFavoritesMovies() {
        return favoritesRepository.getAllFavoriteMovies();
    }

    public void insertFavoriteMovieData(MovieData movie) {
        favoritesRepository.addToFavoriteMovies(movie);
    }

    public void removeFavoriteMovieData(MovieData movie) {
        favoritesRepository.removeFromFavoriteMovies(movie);
    }
    //endregion local

    //region online
    private MutableLiveData<MovieDetail> movieDetail;
    private MutableLiveData<MovieCredits> movieCredits;
    private MutableLiveData<TVShowDetail> tvShowDetail;

    public MutableLiveData<MovieDetail> getMoviesDetailWithID(String movieId) {
        if (movieDetail == null) movieDetail = repo.fetchMovieDataDetail(movieId);
        return movieDetail;
    }

    public MutableLiveData<MovieCredits> getMoviesCastData(String movieId) {
        if (movieCredits == null) movieCredits = repo.fetchMovieDetailCredits(movieId);
        return movieCredits;
    }

    public MutableLiveData<TVShowDetail> getTVShowDetailWithId(String tvShowId) {
        if (tvShowDetail == null) tvShowDetail = repo.fetchTvShowDataDetail(tvShowId);
        return tvShowDetail;
    }

    public MutableLiveData<MovieCredits> getTVShowCastData(String tvShowId) {
        if (movieCredits == null) movieCredits = repo.fetchTVShowDetailCredits(tvShowId);
        return movieCredits;
    }
    //endregion online
}
