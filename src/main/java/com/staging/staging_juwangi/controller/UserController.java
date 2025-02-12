package com.staging.staging_juwangi.controller;


import com.staging.staging_juwangi.exception.CommonResponse;
import com.staging.staging_juwangi.exception.ResponseHelper;
import com.staging.staging_juwangi.model.User;
import com.staging.staging_juwangi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService akunService;


//    @PostMapping("/login")
//    public CommonResponse<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        return ResponseHelper.ok( akunService.login(loginRequest));
//    }
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