package com.wildanka.moviecatalogue.presentation.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModel
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailTVShowActivity : AppCompatActivity() {
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        shimmerViewContainer = shimmer_view_container
        val movieId: String? = intent.getStringExtra("movieID")
        val tvShowId: String? = intent.getStringExtra("tvShowID")
        val type= intent.getStringExtra("dataType")
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvTagline = findViewById<TextView>(R.id.tv_tagline)
        val tvYear = findViewById<TextView>(R.id.tv_detail_year)
        val tvRating = findViewById<TextView>(R.id.tv_rating_detail)
        val tvDuration = findViewById<TextView>(R.id.tv_duration)
        val tvPopularity = findViewById<TextView>(R.id.tv_popularity)
        val tvOverview = findViewById<TextView>(R.id.tv_overview)
        val tvGenre = findViewById<TextView>(R.id.tv_genre)
        val rvCast = findViewById<RecyclerView>(R.id.rv_movie_casts)
        val ivMoviePosterDetail = findViewById<ImageView>(R.id.iv_movie_poster_detail)
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        if (type == "MOVIE"){
            // TODO : remove logger
            movieId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getMoviesDetailWithID(movieId)?.observe(this, { movieDetails ->
                if (movieDetails != null) {
                    tvTitle.text = movieDetails.title
                    tvYear.text = movieDetails.releaseDate
                    tvTagline.text = movieDetails.tagline
                    tvRating.text = getString(R.string.score_s, movieDetails.voteAverage.toString())
                    tvOverview.text = movieDetails.overview
                    tvDuration.text = getString(R.string.duration_s_min, movieDetails.duration.toString())
                    tvPopularity.text = movieDetails.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in movieDetails.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + movieDetails.posterPath).into(ivMoviePosterDetail)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            //load cast data
            val castAdapter =
                MovieCastAdapter()
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getMoviesCastData(movieId)?.observe(this, { movieCredits ->
                shimmerViewContainer.hideShimmer()
                if (movieCredits != null) {
                    castAdapter.setupMovieCastData(movieCredits.cast)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            if (movieId != null) {
                checkFavorite(movieId)
            }
        }else{
            // TODO : remove logger
            movieId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getTVShowDetailWithId(tvShowId)?.observe(this, { tvShowData ->
                if (tvShowData != null) {
                    tvTitle.text = tvShowData.title
                    tvYear.text = tvShowData.firstAirDate
                    tvTagline.text = ""
                    tvRating.text = getString(R.string.score_s, tvShowData.voteAverage.toString())
                    tvOverview.text = tvShowData.overview
                    tvDuration.text = ""
                    tvPopularity.text = tvShowData.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in tvShowData.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + tvShowData.posterPath).into(ivMoviePosterDetail)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            //load cast data
            val castAdapter =
                MovieCastAdapter()
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getTVShowCastData(tvShowId)?.observe(this, { movieCredits ->
                shimmerViewContainer.hideShimmer()

                if (movieCredits != null) {
                    castAdapter.setupMovieCastData(movieCredits.cast)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorites, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            R.id.favorites_toggle -> {
                //simpan atau remove ke favorites
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                Toast.makeText(this, "Favorites Button Touched", Toast.LENGTH_SHORT).show()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
    }

    private fun removeFromFavorite(){

    }
    private fun addToFavorite(){

    }

    private fun checkFavorite(movieId: String) {
        viewModel.checkIsFavorite(movieId)?.observe(this, { movieDataLiveData ->
            if (movieDataLiveData != null) {
                isFavorite = true
                setFavorite()
            }
        })
    }
}
