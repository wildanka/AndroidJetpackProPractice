package com.wildanka.moviecatalogue.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.viewmodel.MoviesDetailViewModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        val index = intent.getIntExtra("index", 0)
        val type= intent.getStringExtra("dataType")
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvYear = findViewById<TextView>(R.id.tv_detail_year)
        val tvRating = findViewById<TextView>(R.id.tv_rating_detail)
        val tvOverview = findViewById<TextView>(R.id.tv_overview)
        val ivMoviePosterDetail = findViewById<ImageView>(R.id.iv_movie_poster_detail)
        val viewModel = ViewModelProviders.of(this).get(MoviesDetailViewModel::class.java)

        if (type == "MOVIE"){
            val selectedMovie = viewModel.getMoviesAtIndex(index)
            tvTitle.text = selectedMovie?.title
            tvYear.text = selectedMovie?.releaseDate
            tvRating.text = selectedMovie?.rating
            tvOverview.text = selectedMovie?.overview
            ivMoviePosterDetail.setImageResource(selectedMovie?.posterUrl!!)
        }else{
            val selectedTVShow= viewModel.getTVShowAtIndex(index)
            tvTitle.text = selectedTVShow?.title
            tvYear.text = selectedTVShow?.releaseDate
            tvRating.text = selectedTVShow?.rating
            tvOverview.text = selectedTVShow?.overview
            ivMoviePosterDetail.setImageResource(selectedTVShow?.posterUrl!!)
        }
    }
}
