package com.wildanka.moviecatalogue.view


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.R

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
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)

        for ((index, value) in resources.getStringArray(R.array.data_title).withIndex()){
            Log.e("TES", "$index $value")
            viewModel.addMovieList(
                Movie(
                    value,
                    resources.getStringArray(R.array.data_year)[index],
                    resources.getStringArray(R.array.data_rating)[index],
                    resources.getStringArray(R.array.data_short_desc)[index],
                    resources.getStringArray(R.array.data_ov)[index],
                    dataPoster.getResourceId(index, 0)
                )
            )
        }
        dataPoster.recycle() //recycle obatinTypedArray after being used

        val rvAdapter = MovieRVAdapter(activity!!)
        rvAdapter.setupMovieList(viewModel.getMovieList())
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        return view
    }

}
