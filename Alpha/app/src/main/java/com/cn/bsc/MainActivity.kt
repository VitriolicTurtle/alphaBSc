package com.cn.bsc

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.ui.setupWithNavController
import com.cn.bsc.databinding.ActivityMainBinding
import com.cn.bsc.fragments.UserProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var savedDarkData: sharedprefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ///setContentView(R.layout.activity_main)
        //setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_fragment)
        val appBarConfig = AppBarConfiguration(navController.graph, binding.mainDrawerLayout)


        //binding.toolbar.setupWithNavController(navController, appBarConfig)
        binding.navigationView.setupWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)

        /*      change this after sessions have been made */
        //this.hideMenu()

        savedDarkData = sharedprefs(this)
        if(savedDarkData.loadDarkModeState() == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        //set red theme
        if(savedDarkData.loadRedModeState() == true){
            setTheme(R.style.RedTheme)
        }else if(savedDarkData.loadGreenModeState() == true){
            setTheme(R.style.GreenTheme)
        }else if(savedDarkData.loadOrangeModeState() == true){
            setTheme(R.style.OrangeTheme)
        } else if(savedDarkData.loadPurpleModeState() == true){
            setTheme(R.style.PurpleTheme)
        } else{
            setTheme((R.style.AppTheme))
        }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ///setContentView(R.layout.activity_main)
        //setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_fragment)
        val appBarConfig = AppBarConfiguration(navController.graph, binding.mainDrawerLayout)


        //binding.toolbar.setupWithNavController(navController, appBarConfig)
        binding.navigationView.setupWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)



    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

    fun showMenu(){
        this.bottom_nav.visibility = View.VISIBLE
        val menu = this.navigation_view.menu
        menu.findItem(R.id.dest_classroom_index).isVisible = true
        menu.findItem(R.id.dest_profile).isVisible = true
        menu.findItem(R.id.dest_settings).isVisible = true
    }

    fun hideMenu(){
        this.bottom_nav.visibility = View.INVISIBLE
        val menu = this.navigation_view.menu
        menu.findItem(R.id.dest_classroom_index).isVisible = false
        menu.findItem(R.id.dest_profile).isVisible = false
        menu.findItem(R.id.dest_settings).isVisible = false
    }

}