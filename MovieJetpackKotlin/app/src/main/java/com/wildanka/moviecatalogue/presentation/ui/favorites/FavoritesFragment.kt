package com.wildanka.moviecatalogue.presentation.ui.favorites


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.databinding.FragmentFavoritesBinding
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieFragmentPagerAdapter

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter =
            MovieFragmentPagerAdapter(
                childFragmentManager
            )

        adapter.addFragment(FavoritesMovieFragment(), "Movies")
        adapter.addFragment(FavoritesTVShowFragment(), "TV Shows")
        binding.vpMovie.adapter = adapter
        binding.tlMenu.setupWithViewPager(binding.vpMovie)
    }
}
