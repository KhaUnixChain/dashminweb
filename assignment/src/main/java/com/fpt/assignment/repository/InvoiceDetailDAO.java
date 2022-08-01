package com.fpt.assignment.repository;

import com.fpt.assignment.model.Customer;
import com.fpt.assignment.model.InvoiceDetails;
import com.fpt.assignment.model.ReportProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDetailDAO extends JpaRepository<InvoiceDetails, Integer>{
    //
    @Query("SELECT new ReportProduct(o.product, SUM(o.quantity)) FROM InvoiceDetails o GROUP BY o.product")
    List<ReportProduct> getTop5ProductBest();

    @Query("SELECT o FROM InvoiceDetails o WHERE o.invoice.customer=?1 AND o.invoice.status=?2")
    List<InvoiceDetails> findInvoiceStatus(Customer customer, int status);

    @Query("SELECT o FROM InvoiceDetails o WHERE o.invoice.customer=?1 ")
    List<InvoiceDetails> findAllCustomer(Customer customer);
}
