package com.wildanka.moviecatalogue.presentation.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource

class MovieFragment : Fragment() {
    private lateinit var srlMovies: SwipeRefreshLayout
    private lateinit var pbMovies: ProgressBar
    private lateinit var rvMovie: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMovie = view.findViewById(R.id.rv_movie)
        pbMovies = view.findViewById(R.id.pb_movies)
        srlMovies = view.findViewById(R.id.srl_movies)
        pbMovies.visibility = View.VISIBLE

        val viewModel = ViewModelProvider(this).get(MainMoviesViewModel::class.java)
        val rvAdapter = MovieRVAdapter()
        rvMovie.layoutManager = LinearLayoutManager(activity)
        rvMovie.adapter = rvAdapter

        // Get Data dari API
        observeData(viewModel, rvAdapter)
        srlMovies.setOnRefreshListener {
            observeData(viewModel, rvAdapter)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeData(viewModel: MainMoviesViewModel, rvAdapter: MovieRVAdapter) {
        EspressoIdlingResource.increment()
        viewModel.getMovieList()?.observe(viewLifecycleOwner, {
            if (it != null) {
                rvAdapter.setupMovieList(it)
            } else {
                Log.e("MovieFragment", "NULL")
            }
            pbMovies.visibility = View.INVISIBLE

            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()

            srlMovies.isRefreshing = false
        })
    }
}
