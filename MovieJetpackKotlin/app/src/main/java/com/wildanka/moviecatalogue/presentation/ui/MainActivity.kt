package com.wildanka.moviecatalogue.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wildanka.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
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
            R.id.action_search -> {
                when (navController.currentDestination?.id) {
                    R.id.movieFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_movieFragment_to_searchFragment)
                    R.id.tvShowFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_tvShowFragment_to_searchFragment)
                    R.id.favoritesFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_favoritesFragment_to_searchFragment)
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
