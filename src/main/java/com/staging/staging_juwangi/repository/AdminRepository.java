package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Long>{

    Optional<Admin> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<Admin> findById(Long id);
}
