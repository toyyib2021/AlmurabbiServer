package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object OrderInfor2Table: Table<OrderInfor2Entity>("orderinfor2") {
    val schoolName = varchar("schoolName").bindTo { it.schoolName }
    val schoolPhone = varchar("schoolPhone").bindTo { it.schoolPhone }
    val orderId = int("orderId").bindTo { it.orderId }
    val balance = int("balance").bindTo { it.balance }
    val paid = int("paid").bindTo { it.paid }
    val amount = int("amount").bindTo { it.amount }
    val id = int("id").primaryKey().bindTo { it.id }
}

interface OrderInfor2Entity: Entity<OrderInfor2Entity>{
    companion object: Entity.Factory<OrderInfor2Entity>()
    val schoolName: String
    val schoolPhone: String
    val orderId: Int
    val balance: Int
    val paid: Int
    val amount: Int
    val id: Int

}
