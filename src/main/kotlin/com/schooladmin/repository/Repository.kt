package com.schooladmin.repository

import com.schooladmin.model.data.*

interface Repository {


    /// CUSTOMER
    fun addCustomer(customers: Customers): Customers

    fun updateCustomer(schoolName: String, customers: Customers): Boolean


    fun getAllCustomer(): List<Customers>

    fun getCustomerBySchoolName(schoolName: String): Customers?

    fun delete(schoolName: String): Boolean


    /// PRICE LIST
    fun addPriceList(priceList: PriceList): PriceList

    fun updatePriceList(productName: String, priceList: PriceList): Boolean

    fun getAllPriceList(): List<PriceList>

    fun getPriceByProductName(productName: String): PriceList?

    fun deletePrice(productName: String): Boolean


    /// PRICE REP LIST ///
    fun getAllPriceRepList(): List<PriceListRep>

    fun getPriceRepByProductName(productName: String): PriceListRep?

    fun addPriceRepList(priceRepList: PriceListRep): PriceListRep

    fun updatePriceRepList(productName: String, priceListRep: PriceListRep): Boolean

    fun deletePriceRep(productName: String): Boolean



    /// PRICE DISCOUNT LIST ///

    fun getAllPriceDiscountList(): List<DiscountPriceList>

    fun getPriceDiscountByProductName(productName: String): DiscountPriceList?

    fun addPriceDiscountList(priceDiscountList: DiscountPriceList): DiscountPriceList

    fun updatePriceDiscountList(productName: String, discountPriceList: DiscountPriceList): Boolean

    fun deletePriceDiscount(productName: String): Boolean


    // ORDER

    fun getAllOrders(): List<OrderInfor>

    fun getOrderByOrderId(orderId: Int): List<OrderInfor>?

    fun sumOrderAmount(orderId: Int): String

    fun addOrder(orderInfor: OrderInfor): OrderInfor

    fun addListOfOrder(listOfOrderInfor: List<OrderInfor>): List<OrderInfor>

    fun updateOrder(id: Int, orderInfor: OrderInfor): Boolean


    /// ORDER 2

    fun getAllOrder2(): List<OrderInfor2>

    fun getOrder2ById(id: Int): OrderInfor2?

    fun getOrder2BySchoolName(schoolName: String): List<OrderInfor2>

    fun getWherePaidEqAmount(): List<OrderInfor2>

    fun getWherePaidIsNotEqAmount(): List<OrderInfor2>

    fun addOrderInfor2(orderInfor2: OrderInfor2): OrderInfor2

    fun updateOrder2(id: Int, orderInfor2: OrderInfor2): Boolean


    // PRODUCT NAMES

    fun getAllProductNames(): List<Product>

    fun getProductByName(name: String): Product?

    fun addProductName(product: Product): Product

    fun updateProductNameByName(name: String, product: Product): Boolean

    fun deleteProductByName(name: String): Boolean


    // PRODUCTION RECORD

    fun getAllTotalProduction(): List<TotalProduction>

    fun getProductByProductName(name: String): TotalProduction?

    fun addProduct(totalProduction: TotalProduction): TotalProduction

    fun updateProductRecordById(id: Int, product: TotalProduction): Boolean

    fun sumProductQuantity(productName: String): String


    /// PAYMENT  HISTORY ///

    fun getAllPayment(): List<PaymentHistory>

    fun getById(id: Int): PaymentHistory?

    fun getPaymentHistoryByOrderId(orderId: Int): List<PaymentHistory>

    fun addPayment(paymentHistory: PaymentHistory): PaymentHistory

    fun updatePayment(id: Int, paymentHistory: PaymentHistory): Boolean







}