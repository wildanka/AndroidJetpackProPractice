package com.wildanka.moviecatalogue.presentation.ui.movies

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieCast
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.databinding.ActivityDetailBinding
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModel
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModelFactory
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var movieDetail: MovieDetail? = null
    private val movieCasts: MutableList<MovieCast> = mutableListOf()
    private var tvShowDetail: TVShowDetail? = null
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        shimmerViewContainer = shimmer_view_container
        val movieId: String? = intent.getStringExtra("movieID")
        type = intent.getStringExtra("dataType")

        val factory = FavoritesViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

        //load detail data
        if(movieId != null){
            EspressoIdlingResource.increment()
            viewModel.getMoviesDetailWithID(movieId)?.observe(this, { movieDetails ->
                if (movieDetails != null) {
                    movieDetail = movieDetails
                    binding.tvTitle.text = movieDetails.title
                    binding.tvDetailYear.text = movieDetails.releaseDate
                    if (movieDetails.tagline != null){
                        if (movieDetails.tagline.isEmpty()){
                            binding.tvTagline.visibility = View.GONE
                        }else{
                            binding.tvTagline.text = movieDetails.tagline
                        }
                    }else{
                        binding.tvTagline.visibility = View.GONE
                    }
                    binding.tvRatingDetail.text = getString(R.string.score_s, movieDetails.voteAverage.toString())
                    binding.tvOverview.text = movieDetails.overview
                    binding.tvDuration.text =
                        getString(R.string.duration_s_min, movieDetails.duration.toString())
                    binding.tvPopularity.text = movieDetails.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in movieDetails.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    binding.tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + movieDetails.posterPath)
                        .into(binding.ivMoviePosterDetail)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            //load cast data
            val castAdapter =
                MovieCastAdapter()
            binding.rvMovieCasts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvMovieCasts.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getMoviesCastData(movieId)?.observe(this, { movieCredits ->
                shimmerViewContainer.hideShimmer()
                if (movieCredits != null) {
                    castAdapter.setupMovieCastData(movieCredits.cast)
                    for(cast in movieCredits.cast){
                        movieCasts.add(
                            MovieCast(
                                movieId,
                                cast.creditId,
                                cast.castId,
                                cast.character,
                                cast.gender,
                                cast.id,
                                cast.name,
                                cast.order,
                                cast.profilePath
                            )
                        )
                    }
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            checkFavorite(movieId)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorites, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.favorites_toggle -> {
                if (movieDetail == null && tvShowDetail == null){
                    removeFromFavorite()
                    return false
                }
                //buat simpan atau remove ke favorites
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setFavorite() {
        if (isFavorite) {
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
            Toast.makeText(this, "Saved to Favorite", Toast.LENGTH_SHORT).show()
        } else {
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
            Toast.makeText(this, "Removed from Favorite", Toast.LENGTH_SHORT).show()
        }
    }

    private fun removeFromFavorite() {
        if (movieDetail != null){
            viewModel.removeFavoriteMovieData(movieDetail!!)
            isFavorite = true
            setFavorite()
        }
    }

    private fun addToFavorite() {
        if (movieDetail != null){
            viewModel.insertFavoriteMovieData(movieDetail!!)
            viewModel.insertFavoriteMovieCast(movieCasts)
            isFavorite = true
            setFavorite()
        }
    }

    private fun checkFavorite(movieOrTVShowId: String) {
        viewModel.checkIsFavorite(movieOrTVShowId)?.observe(this, { movieDataLiveData ->
            if (movieDataLiveData != null) {
                isFavorite = true
                setFavorite()
            }
        })
    }
}
