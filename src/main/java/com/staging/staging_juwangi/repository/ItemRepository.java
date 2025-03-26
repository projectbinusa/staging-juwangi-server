package com.staging.staging_juwangi.repository;


import com.staging.staging_juwangi.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
