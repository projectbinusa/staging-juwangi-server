package com.staging.staging_juwangi.controller;

import com.amazonaws.services.s3.model.lifecycle.LifecycleObjectSizeGreaterThanPredicate;
import com.staging.staging_juwangi.model.Cart;
import com.staging.staging_juwangi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("/{barangId}")
    public Cart addCart(@PathVariable Long barangId) {
        return cartService.addCart(barangId);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        return cartService.delete(id);
    }

}
