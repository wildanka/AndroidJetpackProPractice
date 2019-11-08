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
import com.wildanka.moviecatalogue.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class MovieFragment : Fragment() {
    private lateinit var srlMovies: SwipeRefreshLayout
    private lateinit var pbMovies: ProgressBar
    private lateinit var rvMovie: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        rvMovie = view.findViewById(R.id.rv_movie)
        pbMovies = view.findViewById(R.id.pb_movies)
        srlMovies = view.findViewById(R.id.srl_movies)

        pbMovies.visibility = View.VISIBLE

        val viewModel = ViewModelProviders.of(this).get(MainMoviesViewModel::class.java)
        val rvAdapter = MovieRVAdapter(activity!!)
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        // Get Data dari API
        observeData(viewModel, rvAdapter)
        srlMovies.setOnRefreshListener {
            observeData(viewModel, rvAdapter)
        }
        return view
    }

    private fun observeData(viewModel: MainMoviesViewModel, rvAdapter: MovieRVAdapter) {
        EspressoIdlingResource.increment()
        viewModel.getMovieList()?.observe(this, Observer<MutableList<MovieData>> {
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
