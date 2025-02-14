package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Users;
import com.staging.staging_juwangi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsersDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        if (userRepository.existsByEmail(username)){
            Users user = userRepository.findByEmail(username).orElseThrow(() -> new NotFoundException("Id Not Found"));
            return UsersDetail.buildUser(user);
        }
        throw new NotFoundException("User Not Found with username: " + username);
    }

}