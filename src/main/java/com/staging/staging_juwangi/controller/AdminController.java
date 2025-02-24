package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.exception.CommonResponse;
import com.staging.staging_juwangi.exception.ResponseHelper;
import com.staging.staging_juwangi.model.Admin;
import com.staging.staging_juwangi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public CommonResponse <List<Admin>> getAll(){
        return ResponseHelper.ok(adminService.getAll());
    }

    @PostMapping("/create")
    public CommonResponse <Admin> add (@RequestBody Admin admin){
        return ResponseHelper.ok(adminService.add(admin));
    }

    @PutMapping("/{id}")
    public CommonResponse<Admin> put (@PathVariable("id") Long id, @RequestBody Admin admin){
        return ResponseHelper.ok(adminService.edit(id, admin));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<?> delete(@PathVariable("id")  Long id ) {
        return ResponseHelper.ok( adminService.delete(id));
    }
}
