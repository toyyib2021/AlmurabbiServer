package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object PaymentHistoryTable: Table<PaymentHistoryEntity>("paymenthistory") {
    val paidDate = varchar("paidDate").bindTo { it.paidDate }
    val modifiedPaymentDate = varchar("modifiedPaymentDate").bindTo { it.modifiedPaymentDate }
    val orderId = int("orderId").bindTo { it.orderId }
    val amount = int("amount").bindTo { it.amount }
    val id = int("id").primaryKey().bindTo { it.id }
}

interface PaymentHistoryEntity: Entity<PaymentHistoryEntity>{
    companion object: Entity.Factory<PaymentHistoryEntity>()
    val paidDate: String
    val modifiedPaymentDate: String
    val orderId: Int
    val amount: Int
    val id: Int

}
