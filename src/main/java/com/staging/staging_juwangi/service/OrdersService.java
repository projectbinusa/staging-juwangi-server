package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Orders;
import com.staging.staging_juwangi.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public Orders add (Orders add){
        Orders orders = new Orders();
        orders.setNama(add.getNama());
        orders.setProducts(add.getProducts());
        orders.setJumlah(add.getJumlah());
        orders.setAlamat(add.getAlamat());

        System.out.println("Sebelum save: " + orders);
        Orders saved = ordersRepository.save(orders);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public Orders getById(Long id){
        return ordersRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
    }

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Orders edit (Long id, Orders orders ){
        Orders update = ordersRepository.findById(id).orElseThrow(() ->new NotFoundException("Id not found"));
        update.setNama(orders.getNama());
        update.setJumlah(orders.getJumlah());
        update.setAlamat(orders.getAlamat());
        return ordersRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            ordersRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
