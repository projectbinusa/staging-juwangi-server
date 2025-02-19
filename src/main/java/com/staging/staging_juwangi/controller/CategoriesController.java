package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.model.Categories;
import com.staging.staging_juwangi.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = "*")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public Categories add (@RequestBody Categories add){
        return categoriesService.add(add);
    }

    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categories getById(@PathVariable("id")Long id) {
        return categoriesService.getById(id);
    }

    @PutMapping("/{id}")
    public Categories edit(@PathVariable("id")Long id,@RequestParam Categories categories){
        return categoriesService.edit(id ,categories);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delete(@PathVariable("id")Long id){
        return categoriesService.delete(id);
    }
}
