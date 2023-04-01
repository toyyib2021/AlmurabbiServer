package com.schooladmin.repository

import com.schooladmin.database
import com.schooladmin.model.User
import com.schooladmin.model.UserTable
import com.schooladmin.model.Users
import org.ktorm.dsl.*

class RepositoryImp: Repository {

    private val allUser = mutableListOf<User>()

    override fun addUser(user: User): User {
        val addUser = User(
            id = allUser.size + 1,
            email = user.email,
            fullName = user.fullName,
            phone = user.phone
        )
        allUser.add(addUser)
        return addUser
    }

    override fun updateUser(email: String, user: User): Boolean {
        val getUser = allUser.firstOrNull{it.email == email}
            ?: return false

        getUser.email = user.email
        getUser.fullName = user.fullName
        getUser.phone = user.phone
        return true
    }

    override fun getAllUsers(): List<User> {
        return allUser
    }

    override fun getById(email: String): User? {
        return allUser.firstOrNull{it.email == email}
    }

    override fun delete(email: String): Boolean {
       return allUser.removeIf(){it.email == email}
    }

}