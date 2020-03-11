package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hotel.R
import kotlinx.android.synthetic.main.homescreen_main.*

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen_main)


        setupView()
    }

    private fun setupView() {

        var navController = findNavController(R.id.fragNavHost)


        var appBarConfiguration = AppBarConfiguration(

            topLevelDestinationIds = setOf(
                R.id.searchFragment,
                R.id.favoritesFragment,
                R.id.rewardsFragment,
                R.id.booksFragment,
                R.id.moreFragment
            )
        )

        setupWithNavController(toolbar,navController,appBarConfiguration)


    }
}
