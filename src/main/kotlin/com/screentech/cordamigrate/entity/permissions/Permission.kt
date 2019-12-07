package com.screentech.cordamigrate.entity.permissions

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "permissions")
class Permission(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : BigDecimal,
        @Column(name = "name") var name : String,
        @Column(name = "guard_name") var guardName : String,
        @Column(name = "the_timestamp") var timestamp: Timestamp = getCurrentTimestampSQL()
)