package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar


object ProductTable: Table<ProductEntity>("product") {
    val productName = varchar("productName").primaryKey().bindTo { it.productName }
}

interface ProductEntity: Entity<ProductEntity>{
    companion object: Entity.Factory<ProductEntity>()
    val productName: String


}
