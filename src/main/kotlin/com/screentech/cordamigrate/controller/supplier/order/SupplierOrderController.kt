package com.screentech.cordamigrate.controller.supplier.order

import com.screentech.cordamigrate.dao.supplier.order.SupplierOrderRepository
import com.screentech.cordamigrate.entity.supplier.order.SupplierOrder
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/supplierOrders")
class SupplierOrderController : CRUDAbstract<SupplierOrder>(){

    @Autowired
    lateinit var supplierOrderRepository: SupplierOrderRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: SupplierOrder): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.save(anObject))

    @PutMapping("/update")
    override fun update(@RequestBody anObject: SupplierOrder): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.save(anObject))

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.supplierOrderRepository.findById(id))

//    @GetMapping("findByEmail/{email}")
//    override fun findByEmail(@PathVariable email: String): ResponseEntity<*>  = JSONUtilsKT.ok(this.supplierOrderRepository.findByEmail(email))
}
