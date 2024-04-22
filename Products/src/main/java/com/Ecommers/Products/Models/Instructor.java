package com.Ecommers.Products.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity

public class Instructor extends User{

    private int salary;
    private String batch;
}
