package com.wildanka.moviecatalogue

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.wildanka.moviecatalogue.view.MovieFragment
import com.wildanka.moviecatalogue.view.TVShowFragment
import com.wildanka.moviecatalogue.view.adapter.MovieFSPAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = MovieFSPAdapter(supportFragmentManager)
        adapter.addFragment(MovieFragment(), "Movie")
        adapter.addFragment(TVShowFragment(), "TV Show")
        vp_movie.adapter = adapter
        tl_menu.setupWithViewPager(vp_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
