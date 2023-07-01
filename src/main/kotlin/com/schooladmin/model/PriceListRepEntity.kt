package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object PriceListRepTable: Table<PriceListRepEntity>("pricelistrep") {
    val productName = varchar("productName").primaryKey().bindTo { it.productName }
    val price = int("price").bindTo { it.price }

}

interface PriceListRepEntity: Entity<PriceListRepEntity>{
    companion object: Entity.Factory<PriceListRepEntity>()
    val productName: String
    val price: Int


}
