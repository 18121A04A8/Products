package com.Ecommers.Products.Controller;

import com.Ecommers.Products.Dto.ProductDto;
import com.Ecommers.Products.Models.Products;
import com.Ecommers.Products.Service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Products")
public class ProductController {



    private ProductsService productsService;
    public ProductController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/{id}")
    public @ResponseBody ProductDto productById(@PathVariable long id) throws  Exception{
        return  productsService.productById(id);
    }

    @GetMapping("")
    public @ResponseBody ArrayList<ProductDto> allProducts(){
        return  productsService.allProducts();
    }


}
