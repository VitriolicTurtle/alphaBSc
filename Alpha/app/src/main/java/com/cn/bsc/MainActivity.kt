package com.cn.bsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cn.bsc.fragments.MainFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mF = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment, mF)
        transaction.disallowAddToBackStack()
        transaction.commit()


    }

    /*
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
    }
     */

}