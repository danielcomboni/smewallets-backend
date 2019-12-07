package com.screentech.cordamigrate.controller.user

import com.screentech.cordamigrate.dao.user.RegistrationRepository
import com.screentech.cordamigrate.entity.user.Registration
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/registrations")
class RegistrationController{

    @Autowired
    lateinit var registrationRepository: RegistrationRepository

    @PostMapping("/create")
    fun aNewRegistration(@RequestBody registration: Registration) : ResponseEntity<*> = JSONUtilsKT.ok(this.registrationRepository.saveAndFlush(registration))

    @GetMapping("/findAll")
    fun findAllRegistrations() : ResponseEntity<*> = JSONUtilsKT.ok(this.registrationRepository.findAll())

    @GetMapping("findById/{id}")
    fun findRegitrationById(@PathVariable id: BigDecimal) : ResponseEntity<*> = JSONUtilsKT.ok((this.registrationRepository.findById(id)))

    @GetMapping("findByEmail/{email}")
    fun findRegistrationByEmail(@PathVariable email : String) : ResponseEntity<*> = JSONUtilsKT.ok(this.registrationRepository.findRegistrationByEmail(email))

    @PutMapping("/update")
    fun updateRegistration(@RequestBody registration: Registration) : ResponseEntity<*> = JSONUtilsKT.ok(this.registrationRepository.saveAndFlush(registration))

}