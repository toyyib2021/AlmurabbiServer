package com.schooladmin.route

import com.schooladmin.database.MYSQLUserRepository
import com.schooladmin.model.data.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.dbRoute() {

    val dBRepo = MYSQLUserRepository()

    /// CUSTOMER'S ROUTES ///
    get("/allCustomers") {
        call.respond(dBRepo.getAllCustomer())

    }

    get("/GetCustomerBySchoolName/{schoolName}") {
        val schoolName = call.parameters["schoolName"]

        if (schoolName == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong schoolName"
            )
            return@get
        }

        val customers = dBRepo.getCustomerBySchoolName(schoolName)
        if (customers == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(customers)
        }


    }

    post("/addCustomer") {
        val customerObject = call.receive<Customers>()
        val customer = dBRepo.addCustomer(customerObject)
        call.respond(customer)
    }

    put ("/updateCustomer/{schoolName}"){
        val schoolName = call.parameters["schoolName"]

        if (schoolName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong schoolName"
            )
            return@put
        }
        val customersObject = call.receive<Customers>()
        val update = dBRepo.updateCustomer(schoolName, customersObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }

    delete ("/delete/{schoolName}") {
        val schoolName = call.parameters["schoolName"]

        if (schoolName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong schoolName"
            )
            return@delete
        }
        val delete = dBRepo.delete(schoolName = schoolName)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


    /// PRICE LIST ROUTES ///
    get("/allPriceList") {
        call.respond(dBRepo.getAllPriceList())
    }

    get("/getPriceByProductName/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@get
        }

        val productPrice = dBRepo.getPriceByProductName(productName)
        if (productPrice == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(productPrice)
        }


    }

    post("/addProductPrice") {
        val productPriceObject = call.receive<PriceList>()
        val priceList = dBRepo.addPriceList(productPriceObject)
        call.respond(priceList)
    }

    put ("/updatePriceList/{productName}"){
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val priceListObject = call.receive<PriceList>()
        val update = dBRepo.updatePriceList(productName, priceListObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }

    delete ("/deleteProductPrice/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong schoolName"
            )
            return@delete
        }
        val delete = dBRepo.deletePrice(productName)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


    /// PRICE LIST FOR REP ROUTES ///
    get("/getAllPriceRepList") {
        call.respond(dBRepo.getAllPriceRepList())
    }

    get("/getPriceRepByProductName/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@get
        }

        val productPrice = dBRepo.getPriceRepByProductName(productName)
        if (productPrice == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(productPrice)
        }


    }

    post("/addPriceRepList") {
        val productPriceObject = call.receive<PriceListRep>()
        val priceList = dBRepo.addPriceRepList(productPriceObject)
        call.respond(priceList)
    }

    put ("/updatePriceRepList/{productName}"){
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val priceListObject = call.receive<PriceListRep>()
        val update = dBRepo.updatePriceRepList(productName, priceListObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }

    delete ("/deletePriceRep/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@delete
        }
        val delete = dBRepo.deletePriceRep(productName)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


    /// PRICE LIST FOR KANO ROUTES ///

    get("/getAllPriceDiscountList") {
        call.respond(dBRepo.getAllPriceDiscountList())
    }

    get("/getPriceDiscountByProductName/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@get
        }

        val productPrice = dBRepo.getPriceDiscountByProductName(productName)
        if (productPrice == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(productPrice)
        }


    }

    post("/addPriceDiscountList") {
        val productPriceObject = call.receive<DiscountPriceList>()
        val priceList = dBRepo.addPriceDiscountList(productPriceObject)
        call.respond(priceList)
    }

    put ("/updatePriceDiscountList/{productName}"){
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val priceListObject = call.receive<DiscountPriceList>()
        val update = dBRepo.updatePriceDiscountList(productName, priceListObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }

    delete ("/deletePriceDiscount/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong schoolName"
            )
            return@delete
        }
        val delete = dBRepo.deletePriceDiscount(productName)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


    /// ORDER LIST ROUTES ///

    get("/allOrderList") {
        call.respond(dBRepo.getAllOrders())
    }

    get("/sumOrderAmount/{orderId}") {
        val orderId = call.parameters["orderId"]?.toInt()
        if (orderId == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val orders = dBRepo.sumOrderAmount(orderId)
        call.respond(orders)
    }

    get("/getOrderByOrderId/{orderId}") {
        val orderId = call.parameters["orderId"]?.toInt()

        if (orderId == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val orders = dBRepo.getOrderByOrderId(orderId)
        call.respond(orders)


    }

    post("/addOrder") {
        val orderObject = call.receive<OrderInfor>()
        val addOrder = dBRepo.addOrder(orderObject)
        call.respond(addOrder)
    }

    post("/addListOfOrder") {
        val listOfOrderObject = call.receive<List<OrderInfor>>()
        val addListOrder = dBRepo.addListOfOrder(listOfOrderObject)
        call.respond(addListOrder)
    }

    put ("/updateOrder/{id}"){
        val id = call.parameters["id"]?.toInt()

        if (id == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val updatedOrdertObject = call.receive<OrderInfor>()
        val update = dBRepo.updateOrder(id, updatedOrdertObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }



    /// ORDER 2 LIST ROUTES ///

    get("/getAllOrder2") {
        call.respond(dBRepo.getAllOrder2())
    }

    get("/getOrder2ById/{id}") {
        val id = call.parameters["id"]?.toInt()

        if (id == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val orders2 = dBRepo.getOrder2ById(id)
        if (orders2 == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(orders2)
        }
    }

    get("/getOrder2BySchoolName/{schoolName}") {
        val schoolName = call.parameters["schoolName"]
        if (schoolName == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val orders = dBRepo.getOrder2BySchoolName(schoolName)
        call.respond(orders)
    }

    get("/getWherePaidEqAmount") {
        call.respond(dBRepo.getWherePaidEqAmount())
    }

    get("/getWherePaidIsNotEqAmount") {
        call.respond(dBRepo.getWherePaidIsNotEqAmount())
    }

    post("/addOrderInfor2") {
        val orderObject2 = call.receive<OrderInfor2>()
        val addOrder2 = dBRepo.addOrderInfor2(orderObject2)
        call.respond(addOrder2)
    }

    put ("/updateOrder2/{id}"){
        val id = call.parameters["id"]?.toInt()

        if (id == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val updatedOrdertObject = call.receive<OrderInfor2>()
        val update = dBRepo.updateOrder2(id, updatedOrdertObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }

    }


    /// PRODUCT NAMES ROUTES ///

    get("/getAllProductNames") {
        call.respond(dBRepo.getAllProductNames())
    }

    get("/getProductByName/{name}") {
        val name = call.parameters["name"]

        if (name == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val productName = dBRepo.getProductByName(name)
        if (productName == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(productName)
        }
    }

    post("/addProductName") {
        val product = call.receive<Product>()
        val addProduct = dBRepo.addProductName(product)
        call.respond(addProduct)
    }

    put ("/updateProductNameByName/{name}"){
        val name = call.parameters["name"]

        if (name == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@put
        }
        val updatedOrdertObject = call.receive<Product>()
        val update = dBRepo.updateProductNameByName(name, updatedOrdertObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }

    delete ("/deleteProductByName/{productName}") {
        val productName = call.parameters["productName"]

        if (productName == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong productName"
            )
            return@delete
        }
        val delete = dBRepo.deleteProductByName(productName)
        if (delete){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


    /// PRODUCTION RECORD ROUTES ///

    get("/getAllTotalProduction") {
        call.respond(dBRepo.getAllTotalProduction())
    }

    get("/getProductByProductName/{name}") {
        val name = call.parameters["name"]

        if (name == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong product name"
            )
            return@get
        }

        val productName = dBRepo.getProductByProductName(name)
        if (productName == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(productName)
        }
    }

    post("/addProduct") {
        val product = call.receive<TotalProduction>()
        val addProduct = dBRepo.addProduct(product)
        call.respond(addProduct)
    }

    put ("/updateProductRecordById/{id}"){
        val id = call.parameters["id"]?.toInt()

        if (id == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong id"
            )
            return@put
        }
        val updatedOrdertObject = call.receive<TotalProduction>()
        val update = dBRepo.updateProductRecordById(id, updatedOrdertObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }

    get("/sumProductQuantity/{name}") {
        val name = call.parameters["name"]

        if (name == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong product name"
            )
            return@get
        }

        val productName = dBRepo.sumProductQuantity(name)
        call.respond(productName)
    }




    /// PAYMENT  HISTORY ********************///

    get("/getAllPayment") {
        call.respond(dBRepo.getAllPayment())
    }

    get("/getPaymentById/{id}") {
        val id = call.parameters["id"]?.toInt()

        if (id == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong id"
            )
            return@get
        }

        val paymentDetails = dBRepo.getById(id)
        if (paymentDetails == null) {
            call.respond(HttpStatusCode.BadRequest,)
        } else {
            call.respond(paymentDetails)
        }
    }

    get("/getPaymentHistoryByOrderId/{id}") {
        val orderId = call.parameters["id"]?.toInt()

        if (orderId == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong orderId"
            )
            return@get
        }

        val productName = dBRepo.getPaymentHistoryByOrderId(orderId)
        call.respond(productName)
    }

    post("/addPayment") {
        val payment = call.receive<PaymentHistory>()
        val addPayment = dBRepo.addPayment(payment)
        call.respond(addPayment)
    }

    put ("/updatePayment/{id}"){
        val id = call.parameters["id"]?.toInt()

        if (id == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "wrong id"
            )
            return@put
        }
        val updatedPaymentObject = call.receive<PaymentHistory>()
        val update = dBRepo.updatePayment(id, updatedPaymentObject)
        if (update){
            call.respond(HttpStatusCode.OK)
        }else{
            call.respond(HttpStatusCode.NotFound)
        }
    }


















}

