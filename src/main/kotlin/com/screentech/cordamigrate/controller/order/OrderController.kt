package com.screentech.cordamigrate.controller.order

import com.screentech.cordamigrate.dao.order.OrderRepository
import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/orders")
class OrderController : CRUDAbstract<Order>(){

    @Autowired
    lateinit var orderRepository: OrderRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Order): ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.save(anObject))

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Order): ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.save(anObject))

    @GetMapping("findAll")
    override fun findAll(): ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: BigDecimal): ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.findById(id))

    @GetMapping("/findByIsbnNumber/{isbnNumber}")
    fun findByIsbnNumber(@PathVariable isbnNumber : String) : ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.findByIsbnNumber(isbnNumber))
}