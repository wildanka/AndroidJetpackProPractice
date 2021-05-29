package com.wildanka.moviecatalogue.presentation.ui.movies

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModel
import com.wildanka.moviecatalogue.presentation.ui.favorites.FavoritesViewModelFactory
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieCastAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailTVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var viewModel: FavoritesViewModel

    private val tvShowCasts: MutableList<MovieCast> = mutableListOf()
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var tvShowDetail: TVShowDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        supportActionBar!!.setHomeButtonEnabled(true)
        shimmerViewContainer = shimmer_view_container
        val tvShowId: String? = intent.getStringExtra("tvShowID")

        val factory = FavoritesViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

        //load detail data
        if (tvShowId != null) {
            EspressoIdlingResource.increment()
            viewModel.getTVShowDetailWithId(tvShowId)?.observe(this, { tvShowData ->
                if (tvShowData != null) {
                    tvShowDetail = tvShowData
                    binding.tvTitle.text = tvShowData.title
                    binding.tvDetailYear.text = tvShowData.firstAirDate
                    binding.tvTagline.text = ""
                    binding.tvRatingDetail.text = getString(R.string.score_s, tvShowData.voteAverage.toString())
                    binding.tvOverview.text = tvShowData.overview
                    binding.tvDuration.text = ""
                    binding.tvPopularity.text = tvShowData.popularity
                    //load genre
                    var genresString: String? = ""
                    for (genre in tvShowData.genres) {
                        genresString = genresString + genre?.genreName + ", "
                    }
                    binding.tvGenre.text = genresString
                    Glide.with(this).load(URL_IMG_APP + tvShowData.posterPath)
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
            viewModel.getTVShowCastData(tvShowId)?.observe(this, { movieCredits ->
                shimmerViewContainer.hideShimmer()

                if (movieCredits != null) {
                    castAdapter.setupMovieCastData(movieCredits.cast)
                    for(cast in movieCredits.cast){
                        tvShowCasts.add(
                            MovieCast(
                                tvShowId,
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

            checkFavorite(tvShowId)
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
                //simpan atau remove ke favorites
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
        if (tvShowDetail != null){
            viewModel.removeFavoriteTVShowData(tvShowDetail!!)
            isFavorite = true
            setFavorite()
        }

    }

    private fun addToFavorite() {
        if (tvShowDetail != null){
            viewModel.insertFavoriteTVShowData(tvShowDetail!!)
            viewModel.insertFavoriteMovieCast(tvShowCasts)
            isFavorite = true
            setFavorite()
        }

    }

    private fun checkFavorite(tvShowId: String) {
        viewModel.checkIsFavoriteTVShow(tvShowId)?.observe(this, { movieDataLiveData ->
            if (movieDataLiveData != null) {
                isFavorite = true
                setFavorite()
            }
        })
    }
}
