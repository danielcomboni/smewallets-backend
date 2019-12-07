package com.screentech.cordamigrate.entity.wallet

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table
class Wallet(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id") var id : BigDecimal?,
        @Column(name = "name") var name : String?,
        @Column(name = "the_timestamp") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
        @JoinColumn(name = "user_id") var user : User?,
        @Transient var timestampStr:String? = ""

        )