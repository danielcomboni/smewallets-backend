package com.screentech.cordamigrate.controller.invites

import com.screentech.cordamigrate.dao.invites.InvitesRepository
import com.screentech.cordamigrate.entity.invites.Invite
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/invites")
class InvitesController : CRUDAbstract<Invite>(){

    @Autowired
    lateinit var invitesRepository: InvitesRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Invite): ResponseEntity<*> = JSONUtilsKT.ok(this.invitesRepository.save(anObject))

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Invite): ResponseEntity<*> = JSONUtilsKT.ok(this.invitesRepository.save(anObject))

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> = JSONUtilsKT.ok(this.invitesRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.invitesRepository.findById(id))

    @GetMapping("/findByEmail/{email}")
    override fun findByEmail(@PathVariable email: String): ResponseEntity<*> = JSONUtilsKT.ok(this.invitesRepository.findByEmail(email))
}