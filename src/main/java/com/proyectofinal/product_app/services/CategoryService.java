package com.proyectofinal.product_app.services;

import com.proyectofinal.product_app.model.Category;
import com.proyectofinal.product_app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull; // Importación necesaria para la seguridad de nulos

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 24
    public Category getCategoryById(@NonNull Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 28
    public Category save(@NonNull Category category) {
        return categoryRepository.save(category);
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 32
    public void deleteCategory(@NonNull Long id){
        categoryRepository.deleteById(id);
    }
}