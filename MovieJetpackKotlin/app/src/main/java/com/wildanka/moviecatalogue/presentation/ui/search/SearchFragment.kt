package com.wildanka.moviecatalogue.presentation.ui.search

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.databinding.SearchFragmentBinding
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.TVShowRVAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource


class SearchFragment : BottomSheetDialogFragment() {
    private lateinit var binding: SearchFragmentBinding
    private var isSearchMovie = false
    private lateinit var movieRVAdapter: MovieRVAdapter
    private lateinit var tvShowRVAdapter: TVShowRVAdapter


    private lateinit var viewModel: SearchViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener { dialogInterface ->

            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, _ -> changeTextHint() }
        binding.rvSearchResult.layoutManager = LinearLayoutManager(activity)
        movieRVAdapter = MovieRVAdapter()
        tvShowRVAdapter = TVShowRVAdapter()

        binding.searchTitle.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //search movie or tv show
                if (isSearchMovie) {
                    query?.let {
                        searchMoviesData(it)
                    }
                } else {
                    query?.let {
                        searchTVShows(it)
                    }
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        //if isMovie, observe movieData, else observe tvShow data
    }


    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onResume() {
        super.onResume()
        changeTextHint()
    }

    private fun changeTextHint() {
        if (binding.radioGroup.checkedRadioButtonId == R.id.rb_movie) {
            isSearchMovie = true
            binding.searchTitle.queryHint = "Movie title"
        } else {
            isSearchMovie = false
            binding.searchTitle.queryHint = "TV Show title"
        }
    }


    private fun searchMoviesData(query: String) {

        EspressoIdlingResource.increment()
        viewModel.getSearchedMovies(query)?.observe(this, {
            if (it != null) {
                if (it.size == 0){ // there is no result found
                    binding.rvSearchResult.visibility = View.GONE
                }else { // success
                    binding.rvSearchResult.visibility = View.VISIBLE
                    movieRVAdapter.setupMovieList(it)
                    binding.rvSearchResult.adapter = movieRVAdapter
                }
            } else {
                Log.e("TAG", "OQTS Failed")
                Toast.makeText(activity, "OQTS failed", Toast.LENGTH_SHORT).show()
            }
//            pbMovies.visibility = View.INVISIBLE

            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()

//            srlMovies.isRefreshing = false
        })
    }

    private fun searchTVShows(query: String) {

        EspressoIdlingResource.increment()
        viewModel.getSearchedTVShows(query)?.observe(this, {
            if (it != null) {
                if (it.size == 0){ // there is no result found
                    binding.rvSearchResult.visibility = View.GONE
                }else{ // success
                    binding.rvSearchResult.visibility = View.VISIBLE
                    tvShowRVAdapter.setupTVShowList(it)
                    binding.rvSearchResult.adapter = tvShowRVAdapter
                }

            } else {
                Log.e("TAG", "OQTS Failed")
                Toast.makeText(activity, "OQTS failed", Toast.LENGTH_SHORT).show()
            }
//            pbMovies.visibility = View.INVISIBLE

            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) EspressoIdlingResource.decrement()

//            srlMovies.isRefreshing = false
        })
    }

}