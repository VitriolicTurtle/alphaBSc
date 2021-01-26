package com.cn.bsc.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.cn.bsc.MainActivity
import com.cn.bsc.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_main.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize Firebase Auth
        auth = Firebase.auth

        // getting data from the text fields
        val textFieldUsername = view.findViewById<EditText>(R.id.et_login_email)
        val textFieldPassword = view.findViewById<EditText>(R.id.et_login_password)
        val buttonLogin = view.findViewById<Button>(R.id.loginButton)
        buttonLogin.setOnClickListener(){
            val userEmail = textFieldUsername.text.toString()
            val password = textFieldPassword.text.toString()
            // logging in using the data entered in the text fields
            login(userEmail, password)
        }

        return view

    }



    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information


                        Toast.makeText(activity,"Logged in!",Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(activity,"Login failed!",Toast.LENGTH_SHORT).show()
                    }
                }
    }
    




}