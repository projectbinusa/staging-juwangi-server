package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository <Produk ,Long> {
}
