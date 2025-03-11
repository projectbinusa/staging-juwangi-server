package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long>{
}
