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
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.domain.entity.FavoriteMovie
import com.wildanka.moviecatalogue.presentation.ui.favorites.adapter.FavoriteMoviePagedListAdapter

class FavoritesMovieFragment : Fragment() {
    private lateinit var srlMovies: SwipeRefreshLayout
    private lateinit var pbMovies: ProgressBar
    private lateinit var rvMovie: RecyclerView
    private lateinit var adapter: FavoriteMoviePagedListAdapter

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

        val viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        adapter = FavoriteMoviePagedListAdapter()
        rvMovie.layoutManager = LinearLayoutManager(activity)
        rvMovie.adapter = adapter

        viewModel.getAllFavoriteMoviePaging().observe(viewLifecycleOwner, favoriteMovieObserver)
        super.onViewCreated(view, savedInstanceState)
    }

    private val favoriteMovieObserver =
        Observer<PagedList<FavoriteMovie>> {
            if (it != null) {
                adapter.submitList(it)
                pbMovies.visibility = View.INVISIBLE
            }
        }
}
