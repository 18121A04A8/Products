package com.Ecommers.Products.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    @Column (name = "email_Address", unique = true)
    private String email;


}
