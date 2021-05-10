package com.wildanka.moviecatalogue.presentation.ui.favorites

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.wildanka.moviecatalogue.BuildConfig
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

private const val TYPE_MOVIE = "MOVIE"
private const val TYPE_TV_SHOW = "TV_SHOW"
class FavoritesDetailActivity : AppCompatActivity() {
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var movieDetail: FavoriteMovie? = null
    private var tvShowDetail: FavoriteTVShow? = null
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setHomeButtonEnabled(true)
        shimmerViewContainer = shimmer_view_container
        val movieId: String? = intent.getStringExtra("movieID")
        val tvShowId: String? = intent.getStringExtra("tvShowID")
        type = intent.getStringExtra("dataType")
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

        val factory = FavoritesViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

        if (type == TYPE_MOVIE) {
            //TODO : delete the logs
            movieId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            movieId?.let {
                viewModel.getFavoriteMoviesDetails(it)?.observe(this, Observer {
                    if (it != null) {
                        movieDetail = it
                        tvTitle.text = it.title
                        tvYear.text = it.releaseDate
                        tvTagline.text = it.tagline
                        tvRating.text = getString(R.string.score_s, it.voteAverage.toString())
                        tvOverview.text = it.overview
                        tvDuration.text = getString(R.string.duration_s_min, it.duration.toString())
                        tvPopularity.text = it.popularity
                        //load genre
                        tvGenre.text = it.genres
                        Glide.with(this).load(BuildConfig.URL_IMG_APP + it.posterPath).into(ivMoviePosterDetail)
                    }
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
                })
            }

            //load cast data
            val castAdapter =
                MovieCastAdapter()
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getMoviesCastData(movieId)?.observe(this, Observer { movieCreadits ->
                shimmerViewContainer.hideShimmer()
                if (movieCreadits != null) {
                    castAdapter.setupMovieCastData(movieCreadits.cast)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            if (movieId != null) {
                checkFavorite(movieId)
            }
        }else{
            //TODO : delete the logs
            tvShowId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            tvShowId?.let {
                viewModel.getFavoriteTVShowDetails(it)?.observe(this, Observer { tvShowDetails ->
                    if (tvShowDetails != null) {
                        tvShowDetail = tvShowDetails
                        tvTitle.text = tvShowDetails.title
                        tvYear.text = tvShowDetails.firstAirDate
                        tvTagline.text = ""
                        tvRating.text = getString(R.string.score_s, tvShowDetails.voteAverage.toString())
                        tvOverview.text = tvShowDetails.overview
                        tvDuration.text = ""
                        tvPopularity.text = tvShowDetails.popularity
                        tvGenre.text = tvShowDetails.genres
                        Glide.with(this).load(BuildConfig.URL_IMG_APP + tvShowDetails.posterPath).into(ivMoviePosterDetail)
                    }
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
                })
            }

            //region cast data
            val castAdapter =
                MovieCastAdapter()
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getTVShowCastData(tvShowId)?.observe(this, Observer { movieCreadits ->
                shimmerViewContainer.hideShimmer()

                if (movieCreadits != null) {
                    castAdapter.setupMovieCastData(movieCreadits.cast)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })
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
        return when (item.itemId){
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
        when (type) {
            TYPE_MOVIE -> {
                Log.e("removeFromMOVIEFavorite", "${movieDetail?.idMovie} - ${movieDetail?.title}")
                viewModel.removeFavoriteMovie(movieDetail!!)
                isFavorite = true
                setFavorite()
            }
            TYPE_TV_SHOW -> {
                Log.e("removeFromTVFavorite", "${tvShowDetail?.idTVShow} - ${tvShowDetail?.title}")
                viewModel.removeFavoriteTVShow(tvShowDetail!!)
                isFavorite = true
                setFavorite()
            }
            else -> {
                Log.e("removeFromFavorite", "WUUT?")

            }
        }
    }
    private fun addToFavorite(){
        when (type) {
            TYPE_MOVIE -> {
                Log.e("addTOFavoritesMOVIE", "${movieDetail?.idMovie} - ${movieDetail?.title}")
                viewModel.insertFavoriteMovie(movieDetail!!)
                isFavorite = true
                setFavorite()
            }
            TYPE_TV_SHOW -> {
                Log.e("addTOFavoritesTVSHOW", "${tvShowDetail?.idTVShow} - ${tvShowDetail?.title}")
                viewModel.insertFavoriteTVShow(tvShowDetail!!)
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
                viewModel.checkIsFavorite(movieOrTVShowId)?.observe(this, Observer { movieDataLiveData ->
                    if (movieDataLiveData != null) {
                        isFavorite = true
                        setFavorite()
                    }
                })
            }
            TYPE_TV_SHOW -> {
                Log.e("checkFavorite(TVShow)", "${tvShowDetail?.idTVShow} - ${tvShowDetail?.title}")
                viewModel.checkIsFavoriteTVShow(movieOrTVShowId)?.observe(this, Observer { movieDataLiveData ->
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
