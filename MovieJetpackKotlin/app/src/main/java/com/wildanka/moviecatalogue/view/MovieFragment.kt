package com.wildanka.moviecatalogue.view


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel

/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        val rvMovie = view.findViewById<RecyclerView>(R.id.rv_movie)
        val viewModel = ViewModelProviders.of(this).get(MainMoviesViewModel::class.java)

        val rvAdapter = MovieRVAdapter(activity!!)
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter
        EspressoIdlingResource.increment()
        // Get Data dari API
        viewModel.getMovieList()?.observe(this, Observer<MutableList<MovieData>> {
            if (it != null){
                Log.e("MovieFragment", "KAGAK NULL BRUH ${it.size}")
                rvAdapter.setupMovieList(it)
            }else{
                Log.e("MovieFragment", "NULL COY")
            }

            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()
        })
        return view
    }

}
