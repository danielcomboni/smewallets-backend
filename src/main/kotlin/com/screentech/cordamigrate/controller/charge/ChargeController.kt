package com.screentech.cordamigrate.controller.charge

import com.screentech.cordamigrate.dao.charge.ChargeRepository
import com.screentech.cordamigrate.entity.charges.Charge
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/charges")
class ChargeController : CRUDAbstract<Charge>() {

    @Autowired
    lateinit var chargeRepository: ChargeRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Charge): ResponseEntity<*> {
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr)
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr)
        return JSONUtilsKT.ok(this.chargeRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Charge): ResponseEntity<*>  {
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr)
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr)
        return JSONUtilsKT.ok(this.chargeRepository.save(anObject))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*>  = JSONUtilsKT.ok(this.chargeRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.chargeRepository.findById(id))

}
