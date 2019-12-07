package com.screentech.cordamigrate.entity.securityquestion

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentSQLDate
import java.math.BigDecimal
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "users_answers")
class UserAnswer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : BigDecimal = BigDecimal.ZERO,

    @Column(name = "user_id") var userId : BigDecimal,

    @Column(name = "question_id") var questionId : BigDecimal,

    @Column(name = "answer") var answer : BigDecimal,

    @Column(name = "the_timestamp") var timestamp : Date = getCurrentSQLDate()
)

{

}