package com.fion.springbootmall.service.impl;

import com.fion.springbootmall.dao.ProductDao;
import com.fion.springbootmall.model.Product;
import com.fion.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
