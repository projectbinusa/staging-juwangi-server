package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.model.Cart;
import com.staging.staging_juwangi.model.Products;
import com.staging.staging_juwangi.repository.CartRepository;
import com.staging.staging_juwangi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public Cart addCart (Long productsId) {
        Optional<Products> optionalProducts = productsRepository.findById(productsId);

        if (optionalProducts.isPresent()) {
            Products products = optionalProducts.get();

            if (products.getStok() > 0 ) {
                products.setStok(products.getStok() - 1);
                productsRepository.save(products);

                Cart cart = new Cart();
                cart.setNama(products.getNama());
                cart.setHarga(products.getHarga());
                cart.setDeskripsi(products.getDeskripsi());
                cart.setGambar(products.getGambar());
                cart.setKategori(products.getKategori());
                cart.setStok(products.getStok());
                return cartRepository.save(cart);
            }
            else {
                throw new RuntimeException("Stok barang tidak mencukupi");
            }
        } else {
            throw new RuntimeException("Barang dengan ID " + productsId + " tidak ditemukan");
        }
    }

    public Map<String, Boolean> delete(Long id){
        try {
            cartRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
