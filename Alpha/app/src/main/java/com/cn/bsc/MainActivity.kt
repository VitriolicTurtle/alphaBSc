package com.cn.bsc

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    var DBTest = DBTest()
    val db = FirebaseFirestore.getInstance()
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onStart()

        //createUser(user, password)
        login(DBTest.userEmail, DBTest.password)

        // current user ID
        val userID = FirebaseAuth.getInstance().currentUser!!.uid

        // Create a new user with a first and last name
        val user = hashMapOf(
        "userid" to userID,
        "name" to DBTest.userName,
        "score" to DBTest.userScore
        )

        db.collection("users").document(userID)
                .set(user)
                .addOnSuccessListener { Log.d("Successfully added to DB", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Failed adding to DB", "Error writing document", e) }


    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser  // current user
    }

    private fun createUser(email: String, password: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(
                                this@MainActivity,
                                "User successfully created!",
                                Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this@MainActivity, "Creating user failed", Toast.LENGTH_SHORT).show()
                    }
                }
    }

    private fun login(email: String, password: String) {
        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        this
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this@MainActivity, "Logged in!", Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this@MainActivity, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
    }







}