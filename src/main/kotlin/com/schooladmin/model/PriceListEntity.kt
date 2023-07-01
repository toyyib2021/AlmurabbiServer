package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object PriceListTable: Table<PriceListEntity>("pricelist") {
    val productName = varchar("productName").primaryKey().bindTo { it.productName }
    val price = int("price").bindTo { it.price }

}

interface PriceListEntity: Entity<PriceListEntity>{
    companion object: Entity.Factory<PriceListEntity>()
    val productName: String
    val price: Int


}
