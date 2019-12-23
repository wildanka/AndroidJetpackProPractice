package com.wildanka.moviecatalogue.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.view.adapter.FavoriteMoviesAdapter
import com.wildanka.moviecatalogue.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.viewmodel.FavoritesViewModel
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel

class FavoritesMovieFragment : Fragment() {
    private lateinit var srlMovies: SwipeRefreshLayout
    private lateinit var pbMovies: ProgressBar
    private lateinit var rvMovie: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMovie = view.findViewById(R.id.rv_movie)
        pbMovies = view.findViewById(R.id.pb_movies)
        srlMovies = view.findViewById(R.id.srl_movies)
        pbMovies.visibility = View.VISIBLE

        val viewModel = ViewModelProviders.of(this).get(FavoritesViewModel::class.java)
        val rvAdapter = FavoriteMoviesAdapter()
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        viewModel.getAllFavoritesMovies()?.observe(this, Observer {
            rvAdapter.setupFavoriteMoviesData(it)
            pbMovies.visibility = View.INVISIBLE
        })
        super.onViewCreated(view, savedInstanceState)
    }

}
