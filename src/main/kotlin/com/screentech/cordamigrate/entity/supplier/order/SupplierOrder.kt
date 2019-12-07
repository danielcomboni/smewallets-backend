package com.screentech.cordamigrate.entity.supplier.order

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentDateFromJavaUtil
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "supplier_order")
class SupplierOrder(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : BigDecimal,
        @OneToOne @JoinColumn(name="user_id") var user: User,
        @Column(name = "invite_code") var inviteCode : String,
        @Column(name = "name") var name  : String,
        @Column(name = "email") var email : String,
        @Column(name = "the_timestamp") var timestamp: Timestamp = getCurrentTimestampSQL()
)