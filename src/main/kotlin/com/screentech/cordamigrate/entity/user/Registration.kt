package com.screentech.cordamigrate.entity.user

import com.screentech.cordamigrate.utility.getCurrentSQLDate
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "registration")
class Registration(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name  = "id") var id : BigDecimal,
        @Column(name = "user_id") var userId : BigDecimal,
        @Column( name = "industry_type") var industryType : String?,
        @Column(name = "name") var name : String?,
        @Column(name = "email") var email : String?,
        @Column(name = "address") var address : String?,
        @Column(name = "contact_number") var contactNumber : String?,
        @Column(name = "city") var city : String,
        @Column(name = "state") var state : String?,
        @Column(name = "country") var country : String?,
        @Column(name = "zip") var zip : String?,
        @Column(name = "cor_address")   var corAddress : String?,
        @Column(name  = "cor_city") var corCity : String?,
        @Column(name = "cor_state") var corState : String?,
        @Column(name = "cor_country") var corCountry  :String?,
        @Column(name = "cor_zip_code") var corZipCode : String?,
        @Column(name = "company_name") var companyName  :String?,
        @Column(name="cr_name") var crName : String?,
        @Column(name = "company_email") var companyEmail : String?,
        @Column(name = "company_address") var companyAddress : String?,
        @Column(name = "the_timestamp") var timestamp : Timestamp = getCurrentTimestampSQL()

){

}