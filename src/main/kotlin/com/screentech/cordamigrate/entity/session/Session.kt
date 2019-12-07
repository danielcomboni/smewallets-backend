package com.screentech.cordamigrate.entity.session

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "session")
class Session(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name  = "id") var id : BigDecimal,
        @Column(name = "user_id") var userId : BigDecimal,
        @Column(name = "ip_address") var ipAddress : String,
        @Column(name = "user_agent") var userAgent : String,
        @Column(name = "payload") var payload : String,
        @Column(name = "last_activity") var lastActivity : BigDecimal,
        @Column(name = "the_timestamp") var timestamp: Timestamp = getCurrentTimestampSQL()

        )