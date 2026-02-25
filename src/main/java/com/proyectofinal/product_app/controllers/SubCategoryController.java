package com.proyectofinal.product_app.controllers;

import com.proyectofinal.product_app.model.SubCategory;
import com.proyectofinal.product_app.services.SubCategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull; // Importación obligatoria para los avisos

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/subCategories")
    public List<SubCategory> getSubCategories(){
        return subCategoryService.getAllSubCategories();
    }

    // Soluciona el aviso de la línea 26
    @GetMapping("/subCategory/{id}")
    public SubCategory getSubCategory(@PathVariable("id") @NonNull Long id){
        return subCategoryService.getSubCategoryById(id);
    }

    // Soluciona el aviso de la línea 31 (y protege el ID)
    @PutMapping("/subCategory/{id}")
    public SubCategory updateSubCategory(@RequestBody() @NonNull SubCategory subCategory, @PathVariable("id") @NonNull Long id){
        return subCategoryService.save(subCategory);
    }

    // Soluciona el aviso de la línea 36
    @PostMapping("/subCategories")
    public SubCategory addNew(@RequestBody() @NonNull SubCategory subCategory){
        return subCategoryService.save(subCategory);
    }

    // Soluciona el aviso de la línea 41
    @DeleteMapping("/subCategory/{id}")
    public void deleteSubCategory(@PathVariable("id") @NonNull Long id){
        subCategoryService.deleteSubCategory(id);
    }
}