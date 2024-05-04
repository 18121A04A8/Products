package com.Ecommers.Products.Repository;

import com.Ecommers.Products.Dto.InstructorDto;
import com.Ecommers.Products.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findByName(String name);
}
