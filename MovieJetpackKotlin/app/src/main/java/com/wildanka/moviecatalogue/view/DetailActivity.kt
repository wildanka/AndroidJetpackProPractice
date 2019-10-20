package com.wildanka.moviecatalogue.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wildanka.moviecatalogue.R

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

        if (type == "MOVIE"){
            val dataPoster = resources.obtainTypedArray(R.array.data_poster)
            tvTitle.text = resources.getStringArray(R.array.data_title)[index]
            tvYear.text = resources.getStringArray(R.array.data_year)[index]
            tvRating.text = resources.getStringArray(R.array.data_rating)[index]
            tvOverview.text = resources.getStringArray(R.array.data_ov)[index]
            ivMoviePosterDetail.setImageResource(dataPoster.getResourceId(index, 0))
            dataPoster.recycle() //recycle obatinTypedArray after being used
        }else{
            val dataPoster = resources.obtainTypedArray(R.array.tv_data_poster)
            tvTitle.text = resources.getStringArray(R.array.tv_data_title)[index]
            tvYear.text = resources.getStringArray(R.array.tv_data_year)[index]
            tvRating.text = resources.getStringArray(R.array.tv_data_rating)[index]
            tvOverview.text = resources.getStringArray(R.array.tv_data_ov)[index]
            ivMoviePosterDetail.setImageResource(dataPoster.getResourceId(index, 0))
            dataPoster.recycle() //recycle obatinTypedArray after being used
        }
    }
}
