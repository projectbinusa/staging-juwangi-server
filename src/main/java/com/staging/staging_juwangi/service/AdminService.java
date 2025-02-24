package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Admin;
import com.staging.staging_juwangi.model.LoginRequest;

import com.staging.staging_juwangi.repository.AdminRepository;
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
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

//    public AdminService(AdminRepository adminRepository){
//        this.adminRepository = adminRepository;
//    }

    public Map<Object, Object> login(LoginRequest loginRequest) {
        Admin admin = adminRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Username not found"));
        if (encoder.matches(loginRequest.getPassword(), admin.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateToken(authentication);
            adminRepository.save(admin);
            Map<Object, Object> response = new HashMap<>();
            response.put("data", admin);
            response.put("token", jwt);
            return response;
        }
        throw new NotFoundException("Password not found");
    }

    public Admin add(Admin admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));
        return adminRepository.save(admin);

    }


    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin edit(Long id, Admin user) {
        Admin update = adminRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setEmail(user.getEmail());
        update.setUsername(user.getUsername());
        if (user.getPassword() != null && !user.getPassword().isEmpty()){
            update.setPassword(encoder.encode(user.getPassword()));
        }
        return adminRepository.save(update);
    }
    public Map<String, Boolean> delete(Long id) {
        try {
            adminRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("Deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            return null;
        }
    }

}
