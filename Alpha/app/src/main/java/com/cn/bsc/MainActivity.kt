package com.cn.bsc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.ui.setupWithNavController
import com.cn.bsc.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var savedDarkData: sharedprefs

    var userObject = User

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
        val menu = binding.navigationView.menu
        menu.findItem(R.id.dest_classroom_index).setVisible(false)
        menu.findItem(R.id.dest_profile).setVisible(false)
        menu.findItem(R.id.dest_settings).setVisible(false)

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
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

}