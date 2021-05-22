package com.wildanka.moviecatalogue.presentation.ui.movies

import android.os.Bundle
import android.util.Log
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
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.databinding.ActivityDetailBinding
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModel
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModelFactory
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

private const val TYPE_MOVIE = "MOVIE"
private const val TYPE_TV_SHOW = "TV_SHOW"

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var movieDetail: MovieDetail? = null
    private var tvShowDetail: TVShowDetail? = null
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        shimmerViewContainer = shimmer_view_container
        val movieId: String? = intent.getStringExtra("movieID")
        val tvShowId: String? = intent.getStringExtra("tvShowID")
        type = intent.getStringExtra("dataType")

        val factory = FavoritesViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

        if (type == TYPE_MOVIE) {
            //TODO : remove logger
            movieId?.let { Log.e("DetailActivity", it) }
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
            }

            //load cast data
            val castAdapter =
                MovieCastAdapter()
            binding.rvMovieCasts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvMovieCasts.adapter = castAdapter

            if(movieId != null){
                EspressoIdlingResource.increment()
                viewModel.getMoviesCastData(movieId)?.observe(this, { movieCredits ->
                    shimmerViewContainer.hideShimmer()
                    if (movieCredits != null) {
                        castAdapter.setupMovieCastData(movieCredits.cast)
                    }
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
                })
            }

            if (movieId != null) {
                checkFavorite(movieId)
            }
        } else {
            //TODO : remove logger
            tvShowId?.let { Log.e("DetailActivity", it) }
            //load detail data
            if(tvShowId != null){
                EspressoIdlingResource.increment()
                viewModel.getTVShowDetailWithId(tvShowId)?.observe(this, { tvShowDetails ->
                    if (tvShowDetails != null) {
                        tvShowDetail = tvShowDetails
                        binding.tvTitle.text = tvShowDetails.title
                        binding.tvDetailYear.text = tvShowDetails.firstAirDate
                        binding.tvTagline.text = ""
                        binding.tvRatingDetail.text =
                            getString(R.string.score_s, tvShowDetails.voteAverage.toString())
                        binding.tvOverview.text = tvShowDetails.overview
                        binding.tvDuration.text = ""
                        binding.tvPopularity.text = tvShowDetails.popularity
                        //load genre
                        var genresString: String? = ""
                        for (genre in tvShowDetails.genres) {
                            genresString = genresString + genre?.genreName + ", "
                        }
                        binding.tvGenre.text = genresString
                        Glide.with(this).load(URL_IMG_APP + tvShowDetails.posterPath)
                            .into(binding.ivMoviePosterDetail)
                    }
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
                })
            }

            //region cast data
            val castAdapter =
                MovieCastAdapter()
            binding.rvMovieCasts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvMovieCasts.adapter = castAdapter

            if(tvShowId != null){
                EspressoIdlingResource.increment()
                viewModel.getTVShowCastData(tvShowId)?.observe(this, { movieCredits ->
                    shimmerViewContainer.hideShimmer()

                    if (movieCredits != null) {
                        castAdapter.setupMovieCastData(movieCredits.cast)
                    }
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
                })
            }
            //endregion cast data

            if (tvShowId != null) {
                checkFavorite(tvShowId)
            }
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
                //buat simpan atau remove ke favorites
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                Toast.makeText(this, "Favorites Button Touched", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
        else
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
    }

    private fun removeFromFavorite() {
        when (type) {
            TYPE_MOVIE -> {
                Log.e("removeFromMOVIEFavorite", "${movieDetail?.idMovie} - ${movieDetail?.title}")
                viewModel.removeFavoriteMovieData(movieDetail!!)
                isFavorite = true
                setFavorite()
            }
            TYPE_TV_SHOW -> {
                Log.e("removeFromTVFavorite", "${tvShowDetail?.idMovie} - ${tvShowDetail?.title}")
                viewModel.removeFavoriteTVShowData(tvShowDetail!!)
                isFavorite = true
                setFavorite()
            }
            else -> {
                Log.e("removeFromFavorite", "WUUT?")

            }
        }
    }

    private fun addToFavorite() {
        when (type) {
            TYPE_MOVIE -> {
                Log.e("addTOFavoritesMOVIE", "${movieDetail?.idMovie} - ${movieDetail?.title}")
                viewModel.insertFavoriteMovieData(movieDetail!!)
                isFavorite = true
                setFavorite()
            }
            TYPE_TV_SHOW -> {
                Log.e("addTOFavoritesTVSHOW", "${tvShowDetail?.idMovie} - ${tvShowDetail?.title}")
                viewModel.insertFavoriteTVShowData(tvShowDetail!!)
                isFavorite = true
                setFavorite()
            }
            else -> {
                Log.e("addToFavorite", "WUUT?")
            }
        }
    }

    private fun checkFavorite(movieOrTVShowId: String) {
        Log.e("checkFavorite", "dataType $type")
        when (type) {
            TYPE_MOVIE -> {
                Log.e("checkFavorite(Movie)", "$movieOrTVShowId ")
                viewModel.checkIsFavorite(movieOrTVShowId)?.observe(this, { movieDataLiveData ->
                    if (movieDataLiveData != null) {
                        isFavorite = true
                        setFavorite()
                    }
                })
            }
            TYPE_TV_SHOW -> {
                Log.e("checkFavorite(TVShow)", "${tvShowDetail?.idMovie} - ${tvShowDetail?.title}")
                viewModel.checkIsFavoriteTVShow(movieOrTVShowId)
                    ?.observe(this, { movieDataLiveData ->
                        if (movieDataLiveData != null) {
                            isFavorite = true
                            setFavorite()
                        }
                    })
            }
            else -> {
                Log.e("checkFavorite", "WUUT?")
            }
        }

    }
}
