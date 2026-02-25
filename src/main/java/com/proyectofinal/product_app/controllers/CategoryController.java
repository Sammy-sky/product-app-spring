package com.proyectofinal.product_app.controllers;

import com.proyectofinal.product_app.services.CategoryService;
import com.proyectofinal.product_app.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull; // Importación obligatoria para la seguridad de nulos

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    // Soluciona el aviso de la línea 28
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") @NonNull Long id){
        return categoryService.getCategoryById(id);
    }

    // Soluciona el aviso de la línea 33 (y protege el ID también)
    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody() @NonNull Category category, @PathVariable("id") @NonNull Long id){
        return categoryService.save(category);
    }

    // Soluciona el aviso de la línea 38
    @PostMapping("/categories")
    public Category addNew(@RequestBody() @NonNull Category category){
        return categoryService.save(category);
    }

    // Soluciona el aviso de la línea 43
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") @NonNull Long id){
        categoryService.deleteCategory(id);
    }

}