//package com.screentech.cordamigrate.entity.user;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.sql.Timestamp;
//
//@Entity
//@Table(name="users")
//public class User {
//
//    /**
//     * The id of user. It is auto incremented
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id")
//    private BigDecimal id;
//
//    /**
//     * The email of the user. It has to be provided at registration / sign up
//     *
//     */
//    @Column(name="email")
//    private String email;
//
//    /**
//     * The current timestamp of user registration. This date and time value is auto generated by the server
//     */
//    @Column(name="email_verified_at", insertable = false, updatable = false)
//    private Timestamp emailVerifiedAt ;
//
//    /**
//     * This is the user password
//     */
//    @Column(name="password")
//    private String password ;
//
//    /**
//     * Phone number of the user. It will be used for the OTP (One Time Password)
//     */
//    @Column(name="phone_number")
//    private String phoneNumber ;
//
//    @Column(name="ref_user_id")
//    private BigDecimal refUserId;
//
//    @Column(name = "name")
//    private String name;
//
//    public User(){
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getId() {
//        return id;
//    }
//
//    public void setId(BigDecimal id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getEmailVerifiedAt() {
//        return emailVerifiedAt;
//    }
//
//    public void setEmailVerifiedAt(Date emailVerifiedAt) {
//        this.emailVerifiedAt = emailVerifiedAt;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public BigDecimal getRefUserId() {
//        return refUserId;
//    }
//
//    public void setRefUserId(BigDecimal refUserId) {
//        this.refUserId = refUserId;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", emailVerifiedAt=" + emailVerifiedAt +
//                ", password='" + password + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", refUserId=" + refUserId +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}