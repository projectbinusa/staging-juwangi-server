package com.staging.staging_juwangi.controller;


import com.staging.staging_juwangi.exception.CommonResponse;
import com.staging.staging_juwangi.exception.ResponseHelper;
import com.staging.staging_juwangi.model.LoginRequest;
import com.staging.staging_juwangi.model.Users;
import com.staging.staging_juwangi.security.JwtUtils;
import com.staging.staging_juwangi.service.UsersDetail;
import com.staging.staging_juwangi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    private UsersService akunService;
    private JwtUtils jwtUtils;

    public void UserProfil(JwtUtils jwtUtils, UsersService userService){
        this.jwtUtils = jwtUtils;
        this.akunService = userService;
    }

    @PostMapping("/login")
    public CommonResponse<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseHelper.ok( akunService.login(loginRequest));
    }
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(@AuthenticationPrincipal UsersDetail userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body(Map.of("message", "User not logged in"));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", userDetails.getId());
        response.put("email", userDetails.getUsername());

        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public CommonResponse<Users> register(@RequestBody Users akun){
        return ResponseHelper.ok( akunService.add(akun));
    }

    @GetMapping("/{id}")
    public CommonResponse <Users> get(@PathVariable("id") Long id){
        return ResponseHelper.ok( akunService.get(id));
    }
    @GetMapping
    public CommonResponse<List<Users>> getAll(){
        return ResponseHelper.ok( akunService.getAll());
    }
    @PutMapping("/{id}")
    public CommonResponse<Users> put(@PathVariable("id") Long id , @RequestBody Users akun){
        return ResponseHelper.ok( akunService.edit(id, akun));
    }
    @DeleteMapping("/{id}")
    public CommonResponse<?> delete(@PathVariable("id")  Long id ) {
        return ResponseHelper.ok( akunService.delete(id));
    }
}