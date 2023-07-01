package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar


object CustomerTable: Table<CustomerEntity>("customer") {
    val schoolName = varchar("schoolName").primaryKey().bindTo { it.schoolName }
    val schoolRepName = varchar("schoolRepName").bindTo { it.schoolRepName }
    val address = varchar("address").bindTo { it.address }
    val schoolPhoneNumber = varchar("schoolPhoneNumber").bindTo { it.schoolPhoneNumber }
    val repPhoneNumber = varchar("repPhoneNumber").bindTo { it.repPhoneNumber }
}

interface CustomerEntity: Entity<CustomerEntity>{
    companion object: Entity.Factory<CustomerEntity>()
    val schoolName: String
    val schoolRepName: String
    val address: String
    val schoolPhoneNumber: String
    val repPhoneNumber: String

}
