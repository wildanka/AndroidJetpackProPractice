package com.wildanka.moviecatalogue.remote.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.remote.model.entity.TVShowData
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.remote.view.adapter.TVShowRVAdapter
import com.wildanka.moviecatalogue.remote.viewmodel.MainMoviesViewModel

/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class TVShowFragment : Fragment() {
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
        val viewModel = ViewModelProvider(this).get(MainMoviesViewModel::class.java)
        pbMovies.visibility = View.VISIBLE
        val rvAdapter = TVShowRVAdapter(activity!!)
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        observeData(viewModel, rvAdapter)
        srlMovies.setOnRefreshListener {
            observeData(viewModel, rvAdapter)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeData(viewModel: MainMoviesViewModel, rvAdapter: TVShowRVAdapter) {
        EspressoIdlingResource.increment()
        viewModel.getTVShowList()?.observe(this, Observer<MutableList<TVShowData>> {
            if (it != null) {
                rvAdapter.setupTVShowList(it)
            }
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
            pbMovies.visibility = View.INVISIBLE
            srlMovies.isRefreshing = false
        })
    }

}
