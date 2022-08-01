package com.fpt.assignment.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "customers")
public class Customer  implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    String name;

    @Column(name = "email", columnDefinition = "varchar(50)", nullable = false)
    String email;

    @Column(name = "password", columnDefinition = "varchar(20)", nullable = false)
    String password;
    
    @Column(name = "phone", columnDefinition = "varchar(15)", nullable = false)
    String phone;

    @Column(name = "verification_code", columnDefinition = "varchar(64)", nullable = true)
    String verificationCode;

    Boolean enabled;

    @OneToMany(mappedBy = "customer")
    List<Invoice> invoices;

    public Customer(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.verificationCode = null;
        this.enabled = null;
    }
}
