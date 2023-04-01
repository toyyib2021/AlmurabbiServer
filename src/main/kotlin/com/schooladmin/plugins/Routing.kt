package com.schooladmin.plugins

import com.schooladmin.route.addDepartment
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        addDepartment()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
