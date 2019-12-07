package com.screentech.cordamigrate.controller.session

import com.screentech.cordamigrate.dao.session.SessionRepository
import com.screentech.cordamigrate.entity.session.Session
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/sessions")
class SessionController{
    @Autowired
    lateinit var sessionRepository: SessionRepository

    @PostMapping("/create")
    fun aNewSession(@RequestBody session : Session) : ResponseEntity<*> = JSONUtilsKT.ok(this.sessionRepository.saveAndFlush(session))

//    @GetMapping("/findByEmail/{email}")
//    fun findByEmail(@PathVariable email : String) : ResponseEntity<*>  = JSONUtilsKT.ok(this.sessionRepository.findByEmail(email))
}