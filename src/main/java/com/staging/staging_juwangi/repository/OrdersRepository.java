package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository <Orders,Long> {
}
