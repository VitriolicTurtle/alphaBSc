package com.cn.bsc.fragments

import com.cn.bsc.DBObject

class DBTest {

    constructor() {
        val courseName = "Math"
        val grade = "5th"
        val teacher = "Teacher Test"
        val year = 2021
        DBObject.addClassroom(courseName, grade, teacher, year)
    }

}