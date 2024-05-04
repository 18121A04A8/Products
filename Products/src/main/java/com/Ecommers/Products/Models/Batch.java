package com.Ecommers.Products.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Batch {

    @Id
    private UUID id;
    private String name;

    @ManyToOne
    private Instructor instructor;

}
