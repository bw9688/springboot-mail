package com.fion.springbootmall.dao;

import com.fion.springbootmall.dto.ProductRequest;
import com.fion.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
