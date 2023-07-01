package com.schooladmin.database

import com.schooladmin.model.*
import com.schooladmin.model.data.*
import com.schooladmin.model.CustomerEntity
import com.schooladmin.model.CustomerTable
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList


class DatabaseManager {

    init {
        database()
    }
    private val hostname = System.getenv("HOSTNAME")
    private val username = System.getenv("USERNAME")
    private val password = System.getenv("PASS")



    private fun database() = Database.connect(
        url = "jdbc:mysql://localhost:3306/almurabbi",
        user = username,
        password = "Abibat1234"
    )

    /// CUSTOMER ///
    fun getAllCustomer(): List<CustomerEntity>{
        return database().sequenceOf(CustomerTable).toList()
    }

    fun getCustomer(schoolName: String): CustomerEntity? {
        return database().sequenceOf(CustomerTable)
            .firstOrNull(){it.schoolName eq schoolName}
    }

    fun addCustomer(customers: Customers): Customers {
        database().insert(CustomerTable) {
            set(CustomerTable.schoolName, customers.schoolName)
            set(CustomerTable.schoolRepName, customers.schoolRepName)
            set(CustomerTable.address, customers.address)
            set(CustomerTable.schoolPhoneNumber, customers.schoolPhoneNumber)
            set(CustomerTable.repPhoneNumber, customers.repPhoneNumber)
        }
        return Customers( customers.schoolName,
            customers.schoolRepName, customers.address, customers.schoolPhoneNumber,
            customers.repPhoneNumber
        )
    }

    fun updateCustomer(schoolName: String, customers: Customers): Boolean{
        val updatedRow = database().update(CustomerTable){
            set(CustomerTable.schoolName, customers.schoolName)
            set(CustomerTable.schoolRepName, customers.schoolRepName)
            set(CustomerTable.address, customers.address)
            set(CustomerTable.schoolPhoneNumber, customers.schoolPhoneNumber)
            set(CustomerTable.repPhoneNumber, customers.repPhoneNumber)

            where {
                it.schoolName eq schoolName
            }
        }
        return updatedRow > 0
    }

    fun deleteCustomer(schoolName: String): Boolean{
        val deleteRow = database().delete(CustomerTable){
            it.schoolName eq schoolName
        }
        return deleteRow > 0
    }


    /// PRICE LIST ///
    fun getAllPriceList(): List<PriceListEntity>{
        return database().sequenceOf(PriceListTable).toList()
    }

    fun getPriceByProductName(productName: String): PriceListEntity? {
        return database().sequenceOf(PriceListTable)
            .firstOrNull(){it.productName eq productName}
    }

    fun addPriceList(priceList: PriceList): PriceList {
        database().insert(PriceListTable) {
            set(PriceListTable.productName, priceList.productName)
            set(PriceListTable.price, priceList.price)

        }
        return PriceList(priceList.productName, priceList.price)
    }

    fun updatePriceList(productName: String, priceList: PriceList): Boolean{
        val updatedRow = database().update(PriceListTable){
            set(PriceListTable.productName, priceList.productName)
            set(PriceListTable.price, priceList.price)


            where {
                it.productName eq productName
            }
        }
        return updatedRow > 0
    }

    fun deletePrice(productName: String): Boolean{
        val deleteRow = database().delete(PriceListTable){
            it.productName eq productName
        }
        return deleteRow > 0
    }


    /// PRICE REP LIST ///
    fun getAllPriceRepList(): List<PriceListRepEntity>{
        return database().sequenceOf(PriceListRepTable).toList()
    }

    fun getPriceRepByProductName(productName: String): PriceListRepEntity? {
        return database().sequenceOf(PriceListRepTable)
            .firstOrNull(){it.productName eq productName}
    }

    fun addPriceRepList(priceRepList: PriceListRep): PriceListRep {
        database().insert(PriceListRepTable) {
            set(PriceListRepTable.productName, priceRepList.productName)
            set(PriceListRepTable.price, priceRepList.price)
        }
        return PriceListRep(priceRepList.productName, priceRepList.price)
    }

    fun updatePriceRepList(productName: String, priceListRep: PriceListRep): Boolean{
        val updatedRow = database().update(PriceListRepTable){
            set(PriceListRepTable.productName, priceListRep.productName)
            set(PriceListRepTable.price, priceListRep.price)


            where {
                it.productName eq productName
            }
        }
        return updatedRow > 0
    }

    fun deletePriceRep(productName: String): Boolean {
        val deleteRow = database().delete(PriceListRepTable){
            it.productName eq productName
        }
        return deleteRow > 0
    }



    /// PRICE DISCOUNT LIST ///

    fun getAllPriceDiscountList(): List<DiscountPriceListEntity>{
        return database().sequenceOf(DiscountPriceListTable).toList()
    }

    fun getPriceDiscountByProductName(productName: String): DiscountPriceListEntity? {
        return database().sequenceOf(DiscountPriceListTable)
            .firstOrNull(){it.productName eq productName}
    }

    fun addPriceDiscountList(priceDiscountList: DiscountPriceList): DiscountPriceList {
        database().insert(DiscountPriceListTable) {
            set(DiscountPriceListTable.productName, priceDiscountList.productName)
            set(DiscountPriceListTable.price, priceDiscountList.price)
        }
        return DiscountPriceList(priceDiscountList.productName, priceDiscountList.price)
    }

    fun updatePriceDiscountList(productName: String, discountPriceList: DiscountPriceList): Boolean{
        val updatedRow = database().update(DiscountPriceListTable){
            set(DiscountPriceListTable.productName, discountPriceList.productName)
            set(DiscountPriceListTable.price, discountPriceList.price)
            where {
                it.productName eq productName
            }
        }
        return updatedRow > 0
    }

    fun deletePriceDiscount(productName: String): Boolean {
        val deleteRow = database().delete(DiscountPriceListTable){
            it.productName eq productName
        }
        return deleteRow > 0
    }




    /// ORDER LIST ///

    fun getAllOrders(): List<OrderInforEntity>{
        return database().sequenceOf(OrderInforTable).toList()
    }

    fun getOrderByOrderId(orderId: Int): List<OrderInforEntity> {
        return database().sequenceOf(OrderInforTable).toList().filter {
            it.orderId == orderId
        }
    }

    fun sumOrderAmount(orderId: Int): String {
        return database().sequenceOf(OrderInforTable).toList().filter {
            it.orderId == orderId
        }.sumOf { it.amount }.toString()
    }

    fun addOrder(orderInfor: OrderInfor): OrderInfor {

        database().insert(OrderInforTable) {
            set(OrderInforTable.productName, orderInfor.productName)
            set(OrderInforTable.quantity, orderInfor.quantity)
            set(OrderInforTable.orderId, orderInfor.orderId)
            set(OrderInforTable.returned, orderInfor.returned)
            set(OrderInforTable.currentdate, orderInfor.currentdate)
            set(OrderInforTable.unitPrice, orderInfor.unitPrice)
            set(OrderInforTable.amount, orderInfor.amount)

        }
        return OrderInfor(orderInfor.productName, orderInfor.quantity, orderInfor.orderId,
            orderInfor.returned, orderInfor.currentdate, orderInfor.unitPrice,
            orderInfor.amount, orderInfor.id
        )
    }

    fun addListOfOrder(listOfOrderInfor: List<OrderInfor>): List<OrderInfor> {
        database().batchInsert(OrderInforTable) {
            listOfOrderInfor.forEach { infor ->
                item {
                    set(it.productName, infor.productName)
                    set(it.quantity, infor.quantity)
                    set(it.orderId, infor.orderId)
                    set(it.returned, infor.returned)
                    set(it.currentdate, infor.currentdate)
                    set(it.unitPrice, infor.unitPrice)
                    set(it.amount, infor.amount)
                }
            }
        }
        return listOfOrderInfor
    }

    fun updateOrder(id: Int, orderInfor: OrderInfor): Boolean{

        val updatedRow = database().update(OrderInforTable){
            set(OrderInforTable.productName, orderInfor.productName)
            set(OrderInforTable.quantity, orderInfor.quantity)
            set(OrderInforTable.orderId, orderInfor.orderId)
            set(OrderInforTable.returned, orderInfor.returned)
            set(OrderInforTable.currentdate, orderInfor.currentdate)
            set(OrderInforTable.unitPrice, orderInfor.unitPrice)
            set(OrderInforTable.amount, orderInfor.amount)
            set(OrderInforTable.id, orderInfor.id)
            where {
                it.id eq id
            }
        }
        return updatedRow > 0
    }



    /// ORDER 2 LIST ///

    fun getAllOrder2(): List<OrderInfor2Entity>{
        return database().sequenceOf(OrderInfor2Table).toList()
    }

    fun getOrder2ById(id: Int): OrderInfor2Entity? {
        return database().sequenceOf(OrderInfor2Table)
            .firstOrNull(){it.id eq id}
    }

    fun getOrder2BySchoolName(schoolName: String): List<OrderInfor2Entity> {
        return database().sequenceOf(OrderInfor2Table).toList().filter {
            it.schoolName == schoolName
        }
    }

    fun getWherePaidEqAmount(): List<OrderInfor2Entity> {
        return database().sequenceOf(OrderInfor2Table).toList().filter {
            it.paid == it.amount
        }
    }

    fun getWherePaidIsNotEqAmount(): List<OrderInfor2Entity> {
        return database().sequenceOf(OrderInfor2Table).toList().filter {
            it.paid != it.amount
        }
    }

    fun addOrderInfor2(orderInfor2: OrderInfor2): OrderInfor2 {

        database().insert(OrderInfor2Table) {
            set(OrderInfor2Table.schoolName, orderInfor2.schoolName)
            set(OrderInfor2Table.schoolPhone, orderInfor2.schoolPhone)
            set(OrderInfor2Table.orderId, orderInfor2.orderId)
            set(OrderInfor2Table.balance, orderInfor2.balance)
            set(OrderInfor2Table.paid, orderInfor2.paid)
            set(OrderInfor2Table.amount, orderInfor2.amount)

        }
        return OrderInfor2(orderInfor2.schoolName, orderInfor2.schoolPhone, orderInfor2.orderId,
            orderInfor2.balance, orderInfor2.paid, orderInfor2.amount, orderInfor2.id)
    }

    fun updateOrder2(id: Int, orderInfor2: OrderInfor2): Boolean{

        val updatedRow = database().update(OrderInfor2Table){
            set(OrderInfor2Table.schoolName, orderInfor2.schoolName)
            set(OrderInfor2Table.schoolPhone, orderInfor2.schoolPhone)
            set(OrderInfor2Table.orderId, orderInfor2.orderId)
            set(OrderInfor2Table.balance, orderInfor2.balance)
            set(OrderInfor2Table.paid, orderInfor2.paid)
            set(OrderInfor2Table.amount, orderInfor2.amount)
            where {
                it.id eq id
            }
        }
        return updatedRow > 0
    }



    /// PRODUCT  LIST ///

    fun getAllProductNames(): List<ProductEntity>{
        return database().sequenceOf(ProductTable).toList()
    }

    fun getProductByName(name: String): ProductEntity? {
        return database().sequenceOf(ProductTable)
            .firstOrNull(){it.productName eq name}
    }

    fun addProductName(product: Product): Product {
        database().insert(ProductTable){
            set(PriceListTable.productName, product.productName)
        }
        return Product(product.productName)
    }

    fun updateProductNameByName(name: String, product: Product): Boolean{

        val updatedRow = database().update(ProductTable){
            set(ProductTable.productName, product.productName)
            where {
                it.productName eq name
            }
        }
        return updatedRow > 0
    }

    fun deleteProductByName(name: String): Boolean{
        val deleteRow = database().delete(ProductTable){
            it.productName eq name
        }
        return deleteRow > 0
    }




    /// PRODUCTION  LIST ///

    fun getAllTotalProduction(): List<TotalProductionEntity>{
        return database().sequenceOf(TotalProductionTable).toList()
    }

    fun getProductByProductName(name: String): TotalProductionEntity? {
        return database().sequenceOf(TotalProductionTable)
            .firstOrNull(){it.productName eq name}
    }

    fun addProduct(totalProduction: TotalProduction): TotalProduction {
        database().insert(TotalProductionTable){
            set(TotalProductionTable.productName, totalProduction.productName)
            set(TotalProductionTable.quantityAdd, totalProduction.quantityAdd)
            set(TotalProductionTable.currentdate, totalProduction.currentDate)
        }
        return TotalProduction(totalProduction.productName, totalProduction.quantityAdd,
            totalProduction.currentDate, totalProduction.id)
    }

    fun updateProductRecordById(id: Int, product: TotalProduction): Boolean{
        val updatedRow = database().update(TotalProductionTable){
            set(TotalProductionTable.productName, product.productName)
            set(TotalProductionTable.quantityAdd, product.quantityAdd)
            set(TotalProductionTable.currentdate, product.currentDate)
            where {
                it.id eq id
            }
        }
        return updatedRow > 0
    }

    fun sumProductQuantity(productName: String): String {
        return database().sequenceOf(TotalProductionTable).toList().filter {
            it.productName == productName
        }.sumOf { it.quantityAdd }.toString()
    }


    /// PAYMENT  HISTORY ///

    fun getAllPayment(): List<PaymentHistoryEntity>{
        return database().sequenceOf(PaymentHistoryTable).toList()
    }

    fun getById(id: Int): PaymentHistoryEntity? {
        return database().sequenceOf(PaymentHistoryTable)
            .firstOrNull(){it.id eq id}
    }

    fun getPaymentHistoryByOrderId(orderId: Int): List<PaymentHistoryEntity> {
        return database().sequenceOf(PaymentHistoryTable).toList().filter {
            it.orderId == orderId
        }
    }


    fun addPayment(paymentHistory: PaymentHistory): PaymentHistory {
        database().insert(PaymentHistoryTable){
            set(PaymentHistoryTable.paidDate, paymentHistory.paidDate)
            set(PaymentHistoryTable.modifiedPaymentDate, paymentHistory.modifiedPaymentDate)
            set(PaymentHistoryTable.orderId, paymentHistory.orderId)
            set(PaymentHistoryTable.amount, paymentHistory.amount)
            set(PaymentHistoryTable.id, paymentHistory.id)
        }
        return PaymentHistory(paymentHistory.paidDate, paymentHistory.modifiedPaymentDate,
            paymentHistory.orderId, paymentHistory.amount, paymentHistory.id)
    }


    fun updatePayment(id: Int, paymentHistory: PaymentHistory): Boolean{
        val updatedRow = database().update(PaymentHistoryTable){
            set(PaymentHistoryTable.paidDate, paymentHistory.paidDate)
            set(PaymentHistoryTable.modifiedPaymentDate, paymentHistory.modifiedPaymentDate)
            set(PaymentHistoryTable.orderId, paymentHistory.orderId)
            set(PaymentHistoryTable.amount, paymentHistory.amount)
            set(PaymentHistoryTable.id, paymentHistory.id)

            where {
                it.id eq id
            }
        }
        return updatedRow > 0
    }






}