package com.wildanka.moviecatalogue.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.wildanka.moviecatalogue.BuildConfig.URL_IMG_APP
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.viewmodel.MoviesDetailViewModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        val movieId: String? = intent.getStringExtra("movieID")
        val type= intent.getStringExtra("dataType")
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvTagline = findViewById<TextView>(R.id.tv_tagline)
        val tvYear = findViewById<TextView>(R.id.tv_detail_year)
        val tvRating = findViewById<TextView>(R.id.tv_rating_detail)
        val tvDuration = findViewById<TextView>(R.id.tv_duration)
        val tvPopularity = findViewById<TextView>(R.id.tv_popularity)
        val tvOverview = findViewById<TextView>(R.id.tv_overview)
        val tvGenre = findViewById<TextView>(R.id.tv_genre)
        val ivMoviePosterDetail = findViewById<ImageView>(R.id.iv_movie_poster_detail)
        val viewModel = ViewModelProviders.of(this).get(MoviesDetailViewModel::class.java)

        if (type == "MOVIE"){
            Log.e("DetailActivity", movieId)
            //load detail data
            viewModel.getMoviesAtIndex(movieId)?.observe(this, Observer { movieDetails ->
                if (movieDetails != null) {
                    tvTitle.text = movieDetails.title
                    tvYear.text = movieDetails.releaseDate
                    tvTagline.text = movieDetails.tagline
                    tvRating.text = movieDetails.voteAverage.toString()
                    tvOverview.text = movieDetails.overview
                    tvDuration.text = "${movieDetails.duration.toString()} min."
                    tvPopularity.text = movieDetails.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in movieDetails.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + movieDetails.posterPath).into(ivMoviePosterDetail)
                }
            })

            //load cast data

//            val selectedMovie = viewModel.getMoviesAtIndex(index)
//            tvTitle.text = selectedMovie?.title
//            tvYear.text = selectedMovie?.releaseDate
//            tvRating.text = selectedMovie?.rating
//            tvOverview.text = selectedMovie?.overview
//            ivMoviePosterDetail.setImageResource(selectedMovie?.posterUrl!!)
        }else{
//            val selectedTVShow= viewModel.getTVShowAtIndex(index)
//            tvTitle.text = selectedTVShow?.title
//            tvYear.text = selectedTVShow?.releaseDate
//            tvRating.text = selectedTVShow?.rating
//            tvOverview.text = selectedTVShow?.overview
//            ivMoviePosterDetail.setImageResource(selectedTVShow?.posterUrl!!)
        }
    }
}
