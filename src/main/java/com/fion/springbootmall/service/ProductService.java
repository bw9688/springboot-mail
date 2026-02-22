package com.fion.springbootmall.service;

import com.fion.springbootmall.dto.ProductRequest;
import com.fion.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
