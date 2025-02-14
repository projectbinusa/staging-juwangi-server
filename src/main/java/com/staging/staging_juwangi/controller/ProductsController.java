package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.model.Products;
import com.staging.staging_juwangi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping
    public Products add(@RequestBody Products add) {
        System.out.println("Data yang diterima: " + add);
        return productsService.add(add);
    }

    @GetMapping("/{id}")
    public Products getById(@PathVariable("id") Long id) {
        return productsService.getById( id);
    }

    @GetMapping
    public List<Products> getAllBarang() {
        return productsService.getAllBarang();
    }

//    @GetMapping("/kategori")
//    public List<Produk> getAllMakanan() {
//        return produkService.getAllElektronik();
//    }

//    @GetMapping("/api/produk")
//    public ResponseEntity<?> getProdukByNama(@RequestParam(required = false) String nama) {
//        try {
//            List<Produk> result = produkService.getProdukByNama(nama);
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Terjadi kesalahan pada server: " + e.getMessage());
//        }
//    }

//    @PostMapping("/api/barang/buy/{id}")
//    public ResponseEntity<String> buyProduk(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
//        if (!payload.containsKey("jumlah")) {
//            return ResponseEntity.badRequest().body("Key 'jumlah' tidak ditemukan dalam request.");
//        }
//
//        Integer jumlah = (Integer) payload.getOrDefault("jumlah", 0);
//        if (jumlah == 0) {
//            return ResponseEntity.badRequest().body("jumlah harus berupa angka positif.");
//        }
//
//        try {
//            produkService.buyProduk(id, jumlah);
//            return ResponseEntity.ok("Barang berhasil dibeli.");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Terjadi kesalahan pada server.");
//        }
//    }

    @PutMapping("/{id}")
    public Products edit(@PathVariable("id") Long id, @RequestBody Products produk) {
        return productsService.edit(id, produk);
    }


    @DeleteMapping("/api/barang/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        return productsService.delete(id);
    }

}
