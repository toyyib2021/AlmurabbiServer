package com.schooladmin.model.data

import java.time.LocalDate

data class PaymentHistory(
    val paidDate: String,
    val modifiedPaymentDate: String,
    val orderId: Int,
    val amount: Int,
    val id: Int,
)

