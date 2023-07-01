package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object DiscountPriceListTable: Table<DiscountPriceListEntity>("discountpricelist") {
    val productName = varchar("productName").primaryKey().bindTo { it.productName }
    val price = int("price").bindTo { it.price }

}

interface DiscountPriceListEntity: Entity<DiscountPriceListEntity>{
    companion object: Entity.Factory<DiscountPriceListEntity>()
    val productName: String
    val price: Int


}
