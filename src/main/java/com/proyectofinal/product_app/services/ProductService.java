package com.proyectofinal.product_app.services;

import com.proyectofinal.product_app.model.Product;
import com.proyectofinal.product_app.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull; // Importante para la seguridad de nulos

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    // Agregamos @NonNull al parámetro 'id'
    public Product getProduct(@NonNull Long id){
        return productRepository.findById(id).orElse(null);
    }

    // Agregamos @NonNull al parámetro 'product'
    public Product addProduct(@NonNull Product product){
        return productRepository.save(product);
    }

    // Agregamos @NonNull al parámetro 'product'
    public Product updateProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    // Agregamos @NonNull al parámetro 'id'
    public void deleteProduct(@NonNull Long id){
        productRepository.deleteById(id);
    }
}