package com.screentech.cordamigrate.controller.wallet

import com.screentech.cordamigrate.dao.wallet.WalletRepository
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/wallets")
class WalletController : CRUDAbstract<Wallet>() {

    @Autowired
    lateinit var walletRepository: WalletRepository

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*>  = JSONUtilsKT.ok(this.walletRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: BigDecimal): ResponseEntity<*> = JSONUtilsKT.ok(this.walletRepository.findById(id))

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Wallet): ResponseEntity<*> = JSONUtilsKT.ok(this.walletRepository.saveAndFlush(anObject))

    @PutMapping("/update/{id}")
    fun updatE(@RequestBody anObject: Wallet, @PathVariable id:BigDecimal): ResponseEntity<*> = JSONUtilsKT.ok(this.walletRepository.saveAndFlush(anObject));

}