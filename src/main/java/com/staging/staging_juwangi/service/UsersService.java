package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.LoginRequest;
import com.staging.staging_juwangi.model.Users;
import com.staging.staging_juwangi.repository.UserRepository;
import com.staging.staging_juwangi.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    private UserRepository akunRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public UsersService(UserRepository akunRepository) {
        this.akunRepository = akunRepository;
    }


    public Map<Object, Object> login(LoginRequest loginRequest) {
        Users user = akunRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Username not found"));
        if (encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateToken(authentication);
            akunRepository.save(user);
            Map<Object, Object> response = new HashMap<>();
            response.put("data", user);
            response.put("token", jwt);
            return response;
        }
        throw new NotFoundException("Password not found");
    }

    public Users add(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return akunRepository.save(user);
    }



    public Users get(Long id) {
        return akunRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
    }

    public List<Users> getAll() {
        return akunRepository.findAll();
    }

    public Users edit(Long id, Users user) {
        Users update = akunRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setEmail(user.getEmail());
        update.setUsername(user.getUsername());
        if (user.getPassword() != null && !user.getPassword().isEmpty()){
            update.setPassword(encoder.encode(user.getPassword()));
        }
        return akunRepository.save(update);
    }
    public Map<String, Boolean> delete(Long id) {
        try {
            akunRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("Deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            return null;
        }
    }


//    public User findByUsername(String username) {
//        return akunRepository.findByUsername(username)
//                .orElseGet(()-> akunRepository.findByEmail(username).orElse(null));
//
//    }
}