package com.schooladmin.repository

import com.schooladmin.model.User
import com.schooladmin.model.Users

interface Repository {

    fun addUser(user: User): User

    fun updateUser(email: String, user: User): Boolean


    fun getAllUsers(): List<User>

    fun getById(email: String): User?

    fun delete(email: String): Boolean


}