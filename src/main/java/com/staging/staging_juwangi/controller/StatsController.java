package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.service.StatsService;
import com.staging.staging_juwangi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/users")
    public ResponseEntity<Long> countUsers(){
        return ResponseEntity.ok(statsService.countUSers());
    }

    @GetMapping("/revenue")
    public ResponseEntity<Long> countOrders(){
        return ResponseEntity.ok(statsService.countOrders());
    }

    @GetMapping("/products")
    public ResponseEntity<Long> countProducts(){
        return ResponseEntity.ok(statsService.countProducts());
    }
}

