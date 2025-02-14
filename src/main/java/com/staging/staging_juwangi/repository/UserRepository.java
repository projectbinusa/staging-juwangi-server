package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

//    Optional<User> findByUsername(String username);

    Optional<Users> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<Users> findById(Long id);
}
