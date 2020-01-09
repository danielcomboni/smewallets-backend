package com.screentech.cordamigrate.entity.securityquestion

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "security_questions")
class SecurityQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null
    @Column(name = "question")
    var question: String? = null
    @Column(name = "the_timestamp", updatable = true, insertable = true)
    var timestamp: Date? = null

    override fun toString(): String {
        return "SecurityQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", timestamp=" + timestamp +
                '}'
    }
}