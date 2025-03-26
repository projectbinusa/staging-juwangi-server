package com.staging.staging_juwangi.controller;


import com.staging.staging_juwangi.dto.AddressDTO;
import com.staging.staging_juwangi.model.Address;
import com.staging.staging_juwangi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address add(@RequestBody Address add) {
        return addressService.add(add);
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable("id")Long id){
        return addressService.getById(id);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddress();
        List<AddressDTO> addressDTOs = addresses.stream().map(AddressDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(addressDTOs);
    }


    @PutMapping("{id}")
    public Address edit(@PathVariable("id")Long id, @RequestBody Address address){
        return addressService.edit(id, address);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id){
        return addressService.delete(id);
    }
}
