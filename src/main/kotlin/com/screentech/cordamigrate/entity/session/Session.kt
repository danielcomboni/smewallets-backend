package com.screentech.cordamigrate.entity.session

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "session")
class Session(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name  = "id") var id : Long,
        @OneToOne(cascade = arrayOf(CascadeType.PERSIST)) @JoinColumn(name = "user_id") var userId : User,
        @Column(name = "ip_address") var ipAddress : String,
        @Column(name = "user_agent") var userAgent : String,
        @Column(name = "payload",columnDefinition = "text") var payload : String,
        @Column(name = "last_activity") var lastActivity : BigDecimal,
        @Column(name = "the_timestamp", columnDefinition = "timestamp") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr: String?
        ){
        override fun toString(): String {
                return "Session(id=$id, userId=$userId, ipAddress='$ipAddress', userAgent='$userAgent', payload='$payload', lastActivity=$lastActivity, timestamp=$timestamp, timestampStr=$timestampStr)"
        }
}