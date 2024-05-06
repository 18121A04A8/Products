package com.Ecommers.Products.Repository;

import com.Ecommers.Products.Models.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericProductRepository extends JpaRepository<GenericProduct,Long> {


    Page<GenericProduct> findAll(Pageable pageable);



}
