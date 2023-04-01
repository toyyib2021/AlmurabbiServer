package com.schooladmin.route

import com.schooladmin.model.User
import com.schooladmin.model.UserTable.id
import com.schooladmin.model.Users
import com.schooladmin.repository.RepositoryImp
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.addDepartment(){

    val dBRepo = RepositoryImp()
    get("/allUser") {
        call.respond(dBRepo.getAllUsers())

    }


    get("/getUserByEmail/{email}") {
        val email = call.parameters["email"]

        if (email == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong email address"
            )
            return@get
        }

        val user = dBRepo.getById(email)
        if (user == null){
            call.respond(HttpStatusCode.BadRequest, )
        }else {
            call.respond(user)
        }


    }

    post ("/addUser"){
        val userObject = call.receive<User>()
        val user = dBRepo.addUser(userObject)
        call.respond(user)
    }


    put ("/updateUser/{email}"){
        val email = call.parameters["email"]

        if (email == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong email address"
            )
            return@put
        }
        val userObject = call.receive<User>()
        val update = dBRepo.updateUser(email, userObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }


    delete ("/delete/{email}") {
        val email = call.parameters["email"]

        if (email == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong email address"
            )
            return@delete
        }
        val delete = dBRepo.delete(email)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

