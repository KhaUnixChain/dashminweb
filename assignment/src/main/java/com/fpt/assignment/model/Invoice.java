package com.fpt.assignment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice  implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne @JoinColumn(name = "employee_id")
    Employee employee;

    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date")
    Date purchaseDate = new Date();

    Double amount;

    @Column(name = "status")
    Boolean status;
}
