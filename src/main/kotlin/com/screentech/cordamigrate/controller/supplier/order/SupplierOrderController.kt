package com.screentech.cordamigrate.controller.supplier.order

import com.screentech.cordamigrate.dao.supplier.order.SupplierOrderRepository
import com.screentech.cordamigrate.entity.supplier.order.SupplierOrder
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/supplierOrders")
class SupplierOrderController : CRUDAbstract<SupplierOrder>(){

    @Autowired
    lateinit var supplierOrderRepository: SupplierOrderRepository

    fun getTheObject(anObject: SupplierOrder): SupplierOrder {

        anObject.order.buyer?.emailVerifiedAt = parseStringToTimestamp(anObject.order.timestampStr)
        anObject.order.supplier?.emailVerifiedAt = parseStringToTimestamp(anObject.order.supplier?.emailVerifiedAtStr)
        anObject.order.wallet?.timestamp = parseStringToTimestamp(anObject.order. wallet?.timestampStr)

        return anObject

    }
    
    @PostMapping("/create")
    override fun create(@RequestBody anObject: SupplierOrder): ResponseEntity<*> {

        var theObject = getTheObject(anObject)
        theObject.timestamp = getCurrentTimestampSQL()

        return JSONUtilsKT.ok(this.supplierOrderRepository.save(theObject))

    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: SupplierOrder): ResponseEntity<*> {

        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        var theObject = getTheObject(anObject)
        theObject.order.timestamp = parseStringToTimestamp(anObject.timestampStr)
        
        return JSONUtilsKT.ok(this.supplierOrderRepository.save(theObject))

    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.findById(id))

//    @GetMapping("findByEmail/{email}")
//    override fun findByEmail(@PathVariable email: String): ResponseEntity<*>  = JSONUtilsKT.ok(this.supplierOrderRepository.findByEmail(email))
}
