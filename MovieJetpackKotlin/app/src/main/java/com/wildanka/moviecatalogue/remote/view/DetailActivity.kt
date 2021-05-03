package com.wildanka.moviecatalogue.remote.view

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
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.favorite.viewmodel.FavoritesViewModel
import com.wildanka.moviecatalogue.remote.model.entity.MovieDetail
import com.wildanka.moviecatalogue.remote.model.entity.TVShowDetail
import com.wildanka.moviecatalogue.remote.view.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private val TYPE_MOVIE = "MOVIE"
    private val TYPE_TV_SHOW = "TV_SHOW"

    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var movieDetail: MovieDetail? = null
    private var tvShowDetail: TVShowDetail? = null
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
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
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        if (type == TYPE_MOVIE) {
            //TODO : remove logger
            movieId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getMoviesDetailWithID(movieId)?.observe(this, Observer { movieDetails ->
                if (movieDetails != null) {
                    movieDetail = movieDetails
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
            val castAdapter = MovieCastAdapter()
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
            //TODO : remove logger
            movieId?.let { Log.e("DetailActivity", it) }
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getTVShowDetailWithId(tvShowId)?.observe(this, Observer { tvShowDetails ->
                if (tvShowDetails != null) {
                    tvShowDetail = tvShowDetails
                    tvTitle.text = tvShowDetails.title
                    tvYear.text = tvShowDetails.firstAirDate
                    tvTagline.text = ""
                    tvRating.text = getString(R.string.score_s, tvShowDetails.voteAverage.toString())
                    tvOverview.text = tvShowDetails.overview
                    tvDuration.text = ""
                    tvPopularity.text = tvShowDetails.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in tvShowDetails.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + tvShowDetails.posterPath).into(ivMoviePosterDetail)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })

            //region cast data
            val castAdapter = MovieCastAdapter()
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
    private fun addToFavorite(){
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
                viewModel.checkIsFavorite(movieOrTVShowId)?.observe(this, Observer { movieDataLiveData ->
                    if (movieDataLiveData != null) {
                        isFavorite = true
                        setFavorite()
                    }
                })
            }
            TYPE_TV_SHOW -> {
                Log.e("checkFavorite(TVShow)", "${tvShowDetail?.idMovie} - ${tvShowDetail?.title}")
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
