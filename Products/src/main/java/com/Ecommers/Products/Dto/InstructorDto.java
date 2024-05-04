package com.Ecommers.Products.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class InstructorDto {

    private UUID id;
    private String name;
    private int salary;
    private List<String> batchName;
    private List<UUID> batch_id;
}
