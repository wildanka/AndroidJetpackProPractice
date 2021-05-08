package com.wildanka.moviecatalogue.presentation.ui.movies.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MovieFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragment = ArrayList<Fragment>()
    private val mFragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragment[position]
    }

    override fun getCount(): Int {
        return mFragmentTitle.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragment.add(fragment)
        mFragmentTitle.add(title)
    }

}