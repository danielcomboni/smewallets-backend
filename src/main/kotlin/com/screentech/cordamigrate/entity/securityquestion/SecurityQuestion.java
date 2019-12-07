package com.screentech.cordamigrate.entity.securityquestion;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "security_questions")
public class SecurityQuestion{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private BigDecimal id;

    @Column(name = "question")
    private String question;

    @Column(name = "the_timestamp", updatable = true, insertable = true)
    private Date timestamp;

    public SecurityQuestion(){

    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SecurityQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}