package com.proyectofinal.product_app.services;

import com.proyectofinal.product_app.model.SubCategory;
import com.proyectofinal.product_app.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull; // Importación para la seguridad de nulos

import java.util.List;

@Service
public class SubCategoryService {

    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getAllSubCategories(){
        return subCategoryRepository.findAll();
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 25
    public SubCategory getSubCategoryById(@NonNull Long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 29
    public SubCategory save(@NonNull SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    // Agregamos @NonNull para solucionar el aviso de la línea 33
    public void deleteSubCategory(@NonNull Long id){
        subCategoryRepository.deleteById(id);
    }
}