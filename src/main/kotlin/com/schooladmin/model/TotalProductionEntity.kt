package com.schooladmin.model

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object TotalProductionTable: Table<TotalProductionEntity>("totalproduct") {
    val productName = varchar("productName").bindTo { it.productName }
    val quantityAdd = int("quantityAdd").bindTo { it.quantityAdd }
    val currentdate = varchar("currentdate").bindTo { it.currentdate }
    val id = int("id").primaryKey().bindTo { it.id }
}


interface TotalProductionEntity: Entity<TotalProductionEntity>{
    companion object: Entity.Factory<TotalProductionEntity>()
    val productName: String
    val quantityAdd: Int
    val currentdate: String
    val id: Int

}
