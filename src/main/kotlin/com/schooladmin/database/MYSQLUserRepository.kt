package com.schooladmin.database


import com.schooladmin.repository.Repository
import com.schooladmin.model.*
import com.schooladmin.model.data.*

class MYSQLUserRepository: Repository {

    private val database = DatabaseManager()


    /// CUSTOMER
    override fun getAllCustomer(): List<Customers> {
        return database.getAllCustomer()
            .map { it ->
                Customers(it.schoolName, it.schoolRepName, it.address,
                    it.schoolPhoneNumber, it.repPhoneNumber) }
    }

    override fun addCustomer(customers: Customers): Customers {
        return database.addCustomer(customers)
    }

    override fun updateCustomer(schoolName: String, customers: Customers): Boolean {
        return database.updateCustomer(schoolName, customers)
    }

    override fun getCustomerBySchoolName(schoolName: String): Customers? {
        return database.getCustomer(schoolName)
            ?.let { Customers(it.schoolName, it.schoolRepName, it.address,
                it.schoolPhoneNumber, it.repPhoneNumber)}
    }

    override fun delete(schoolName: String): Boolean {
        return database.deleteCustomer(schoolName)
    }


    /// PRICE LIST
    override fun addPriceList(priceList: PriceList): PriceList {
        return database.addPriceList(priceList)
    }

    override fun getAllPriceList(): List<PriceList> {
        return database.getAllPriceList()
            .map { it ->
                PriceList(it.productName, it.price)
            }
    }

    override fun updatePriceList(productName: String, priceList: PriceList): Boolean {
        return database.updatePriceList(productName, priceList)
    }

    override fun getPriceByProductName(productName: String): PriceList? {
        return database.getPriceByProductName(productName)
            ?.let { PriceList(it.productName, it.price) }
    }

    override fun deletePrice(productName: String): Boolean {
        return database.deletePrice(productName)
    }


    /// PRICE LIST REP ************

    override fun getAllPriceRepList(): List<PriceListRep> {
        return database.getAllPriceRepList().toList().map {
            PriceListRep(it.productName, it.price)
        }
    }

    override fun getPriceRepByProductName(productName: String): PriceListRep? {
        return database.getPriceRepByProductName(productName)?.let {
            PriceListRep(it.productName, it.price)
        }
    }

    override fun addPriceRepList(priceRepList: PriceListRep): PriceListRep {
        return database.addPriceRepList(priceRepList)
    }

    override fun updatePriceRepList(productName: String, priceListRep: PriceListRep): Boolean {
        return database.updatePriceRepList(productName, priceListRep)
    }

    override fun deletePriceRep(productName: String): Boolean {
        return database.deletePriceRep(productName)
    }


    /// PRICE LIST **************

    override fun getAllPriceDiscountList(): List<DiscountPriceList> {
        return database.getAllPriceDiscountList().map {
            DiscountPriceList(it.productName, it.price)
        }
    }

    override fun getPriceDiscountByProductName(productName: String): DiscountPriceList? {
        return database.getPriceDiscountByProductName(productName)?.let {
            DiscountPriceList(it.productName, it.price)
        }
    }

    override fun addPriceDiscountList(priceDiscountList: DiscountPriceList): DiscountPriceList {
        return database.addPriceDiscountList(priceDiscountList)
    }

    override fun updatePriceDiscountList(productName: String, discountPriceList: DiscountPriceList): Boolean {
        return database.updatePriceDiscountList(productName, discountPriceList)
    }

    override fun deletePriceDiscount(productName: String): Boolean {
        return database.deletePriceDiscount(productName)
    }


    // ORDER ***************

    override fun getAllOrders(): List<OrderInfor> {
        return database.getAllOrders()
            .map { it ->
                OrderInfor(it.productName, it.quantity, it.orderId,
                    it.returned, it.currentdate, it.unitPrice, it.amount, it.id)
            }
    }

    override fun getOrderByOrderId(orderId: Int): List<OrderInfor> {
        return database.getOrderByOrderId(orderId)
            .map { OrderInfor(it.productName, it.quantity, it.orderId,
                it.returned, it.currentdate, it.unitPrice, it.amount, it.id)
            }

    }

    override fun sumOrderAmount(orderId: Int): String {
        return database.sumOrderAmount(orderId)
    }

    override fun addOrder(orderInfor: OrderInfor): OrderInfor {
        return database.addOrder(orderInfor)
    }

    override fun addListOfOrder(listOfOrderInfor: List<OrderInfor>): List<OrderInfor> {
        return database.addListOfOrder(listOfOrderInfor)
    }

    override fun updateOrder(id: Int, orderInfor: OrderInfor): Boolean {
        return database.updateOrder(id, orderInfor)
    }


    // ORDER 2 ***************

    override fun getAllOrder2(): List<OrderInfor2> {
        return database.getAllOrder2().map {
            OrderInfor2(it.schoolName, it.schoolPhone, it.orderId,
                it.balance, it.paid, it.amount, it.id)
        }
    }

    override fun getOrder2ById(id: Int): OrderInfor2? {
        return database.getOrder2ById(id)
            ?.let {
                OrderInfor2(it.schoolName, it.schoolPhone, it.orderId,
                    it.balance, it.paid, it.amount, it.id)
            }
    }

    override fun getOrder2BySchoolName(schoolName: String): List<OrderInfor2> {
        return database.getOrder2BySchoolName(schoolName).map {
            OrderInfor2(it.schoolName, it.schoolPhone, it.orderId,
                it.balance, it.paid, it.amount, it.id)
        }
    }

    override fun getWherePaidEqAmount(): List<OrderInfor2> {
        return database.getWherePaidEqAmount().map {
            OrderInfor2(it.schoolName, it.schoolPhone, it.orderId,
                it.balance, it.paid, it.amount, it.id)
        }
    }

    override fun getWherePaidIsNotEqAmount(): List<OrderInfor2> {
        return database.getWherePaidIsNotEqAmount().map {
            OrderInfor2(it.schoolName, it.schoolPhone, it.orderId,
                it.balance, it.paid, it.amount, it.id)
        }
    }

    override fun addOrderInfor2(orderInfor2: OrderInfor2): OrderInfor2 {
        return database.addOrderInfor2(orderInfor2)
    }

    override fun updateOrder2(id: Int, orderInfor2: OrderInfor2): Boolean {
        return database.updateOrder2(id, orderInfor2)
    }


    // PRODUCT ***************

    override fun getAllProductNames(): List<Product> {
        return database.getAllProductNames().map {
            Product(it.productName)
        }
    }

    override fun getProductByName(name: String): Product? {
        return database.getProductByName(name)?.let {
            Product(it.productName)
        }
    }

    override fun addProductName(product: Product): Product {
        return database.addProductName(product)
    }

    override fun updateProductNameByName(name: String, product: Product): Boolean {
        return database.updateProductNameByName(name, product)
    }

    override fun deleteProductByName(name: String): Boolean {
        return database.deleteProductByName(name)
    }



    // PRODUCTION RECORD ***************

    override fun getAllTotalProduction(): List<TotalProduction> {
        return database.getAllTotalProduction().map {
            TotalProduction(it.productName, it.quantityAdd, it.currentdate, it.id)
        }
    }

    override fun getProductByProductName(name: String): TotalProduction? {
        return database.getProductByProductName(name)?.let {
            TotalProduction(it.productName, it.quantityAdd, it.currentdate, it.id)

        }
    }

    override fun addProduct(totalProduction: TotalProduction): TotalProduction {
        return database.addProduct(totalProduction)
    }

    override fun updateProductRecordById(id: Int, product: TotalProduction): Boolean {
        return database.updateProductRecordById(id, product)
    }

    override fun sumProductQuantity(productName: String): String {
        return database.sumProductQuantity(productName)
    }


    /// PAYMENT  HISTORY ********************///

    override fun getAllPayment(): List<PaymentHistory> {
        return database.getAllPayment().map {
            PaymentHistory(it.paidDate, it.modifiedPaymentDate, it.orderId, it.amount, it.id)
        }
    }

    override fun getById(id: Int): PaymentHistory? {
        return database.getById(id)?.let {
            PaymentHistory(it.paidDate, it.modifiedPaymentDate, it.orderId, it.amount, it.id)
        }
    }

    override fun getPaymentHistoryByOrderId(orderId: Int): List<PaymentHistory> {
        return database.getPaymentHistoryByOrderId(orderId).map {
            PaymentHistory(it.paidDate, it.modifiedPaymentDate, it.orderId, it.amount, it.id)
        }
    }

    override fun addPayment(paymentHistory: PaymentHistory): PaymentHistory {
        return database.addPayment(paymentHistory)
    }

    override fun updatePayment(id: Int, paymentHistory: PaymentHistory): Boolean {
        return database.updatePayment(id, paymentHistory)
    }


}