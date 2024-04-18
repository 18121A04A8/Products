package com.Ecommers.Products.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "ecomm_User")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String name;
    @Column (name = "email_Adress", unique = true)
    private String email;



}
