package com.fion.springbootmall.dao;

import com.fion.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
