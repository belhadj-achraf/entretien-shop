package com.service.product.product.service.controller;

import com.service.product.product.service.entity.Product;
import com.service.product.product.service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product productModel = productService.createProduct(product);
        return new ResponseEntity<>(productModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@Valid @RequestBody Product product){
        Product productModel = productService.updateProduct(id, product);
        if ( productModel != null ){
            return new ResponseEntity<>(productModel,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
