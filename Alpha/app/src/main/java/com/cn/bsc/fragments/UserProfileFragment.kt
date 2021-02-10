package com.cn.bsc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cn.bsc.MainActivity
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentUserProfileBinding
import com.cn.bsc.sharedprefs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class UserProfileFragment : Fragment(){
    private lateinit var binding: FragmentUserProfileBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)
        // Initialize Firebase Auth
        auth = Firebase.auth

        // get current user id
        val userID = FirebaseAuth.getInstance().currentUser!!.uid
        readData(userID)

        val buttonSettings = binding.root.findViewById<Button>(R.id.settings_button)
        val buttonFriends = binding.root.findViewById<Button>(R.id.friends_button)
        val buttonUserInfo = binding.root.findViewById<Button>(R.id.user_info_button)
        val buttonLogout = binding.root.findViewById<Button>(R.id.log_out_button)

        buttonSettings.setOnClickListener(){
            findNavController().navigate(R.id.dest_settings)
        }

        buttonFriends.setOnClickListener(){
            findNavController().navigate(R.id.dest_friends_list)
        }

        buttonUserInfo.setOnClickListener(){
            findNavController().navigate(R.id.dest_user)
        }

        buttonLogout.setOnClickListener(){
            auth.signOut()
            Toast.makeText(activity,"Logged out!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.dest_login)
        }

        return binding.root
    }


    // function that retrieves data from user database and displays it
    private fun readData(userID: String) {
        // making the query
        db.collection("users").document(userID).get().addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // if query is successful, reads the data and stores in variables
                val score = task.result?.get("score")
                // getting the reference to the textViews

                val userScore = binding.root.findViewById<TextView>(R.id.user_score)
                // displaying the data in the textViews

                userScore.text = score.toString()
            }
        }
    }





}
