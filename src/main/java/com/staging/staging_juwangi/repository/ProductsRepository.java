package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository <Products,Long> {
}
