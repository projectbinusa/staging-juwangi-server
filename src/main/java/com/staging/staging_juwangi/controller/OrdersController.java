package com.staging.staging_juwangi.controller;


import com.staging.staging_juwangi.model.Orders;
import com.staging.staging_juwangi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public Orders add(@RequestBody Orders add) {
        return ordersService.add(add);
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable("id")Long id){
        return ordersService.getById(id);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PutMapping("{id}")
    public Orders edit(@PathVariable("id")Long id,@RequestBody Orders orders){
        return ordersService.edit(id, orders);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id){
        return ordersService.delete(id);
    }
}
