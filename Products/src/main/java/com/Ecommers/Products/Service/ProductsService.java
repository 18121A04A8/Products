package com.Ecommers.Products.Service;

import com.Ecommers.Products.Dto.FakeStoreProductDto;
import com.Ecommers.Products.Dto.ProductDto;
import com.Ecommers.Products.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

@Service
public class ProductsService {

    //This method will fetch products based on id.
    public ProductDto productById(long id) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/"+id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url,FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            throw new NotFoundException();
        }

        return convertToProductDto(fakeStoreProductDto);
    }

    //This method will convert fakeStoreProductDto into productDto.
    private ProductDto convertToProductDto(FakeStoreProductDto fakeStoreProductDto) {

        ProductDto productDto = new ProductDto();
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice());
        productDto.setId(fakeStoreProductDto.getId());

        return productDto;
    }

    //This method will return all products
    public ArrayList<ProductDto> allProducts() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDto[] fakeStoreProductDto= restTemplate.getForObject(url,FakeStoreProductDto[].class);

        ArrayList<ProductDto> ListProductDto = new ArrayList<>();

        for(int i=0; i<fakeStoreProductDto.length; i++){
            ListProductDto.add(this.convertToProductDto(fakeStoreProductDto[i]));
        }
        return ListProductDto;
    }
}
