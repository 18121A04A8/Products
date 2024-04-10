package com.Ecommers.Products.Dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {

    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

}
