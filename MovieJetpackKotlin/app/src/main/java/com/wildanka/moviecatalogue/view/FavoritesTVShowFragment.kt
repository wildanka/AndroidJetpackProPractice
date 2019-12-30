package com.wildanka.moviecatalogue.view


import android.os.Bundle
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
import com.wildanka.moviecatalogue.model.entity.TVShowData
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.view.adapter.FavoriteMoviesAdapter
import com.wildanka.moviecatalogue.view.adapter.FavoriteTVShowAdapter
import com.wildanka.moviecatalogue.view.adapter.TVShowRVAdapter
import com.wildanka.moviecatalogue.viewmodel.FavoritesViewModel
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel

/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class FavoritesTVShowFragment : Fragment() {
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
        val rvAdapter = FavoriteTVShowAdapter()
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        viewModel.getAllFavoritesTvShow()?.observe(this, Observer {
            rvAdapter.setupFavoriteTVShowData(it)
            pbMovies.visibility = View.INVISIBLE
        })
        super.onViewCreated(view, savedInstanceState)
    }


}
