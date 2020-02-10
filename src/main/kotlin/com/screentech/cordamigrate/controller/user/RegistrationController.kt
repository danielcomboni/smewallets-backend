package com.screentech.cordamigrate.controller.user

import com.screentech.cordamigrate.dao.user.RegistrationRepository
import com.screentech.cordamigrate.entity.user.Registration
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/registrations")
class RegistrationController : CRUDAbstract<Registration>(){

    @Autowired
    lateinit var registrationRepository: RegistrationRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Registration): ResponseEntity<*> {
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.timestamp = getCurrentTimestampSQL()
        return JSONUtilsKT.ok(this.registrationRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Registration): ResponseEntity<*> {
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        return JSONUtilsKT.ok(this.registrationRepository.save(anObject))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> =  JSONUtilsKT.ok(this.registrationRepository.findAll())

    @GetMapping("findByEmail/{email}")
    override fun findByEmail(@PathVariable email: String): ResponseEntity<*> = JSONUtilsKT.ok(this.registrationRepository.findRegistrationByEmail(email))

    @GetMapping("/findById/{id}")
    override fun findById(id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.findById(id))

}
