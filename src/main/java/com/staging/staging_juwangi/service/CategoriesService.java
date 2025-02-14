package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Categories;

import com.staging.staging_juwangi.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public Categories add(Categories add){
        Categories categories = new Categories();
        categories.setKategori(add.getKategori());

        Categories saved = (Categories) categoriesRepository.save(categories);
        return saved;
    }

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories getById(Long id) {
        return categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("id not found"));
    }

    public Categories edit(Long id , Categories user){
        Categories update = categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setKategori(user.getKategori());
        return categoriesRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            categoriesRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
