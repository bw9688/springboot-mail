package com.fion.springbootmall.controller;

import com.fion.springbootmall.ApiRes;
import com.fion.springbootmall.dto.ProductRequest;
import com.fion.springbootmall.model.Product;
import com.fion.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController implements BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<ApiRes<Product>> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(ApiRes.success(product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<ApiRes<Product>> createProduct(@RequestBody @Valid ProductRequest request) {
        Integer productId = productService.createProduct(request);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiRes.success(product));
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<ApiRes<Product>> updateProduct(@PathVariable Integer productId,
                                                         @RequestBody @Valid ProductRequest productRequest) {

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiRes.fail("找不到此商品"));
        }

        // 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(ApiRes.success(updatedProduct));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<ApiRes<Product>> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
