package com.Ecommers.Products.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity

public class Instructor extends User{

    private int salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
    @Fetch(FetchMode.SUBSELECT)
    private List<Batch> batch;
}
