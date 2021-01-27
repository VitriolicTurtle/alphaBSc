package com.cn.bsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.cn.bsc.fragments.LoginFragment
import com.cn.bsc.fragments.MainFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cn.bsc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var savedDarkData: sharedprefs

    private lateinit var auth: FirebaseAuth

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

    /*
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
    }
     */

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

}