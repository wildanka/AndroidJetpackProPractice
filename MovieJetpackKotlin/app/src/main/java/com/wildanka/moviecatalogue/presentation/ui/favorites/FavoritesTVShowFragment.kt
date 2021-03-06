package com.wildanka.moviecatalogue.presentation.ui.favorites


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wildanka.moviecatalogue.presentation.ui.favorites.adapter.FavoriteTVPagedListAdapter
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow


/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class FavoritesTVShowFragment : Fragment() {
    private lateinit var srlMovies: SwipeRefreshLayout
    private lateinit var pbMovies: ProgressBar
    private lateinit var rvMovie: RecyclerView
    private lateinit var adapter: FavoriteTVPagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.wildanka.moviecatalogue.R.layout.fragment_favorite_movie, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMovie = view.findViewById(com.wildanka.moviecatalogue.R.id.rv_movie)
        pbMovies = view.findViewById(com.wildanka.moviecatalogue.R.id.pb_movies)
        srlMovies = view.findViewById(com.wildanka.moviecatalogue.R.id.srl_movies)
        pbMovies.visibility = View.VISIBLE

        val factory = FavoritesViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)
        adapter = FavoriteTVPagedListAdapter()
        rvMovie.layoutManager = LinearLayoutManager(activity)
        rvMovie.adapter = adapter

        viewModel.getAllFavoriteTVShowPaging().observe(viewLifecycleOwner, favoriteTVShowObserver)
        super.onViewCreated(view, savedInstanceState)
    }

    private val favoriteTVShowObserver =
        Observer<PagedList<FavoriteTVShow>> {
            if (it != null) {
                adapter.submitList(it)
                pbMovies.visibility = View.INVISIBLE
            }
        }
}
