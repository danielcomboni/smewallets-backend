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
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : Long,
        @OneToOne(cascade = arrayOf(CascadeType.PERSIST)) @JoinColumn(name="user_id") var user: User,
        @Column(name = "invite_code", columnDefinition = "text") var inviteCode : String,
        @Column(name = "name", columnDefinition = "text") var name  : String,
        @Column(name = "email") var email : String,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr: String?
){
    override fun toString(): String {
        return "SupplierOrder(id=$id, user=$user, inviteCode='$inviteCode', name='$name', email='$email', timestamp=$timestamp, timestampStr=$timestampStr)"
    }
}