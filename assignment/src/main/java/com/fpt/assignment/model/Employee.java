package com.fpt.assignment.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "employees")
public class Employee  implements Serializable{
    @Id
    @Column(name = "id", columnDefinition = "varchar(20)", nullable = false)
    String id;

    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    String name;

    Boolean gender;
    
    @Column(name = "address", columnDefinition = "nvarchar(100)", nullable = false)
    String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth")
    Date birth = new Date();

    @Column(name = "email", columnDefinition = "nvarchar(50)", nullable = false)
    String email;

    @Column(name = "avartar", columnDefinition = "nvarchar(100)", nullable = true)
    String avartar;

    @Column(name = "password", columnDefinition = "varchar(20)", nullable = false)
    String password;
    
    Boolean role;

    @OneToMany(mappedBy = "employee")
    List<Invoice> invoices;
}
