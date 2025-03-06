package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.model.Products;
import com.staging.staging_juwangi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "http://localhost:4322")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping
    public Products add(@RequestBody Products add){
        System.out.println("Data yang di terima" + add);
        return productsService.add(add);
    }

    @GetMapping("/{id}")
    public Products getById(@PathVariable("id") Long id) {
        return productsService.getById( id);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }


    @PutMapping("/{id}")
    public Products edit(@PathVariable("id") Long id, @RequestBody Products products) {
        return productsService.edit(id, products);
    }


    @DeleteMapping("{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        return productsService.delete(id);
    }

}
