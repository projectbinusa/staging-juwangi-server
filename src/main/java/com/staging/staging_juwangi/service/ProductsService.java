package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Products;
import com.staging.staging_juwangi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;


    public Products add(Products add) {
        Products products = new Products();
        products.setNama(add.getNama());
        products.setKategori(add.getKategori());
        products.setHarga(add.getHarga());
        products.setStok(add.getStok());
        products.setJumlah(add.getJumlah());
        products.setDeskripsi(add.getDeskripsi());
        products.setGambar(add.getGambar());

        System.out.println("Sebelum save: " + products);
        Products saved = productsRepository.save(products);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public Products getById(Long id){
        return productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id Not Found"));
    }


    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }


    public Products edit(Long id , Products products){
        Products update = productsRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNama(products.getNama());
        update.setStok(products.getStok());
        update.setJumlah(products.getJumlah());
        update.setDeskripsi(products.getDeskripsi());
        update.setKategori(products.getKategori());
        update.setGambar(products.getGambar());
        update.setHarga(products.getHarga());
        return productsRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            productsRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }

}
