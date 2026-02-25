package com.proyectofinal.product_app.controllers;

import com.proyectofinal.product_app.services.ProductService;
import com.proyectofinal.product_app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull; // Importante para la seguridad de nulos

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") @NonNull Long id){
        return productService.getProduct(id); // Soluciona aviso línea 30
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody() @NonNull Product product, @PathVariable("id") @NonNull Long id){
        return productService.updateProduct(product); // Soluciona aviso línea 35
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addNew(@RequestBody() @NonNull Product product){
        Product newProduct = productService.addProduct(product); // Soluciona aviso línea 40
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") @NonNull Long id){
        productService.deleteProduct(id); // Soluciona aviso línea 46
    }
}