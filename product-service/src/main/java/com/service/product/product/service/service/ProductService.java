package com.service.product.product.service.service;

import com.service.product.product.service.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);
    boolean deleteProduct(Long id);
    Product updateProduct(Long id, Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
