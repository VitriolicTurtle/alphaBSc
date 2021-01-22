package com.cn.bsc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.cn.bsc.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_main.*

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Initialize Firebase Auth
        auth = Firebase.auth

        // getting data from the text fields
        val textFieldUsername = view.findViewById<EditText>(R.id.et_register_email)
        val textFieldPassword = view.findViewById<EditText>(R.id.et_register_password)
        val buttonRegister = view.findViewById<Button>(R.id.btn_register)
        buttonRegister.setOnClickListener(){
            val userEmail = textFieldUsername.text.toString()
            val password = textFieldPassword.text.toString()
            // logging in using the data entered in the text fields
            createUser(userEmail, password)
        }


        /*
        //val currentUser = mAuth!!.currentUser  // current user
        val userScore = 2
        val userName = "testing"

        // current user ID
        val userID = FirebaseAuth.getInstance().currentUser!!.uid



        // Create a new user with a first and last name
        val user = hashMapOf(
                "userid" to userID,
                "email" to userEmail,
                "score" to 0
        )

        db.collection("users").document(userID)
                .set(user)
                .addOnSuccessListener { Log.d("Successfully added to DB", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Failed adding to DB", "Error writing document", e) }

 */



        return view

    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(activity,"User successfully created",Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(activity,"Error registering user!",Toast.LENGTH_SHORT).show()
                    }
                }
    }


}