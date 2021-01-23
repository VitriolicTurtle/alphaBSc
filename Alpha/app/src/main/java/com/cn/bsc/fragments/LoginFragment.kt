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
import androidx.databinding.DataBindingUtil
import com.cn.bsc.MainActivity
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_main.*

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        // Initialize Firebase Auth
        auth = Firebase.auth

        // getting data from the text fields
        val textFieldUsername = binding.root.findViewById<EditText>(R.id.et_login_email)
        val textFieldPassword = binding.root.findViewById<EditText>(R.id.et_login_password)
        val buttonLogin = binding.root.findViewById<Button>(R.id.loginButton)
        buttonLogin.setOnClickListener(){
            val userEmail = textFieldUsername.text.toString()
            val password = textFieldPassword.text.toString()
            // logging in using the data entered in the text fields
            login(userEmail, password)
        }

        return binding.root
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