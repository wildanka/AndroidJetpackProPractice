package com.wildanka.moviecatalogue.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.view.adapter.TVShowRVAdapter
import com.wildanka.moviecatalogue.viewmodel.MainMoviesViewModel

/**
 * Fragment for displaying Movie / TV Show lists.
 *
 */
class TVShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        val rvMovie = view.findViewById<RecyclerView>(R.id.rv_movie)
        val viewModel = ViewModelProviders.of(this).get(MainMoviesViewModel::class.java)

        val rvAdapter = TVShowRVAdapter(activity!!)
        rvAdapter.setupTVShowList(viewModel.getTVShowList())
        rvMovie.layoutManager = LinearLayoutManager(activity!!)
        rvMovie.adapter = rvAdapter

        return view
    }

}
