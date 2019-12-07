package com.screentech.cordamigrate.entity.user

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name="users")
class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : BigDecimal?,
        @Column(name="email") var email : String,
        @Column(name="email_verified_at") var emailVerifiedAt: Timestamp? = getCurrentTimestampSQL(),
        @Transient var emailVerifiedAtStr : String?,


        @Column(name="password") var  password : String,
        @Column(name="phone_number") var phoneNumber : String,
        @Column(name="ref_user_id") var refUserId:BigDecimal,
        @Column(name = "name") var name:String

)
{

    override fun toString(): String {
        return "User(id=$id, email='$email', emailVerifiedAt=$emailVerifiedAt, password='$password', phoneNumber='$phoneNumber', refUserId=$refUserId, name='$name')"
    }
}
