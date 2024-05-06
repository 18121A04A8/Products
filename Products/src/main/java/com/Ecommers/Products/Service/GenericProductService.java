package com.Ecommers.Products.Service;

import com.Ecommers.Products.Models.GenericProduct;
import com.Ecommers.Products.Repository.GenericProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenericProductService {

    GenericProductRepository genericProductRepository;

    public GenericProductService(GenericProductRepository genericProductRepository) {
        this.genericProductRepository = genericProductRepository;
    }

    private static final String[] PRODUCT_NAMES = {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earbuds", "Projector", "Desk"
    };

    public Boolean generateData() {

        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();

        for(int i=0; i<PRODUCT_NAMES.length; i++){
            String productName = PRODUCT_NAMES[i];
            int price = random.nextInt(1000);
            GenericProduct genericProduct = new GenericProduct(productName, price);
            productList.add(genericProduct);
        }
        genericProductRepository.saveAll(productList);
        return true;
    }

    public List<GenericProduct> getAllProducts(String query) {
         return genericProductRepository.findAll();

    }

    public Page<GenericProduct> searchProductsByPagination(String query, int pageNumber, int pageSize, String sorting) {

        switch (sorting) {
            case "name-desc" :
                return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name"));
            case "name-asc" :
                return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name"));

            case "id-asc" :
                return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id"));

            default: return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize));
        }
    }
}
