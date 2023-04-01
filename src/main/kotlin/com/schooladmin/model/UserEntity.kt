package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar




object UserTable: Table<Users>("user") {
    val id = int("id").primaryKey().bindTo { it.id }
    val email = varchar("email").bindTo { it.email }
    val fullName = varchar("fullName").bindTo { it.fullName }
    val phone = varchar("phone").bindTo { it.phone }
}

interface Users: Entity<Users>{
    companion object: Entity.Factory<Users>()
    val id: Int
    val email: String
    val fullName: String
    val phone: String

}