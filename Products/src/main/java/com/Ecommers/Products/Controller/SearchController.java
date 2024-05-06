package com.Ecommers.Products.Controller;


import com.Ecommers.Products.Models.GenericProduct;
import com.Ecommers.Products.Service.GenericProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    GenericProductService genericProductService;

    public SearchController(GenericProductService genericProductService) {
        this.genericProductService = genericProductService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Boolean> generateData() {
        return ResponseEntity.ok(genericProductService.generateData());
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenericProduct>> searchAllProducts(@RequestParam(value = "q", required = false) String query) {
        return ResponseEntity.ok(genericProductService.getAllProducts(query));
    }

    @GetMapping("")
    public ResponseEntity<Page<GenericProduct>> searchProductsByPage(
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "pageNo") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "sorting", required = false, defaultValue = "id-desc") String sorting) {

        return ResponseEntity.ok(
                genericProductService.searchProductsByPagination
                        (query, pageNumber, pageSize, sorting));
    }
}
