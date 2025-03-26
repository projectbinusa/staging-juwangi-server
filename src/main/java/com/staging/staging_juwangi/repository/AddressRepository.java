package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <Address,Long> {
}
