package com.schooladmin.plugins

import com.schooladmin.route.dbRoute
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        dbRoute()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
