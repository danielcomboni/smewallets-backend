package com.screentech.cordamigrate.controller.order

import com.screentech.cordamigrate.dao.order.OrderRepository
import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.messaging.simp.SimpMessagingTemplate


@RestController
@RequestMapping("/api/smewallets/orders")
class OrderController : CRUDAbstract<Order>(){

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @Autowired
    lateinit var orderRepository: OrderRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Order): ResponseEntity<*> {
        anObject.buyer?.emailVerifiedAt = parseStringToTimestamp(anObject.buyer?.emailVerifiedAtStr)
        anObject.supplier?.emailVerifiedAt = parseStringToTimestamp(anObject.supplier?.emailVerifiedAtStr)
        anObject.timestamp = getCurrentTimestampSQL()
      return JSONUtilsKT.ok(this.orderRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Order): ResponseEntity<*> {
        anObject.buyer?.emailVerifiedAt = parseStringToTimestamp(anObject.buyer?.emailVerifiedAtStr)
        anObject.supplier?.emailVerifiedAt = parseStringToTimestamp(anObject.supplier?.emailVerifiedAtStr)
        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        return  JSONUtilsKT.ok(this.orderRepository.save(anObject))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.orderRepository.findAll())

        notificationMessage.convertAndSend("/topic/notification", result);

        return result
    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.findById(id))

    @GetMapping("/findByIsbnNumber/{isbnNumber}")
    fun findByIsbnNumber(@PathVariable isbnNumber : String) : ResponseEntity<*> = JSONUtilsKT.ok(this.orderRepository.findByIsbnNumber(isbnNumber))
}
