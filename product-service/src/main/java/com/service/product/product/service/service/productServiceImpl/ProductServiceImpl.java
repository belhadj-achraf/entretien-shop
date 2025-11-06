package com.service.product.product.service.service.productServiceImpl;

import com.service.product.product.service.entity.Product;
import com.service.product.product.service.repository.ProductRepository;
import com.service.product.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if ( product != null ) {
            Product productModel = getProductById(product.getId());
            if (productModel == null) {
                return productRepository.save(mapToEntity(product));
            }
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product productModel = getProductById(id);
        if ( productModel != null ){
            productRepository.delete(productModel);
            return true;
        }
        return false;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productModel = getProductById(id);
        if ( productModel != null ){
            productModel = mapToEntity(product);
            return productModel;
        }
        return new Product(null,null,null,null);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product mapToEntity(Product product){
        Product productModel = new Product();

        productModel.setName(product.getName());
        productModel.setStock(product.getStock());
        productModel.setPrice(product.getPrice());

        return productModel;
    }
}
