package com.schooladmin

import io.ktor.server.application.*
import com.schooladmin.plugins.*
import org.ktorm.database.Database
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureSecurity()
    configureRouting()
}



