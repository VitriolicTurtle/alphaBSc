package com.cn.bsc

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.cn.bsc.fragments.LoginFragment
import com.cn.bsc.fragments.MainFragment
import com.cn.bsc.fragments.RegisterFragment
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cn.bsc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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