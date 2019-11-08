package com.wildanka.moviecatalogue.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.view.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.viewmodel.MoviesDetailViewModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
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
        val viewModel = ViewModelProviders.of(this).get(MoviesDetailViewModel::class.java)

        if (type == "MOVIE"){
            Log.e("DetailActivity", movieId)
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getMoviesDetailWithID(movieId)?.observe(this, Observer { movieDetails ->
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
            val castAdapter = MovieCastAdapter(this)
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getMoviesCastData(movieId)?.observe(this, Observer { movieCreadits ->
                if (movieCreadits != null) {
                    castAdapter.setupMovieCastData(movieCreadits.casts)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })
        }else{
            Log.e("DetailActivity", tvShowId)
            //load detail data
            EspressoIdlingResource.increment()
            viewModel.getTVShowDetailWithId(tvShowId)?.observe(this, Observer { tvShowData ->
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
            val castAdapter = MovieCastAdapter(this)
            rvCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvCast.adapter = castAdapter

            EspressoIdlingResource.increment()
            viewModel.getTVShowCastData(tvShowId)?.observe(this, Observer { movieCreadits ->
                if (movieCreadits != null) {
                    castAdapter.setupMovieCastData(movieCreadits.casts)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            })
        }
    }
}
