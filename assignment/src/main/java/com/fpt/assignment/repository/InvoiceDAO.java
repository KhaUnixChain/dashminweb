package com.fpt.assignment.repository;

import com.fpt.assignment.model.Invoice;
import com.fpt.assignment.model.ReportEmployee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDAO extends JpaRepository<Invoice, Integer>{
    //
    @Query("SELECT new ReportEmployee(o.employee, sum(o.amount), count(o)) FROM Invoice o GROUP BY o.employee ORDER BY sum(o.amount) DESC")
    List<ReportEmployee> getAllReport();

    @Query("SELECT new ReportEmployee(o.employee, sum(o.amount), count(o)) FROM Invoice o GROUP BY o.employee, YEAR(purchase_date) HAVING YEAR(purchase_date) = YEAR(GETDATE())-1 ORDER BY sum(o.amount) DESC")
    List<ReportEmployee> getReportYearAgo();

    @Query("SELECT new ReportEmployee(o.employee, sum(o.amount), count(o)) FROM Invoice o GROUP BY o.employee, YEAR(purchase_date) HAVING YEAR(purchase_date) = YEAR(GETDATE()) ORDER BY sum(o.amount) DESC")
    List<ReportEmployee> getReportToYear();

    @Query("SELECT o FROM Invoice o ORDER BY o.amount DESC")
    List<Invoice> findAmountMax();
}
