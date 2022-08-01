package com.fpt.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "products")
public class Product implements Serializable{
    @Id
    @Column(name = "id", columnDefinition = "varchar(20)", nullable = false)
    String id;

    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    String name;
    
    Double price;

    Integer maintenance;

    @Column(name = "image", columnDefinition = "nvarchar(50)", nullable = false)
    String image;
    
    @ManyToOne @JoinColumn(name = "category_id")
    Category category;
    
    @OneToMany(mappedBy = "product")
    List<InvoiceDetails> invoiceDetails;
}
