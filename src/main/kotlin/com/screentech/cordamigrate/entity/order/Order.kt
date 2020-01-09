package com.screentech.cordamigrate.entity.order

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "buyer_id") var user: User,
        @Column(name = "isbn_no") var isbnNumber : String,
        @Column(name = "item_name", columnDefinition = "text") var itemName : String,
        @Column(name = "item_description", columnDefinition = "text") var itemDescription : String,
        @Column(name = "billing_address",columnDefinition = "text") var billingAddress : String,
        @Column(name = "sale_unit",columnDefinition = "text") var saleUnit : String,
        @Column(name = "quantity", columnDefinition = "numeric(16,4)") var quantity: BigDecimal,
        @Column(name = "department",columnDefinition = "text") var department : String,
        @Column(name = "conveyance_method",columnDefinition = "text") var conveyanceMethod : String,
        @Column(name = "delivery_terms", columnDefinition = "text") var deliveryTerms : String,
        @Column(name = "payment_terms",columnDefinition = "text") var paymentTerms : String,
        @Column(name = "place_of_delivery",columnDefinition = "text") var placeOfDelivery : String,
        @Column(name = "delivery_time",columnDefinition = "timestamp") var deliveryTime : Timestamp?,
        @Column(name = "order_due_date",columnDefinition = "timestamp") var orderDueDate : Timestamp?,
        @Column(name = "time_period") var time_period : String,
        @Column(name = "qr_code", columnDefinition = "text") var qrCode : String,
        @OneToOne @JoinColumn(name = "wallet_id") var wallet: Wallet,
        @Column(name = "order_status",columnDefinition = "text") var orderStatus : String,
        @Column(name = "raise_invoice",columnDefinition = "text") var raiseInvoice : String,
        @Column(name = "notification_status",columnDefinition = "text") var notificationStatus : String,
        @Column(name = "the_timestamp") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
        )
