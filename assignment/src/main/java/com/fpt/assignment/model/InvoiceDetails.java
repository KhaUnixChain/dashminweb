package com.fpt.assignment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "invoice_details")
public class InvoiceDetails  implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne @JoinColumn(name = "invoice_id")
    Invoice invoice;

    @ManyToOne @JoinColumn(name = "product_id")
    Product product;
    
    Integer quantity;
    
    String note;
}
