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
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : BigDecimal,
        @ManyToOne @JoinColumn(name = "buyer_id") var user: User,
        @Column(name = "isbn_no") var isbnNumber : String,
        @Column(name = "item_name") var itemName : String,
        @Column(name = "item_description") var itemDescription : String,
        @Column(name = "billing_address") var billingAddress : String,
        @Column(name = "sale_unit") var saleUnit : String,
        @Column(name = "quantity") var quantity: BigDecimal,
        @Column(name = "department") var department : String,
        @Column(name = "conveyance_method") var conveyanceMethod : String,
        @Column(name = "delivery_terms") var deliveryTerms : String,
        @Column(name = "payment_terms") var paymentTerms : String,
        @Column(name = "place_of_delivery") var placeOfDelivery : String,
        @Column(name = "delivery_time") var deliveryTime : String,
        @Column(name = "order_due_date") var orderDueDate : String,
        @Column(name = "time_period") var time_period : String,
        @Column(name = "qr_code") var qrCode : String,
        @OneToOne @JoinColumn(name = "wallet_id") var wallet: Wallet,
        @Column(name = "order_status") var orderStatus : String,
        @Column(name = "raise_invoice") var raiseInvoice : String,
        @Column(name = "notification_status") var notificationStatus : String,
        @Column(name = "the_timestamp") var timestamp: Timestamp = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
        )
