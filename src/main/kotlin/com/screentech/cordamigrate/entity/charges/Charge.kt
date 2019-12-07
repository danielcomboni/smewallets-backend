package com.screentech.cordamigrate.entity.charges

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "charges")
class Charge(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : BigDecimal,
        @Column(name = "withholding_tax") var withHoldingTax : BigDecimal,
        @Column(name = "discount_amount") var discountAmount : BigDecimal,
        @Column(name = "transaction_fees_supplier") var transactionFeesSupplier : BigDecimal,
        @Column(name = "excise_duty_supplier") var exciseDutySupplier : BigDecimal,
        @Column(name = "transaction_fees_sponsor") var transactionFeesSponsor: BigDecimal,
        @Column(name = "excise_duty_sponsor") var exciseDutySponsor: BigDecimal,
        @Column(name = "cbr") var cbr : BigDecimal,
        @Column(name = "interest_rate") var interestRate : BigDecimal,
        @Column(name = "the_timestamp") var timestamp: Timestamp = getCurrentTimestampSQL(),
        @OneToOne(cascade = arrayOf(CascadeType.PERSIST)) @JoinColumn(name = "user_id") var user: User,
        @OneToOne(cascade = arrayOf(CascadeType.PERSIST)) @JoinColumn(name = "wallet_id") var wallet: Wallet,
        @Transient var timestampStr : String?

)