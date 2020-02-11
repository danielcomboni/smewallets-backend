/**
 * @author Daniel Comboni
 *
 * This class exposes REST endpoints for the entity class @class Invoice
 * It extends the @class CRUDAbstract<T> which takes a generic class.
 * The generic class is the entity.
 *
 */

package com.screentech.cordamigrate.controller

import com.screentech.cordamigrate.dao.invoices.InvoiceRepository
import com.screentech.cordamigrate.entity.invoices.Invoice
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/invoices")
class InvoiceController : CRUDAbstract<Invoice>() {

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    /**
     * Parses the string timestamp values of Invoice properties
     *
     * @param anObject an object of type Invoice
     */
    private fun parseTimestamps(anObject: Invoice) : Invoice {
        anObject.theTimestamp = parseStringToTimestamp(anObject.theTimestampStr) // parse theTimestamp
        anObject.sponsor.emailVerifiedAt = parseStringToTimestamp(anObject.sponsor.emailVerifiedAtStr) // parse sponsor (User.kt) timestamp
        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr) // parse wallet (Wallet.kt) timestamp
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr) // parse user timestamp in Wallet.kt
        anObject.order.timestamp = parseStringToTimestamp(anObject.order.timestampStr) // parse order timestamp
        return anObject // return anObject (Invoice)
    }

    /**
     * Creates / saves an invoice in the database
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @PostMapping("/create")
    override fun create(@RequestBody anObject: Invoice): ResponseEntity<*> = JSONUtilsKT.ok(this.invoiceRepository.save(this.parseTimestamps(anObject)))

    /**
     * updates / saves an invoice in the database
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @PutMapping("/update")
    override fun update(@RequestBody anObject: Invoice): ResponseEntity<*>  = JSONUtilsKT.ok(this.invoiceRepository.save(parseTimestamps(anObject)))


    /**
     * deletes a row / record of invoice in the database
     * Returns ResponseEntity
     * @param id An id of the row to be deleted
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    override fun deleteById(id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.invoiceRepository.deleteById(id))

    /**
     * deletes a row /record of invoice in the database.
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @DeleteMapping("/delete")
    override fun deleteByObject(@RequestBody anObject: Invoice): ResponseEntity<*> = JSONUtilsKT.ok(this.invoiceRepository.delete(anObject))

}
