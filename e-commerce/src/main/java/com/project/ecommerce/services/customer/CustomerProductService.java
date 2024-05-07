package com.project.ecommerce.services.customer;

import com.project.ecommerce.dto.ProductDetailDto;
import com.project.ecommerce.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {


    List<ProductDto>searchProductByTitle(String title);


    List<ProductDto>getAllProducts();

    ProductDetailDto getProductDetailById(Long productId);
}
