package com.fpt.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "categories")
public class Category implements Serializable{
    @Id
    Integer id;

    @Column(name = "type", columnDefinition = "nvarchar(50)", nullable = false)
    String type;

    @Column(name = "signal", columnDefinition = "varchar(5)", nullable = true)
    String signal;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
