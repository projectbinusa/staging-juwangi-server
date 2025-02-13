package com.staging.staging_juwangi.controller;


import com.staging.staging_juwangi.exception.CommonResponse;
import com.staging.staging_juwangi.exception.ResponseHelper;
import com.staging.staging_juwangi.model.LoginRequest;
import com.staging.staging_juwangi.model.User;
import com.staging.staging_juwangi.security.JwtUtils;
import com.staging.staging_juwangi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService akunService;
    private JwtUtils jwtUtils;

    public void UserProfil(JwtUtils jwtUtils, UserService userService){
        this.jwtUtils = jwtUtils;
        this.akunService = userService;
    }

    @PostMapping("/login")
    public CommonResponse<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseHelper.ok( akunService.login(loginRequest));
    }
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfil(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            User user = akunService.findByUsername(username);

            if (user != null){
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(404).body("user not found");
    }

    @PostMapping("/register")
    public CommonResponse<User> register(@RequestBody User akun){
        return ResponseHelper.ok( akunService.add(akun));
    }

    @GetMapping("/{id}")
    public CommonResponse <User> get(@PathVariable("id") Long id){
        return ResponseHelper.ok( akunService.get(id));
    }
    @GetMapping
    public CommonResponse<List<User>> getAll(){
        return ResponseHelper.ok( akunService.getAll());
    }
    @PutMapping("/{id}")
    public CommonResponse<User> put(@PathVariable("id") Long id , @RequestBody User akun){
        return ResponseHelper.ok( akunService.edit(id, akun));
    }
    @DeleteMapping("/{id}")
    public CommonResponse<?> delete(@PathVariable("id")  Long id ) {
        return ResponseHelper.ok( akunService.delete(id));
    }
}