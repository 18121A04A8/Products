package com.Ecommers.Products.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class GenericProduct {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int price;

    public GenericProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
