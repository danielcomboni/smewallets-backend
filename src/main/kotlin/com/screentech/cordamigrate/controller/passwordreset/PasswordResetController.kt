package com.screentech.cordamigrate.controller.passwordreset

import com.screentech.cordamigrate.dao.passwordreset.PasswordResetRepository
import com.screentech.cordamigrate.entity.passwordreset.PasswordReset
import com.screentech.cordamigrate.utility.JSONUtilsKT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/smewallets/passwordresets")
class PasswordResetController {

    @Autowired
    lateinit var passwordResetRepository: PasswordResetRepository

    @PostMapping("/create")
    fun resetPassword(@RequestBody passwordReset: PasswordReset) : ResponseEntity<*> = JSONUtilsKT.ok(this.passwordResetRepository.save(passwordReset))


}