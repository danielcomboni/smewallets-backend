package com.screentech.cordamigrate.entity.invoices

import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "invoices")
class Invoice (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: BigDecimal,
        @OneToOne @JoinColumn(name = "order_id") var order : Order,
        @OneToOne @JoinColumn(name = "sponsor_id") var sponsor: User,
        @OneToOne @JoinColumn(name = "wallet_id") var wallet: Wallet,
        @Column(name = "invoice_date") var invoiceDate: Timestamp = getCurrentTimestampSQL(),
        @Column(name = "invoice_due_date") var invoiceDueDate: Timestamp,
        @Column(name = "invoice_status") var invoiceStatus: String,
        @Column(name = "transaction_fee_percentage") var transactionFeePercentage: BigDecimal,
        @Column(name = "transaction_fees") var transactionFees: BigDecimal,
        @Column(name = "interest_rate") var interestRate: BigDecimal,
        @Column(name = "amount_to_pay") var amountToPay : BigDecimal,
        @Column(name = "withholding_amount") var withHoldingAmount : BigDecimal,
        @Column(name = "withholding_tax_percentage") var withHoldingTaxPercentage: BigDecimal,
        @Column(name = "notification_status") var notificationStatus : String,
        @Column(name = "buyer_notification_status") var buyerNotificationStatus : String,
        @Column(name = "decline_reason") var declineReason : String,
        @Column(name = "get_paid") var getPaid : Boolean,
        @Column(name = "authorize_status") var authorizeStatus : Boolean,
        @Column(name = "sponsor_status") var sponsorStatus : Boolean,
        @Column(name = "the_timestamp") var theTimestamp: Timestamp?,

        @Transient var theTimestampStr : String?,
        @Transient var invoiceDateStr : String?,
        @Transient var invoiceDueDateStr : String?

)
