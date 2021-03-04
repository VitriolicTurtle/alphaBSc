package com.cn.bsc

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore.getInstance

object DBObject {

    private lateinit var auth: FirebaseAuth


    fun getUserData(userID: String) {
        val db = getInstance()
        db.collection("users").document(userID).get().addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // if query is successful, reads the data and stores in variables
                val name = task.result?.get("name").toString()
                val email = task.result?.get("email").toString()
                val score = task.result?.get("score").toString().toInt()
                val teacher = task.result?.get("teacher") as Boolean

                MainActivity().userObject.setUser(userID, name, email, score, teacher)
            }
        }
    }

    // function that retrieves data from user database and displays it
    fun getDocSnapshot(userID: String): Task<DocumentSnapshot> {
        val db = getInstance()
        // returning document snapshot

        return db.collection("users").document(userID).get().addOnCompleteListener() {  task->
            if (task.isComplete)
                task.result.toString()
        }
    }

    // function that retrieves data from user database and displays it
    fun getUserName(userID: String): String {
        val db = getInstance()
        // returning the query as a string

        return db.collection("users").document(userID).get().result!!.get("name").toString()
    }

    // function that retrieves data from user database and displays it
    fun getUserEmail(userID: String): String {
        val db = getInstance()
        // returning the query as a string

        return db.collection("users").document(userID).get().result!!.get("email").toString()
    }

    // function that retrieves data from user database and displays it
    fun getUserScore(userID: String): Int {
        val db = getInstance()
        // returning query as int
        return db.collection("users").document(userID).get().result!!.get("score").toString().toInt()
    }

    fun setScore(userID: String, newScore: Int) {
        val db = getInstance()
        db.collection("users")
                .document(userID)
                .update("score", newScore)
    }

    fun createDatabaseEntry(email: String, name: String, isTeacher: Boolean, userID: String) {
        val db = getInstance()
        // Create a new user entry in the database
        val user = hashMapOf(
                "userid" to userID,
                "email" to email,
                "name" to name,
                "score" to 0,
                "teacher" to isTeacher
        )
        // add selected data to database
        db.collection("users").document(userID)
                .set(user)
                .addOnSuccessListener { Log.d("Successfully added to DB", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Failed adding to DB", "Error writing document", e) }
    }

    fun addClassroom(courseName: String, grade: String, teacher: String, year: Int) {
        val db = getInstance()
        // create data entry for the course
        val studentList: ArrayList<String> = arrayListOf()
        //val userID = findUserByName(capitalize(teacher))

        val course = hashMapOf(
                "course name" to courseName,
                "grade" to grade,
                "teacher name" to capitalize(teacher),
                "year" to year,
                "students" to studentList
        )
        // add the data into the database
        db.collection("classrooms").document("$grade grade $courseName $year")
                .set(course)
                .addOnSuccessListener { Log.d("Successfully added to DB", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Failed adding to DB", "Error writing document", e) }
    }

    fun findUserByName(name: String): String{
        val db = getInstance()
        val doc = db.collection("users").whereEqualTo("name", name).get()
        var uid = ""
        doc.addOnSuccessListener { documents ->
            for (document in documents) {
                uid = document["userid"].toString()
            }
        }
        return uid
    }

    private fun capitalize(s: String): String {
        return s.split(" ").joinToString(" ") { it.toLowerCase().capitalize() }
    }

}

