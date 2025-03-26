package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.repository.AddressRepository;
import com.staging.staging_juwangi.repository.ProductsRepository;
import com.staging.staging_juwangi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository ordersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    public long countUSers(){
        return userRepository.count();
    }

    public long countOrders(){
        return ordersRepository.count();
    }

    public long countProducts(){
        return productsRepository.count();
    }

}
