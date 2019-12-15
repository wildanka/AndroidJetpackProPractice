package com.wildanka.moviecatalogue.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.view.adapter.MovieFragmentPagerAdapter

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_favorites, container, false)
        val adapter = MovieFragmentPagerAdapter(activity!!.supportFragmentManager)

        val vpMovie = rootView.findViewById<ViewPager>(R.id.vp_movie)
        val tlMenu = rootView.findViewById<TabLayout>(R.id.tl_menu)
        adapter.addFragment(FavoritesMovieFragment(), "Movies")
        adapter.addFragment(FavoritesTVShowFragment(), "TV Shows")
        vpMovie.adapter = adapter
        tlMenu.setupWithViewPager(vpMovie)
        return rootView
    }


}
