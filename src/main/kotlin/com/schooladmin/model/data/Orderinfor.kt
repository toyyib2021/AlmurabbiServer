package com.schooladmin.model.data

import java.time.LocalDate

data class OrderInfor(
    val productName: String,
    val quantity: Int,
    val orderId: Int,
    val returned: Int,
    val currentdate: String,
    val unitPrice: Int,
    val amount: Int,
    val id: Int

)

