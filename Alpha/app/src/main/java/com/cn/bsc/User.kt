package com.cn.bsc

object User {

    private var userID = ""
    private var userName = ""
    private var userEmail = ""
    private var userScore = -1
    private var isTeacher = false

    fun setUser(id: String, name: String, email: String, score: Int, teacher: Boolean) {
        userID = id
        userName = name
        userEmail = email
        userScore = score
        isTeacher = teacher
    }

    fun setName(name: String) {
        userName = name
    }

    fun setEmail(email: String) {
        userName = email
    }

    fun setScore(score: Int) {
        userScore = score
    }

   fun getName(): String {
       return userName
   }

    fun getEmail(): String {
        return userEmail
    }

    fun getScore(): Int {
        return userScore
    }


}

