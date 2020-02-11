package com.screentech.cordamigrate.controller.user

import org.springframework.beans.factory.annotation.Autowired
import com.screentech.cordamigrate.dao.user.UserRepository;
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.service.user.UserServiceImpl
import com.screentech.cordamigrate.utility.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/users")
class UserController : CRUDAbstract<User>(){

    @Autowired
    lateinit var userServiceImpl: UserServiceImpl

    @Autowired
    lateinit var userRepository: UserRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: User): ResponseEntity<*> {
        anObject.emailVerifiedAt = getCurrentTimestampSQL()
        return JSONUtilsKT.ok(this.userRepository.save(anObject))
    }

    @PutMapping("/update")
    fun updateAUser(@RequestBody user: User) : ResponseEntity<*> {
        user.emailVerifiedAt = parseStringToTimestamp(user.emailVerifiedAtStr)
        return JSONUtilsKT.ok(this.userRepository.save(user))
    }

    @DeleteMapping("/delete")
    fun deleteAUser(@RequestBody user: User) : ResponseEntity<*> = JSONUtilsKT.ok(this.userRepository.delete(user))

    @GetMapping("/findAll")
    override fun findAll() : ResponseEntity<*> = JSONUtilsKT.ok(this.userRepository.findAll())

    @GetMapping("/findUserByEmail/{email}")
    fun findUserByEmail(@PathVariable email:String) : ResponseEntity<*> = JSONUtilsKT.ok(this.userRepository.findUsersByEmail(email))

}
