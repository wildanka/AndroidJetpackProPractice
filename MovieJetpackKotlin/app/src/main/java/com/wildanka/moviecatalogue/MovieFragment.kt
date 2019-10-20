package com.wildanka.moviecatalogue


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*

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

        for ((index, value) in resources.getStringArray(R.array.data_title).withIndex()){
            Log.e("TES", "$index $value")
            viewModel.addMovieList(Movie(
                value,
                resources.getStringArray(R.array.data_year)[index],
                resources.getStringArray(R.array.data_rating)[index],
                resources.getStringArray(R.array.data_short_desc)[index],
                resources.getStringArray(R.array.data_ov)[index],
                resources.getIntArray(R.array.data_poster)[index]
            ))
        }

        val rvAdapter = MovieRVAdapter(activity!!)
        rvAdapter.setupMovieList(viewModel.getMovieList())
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        return view
    }


}
