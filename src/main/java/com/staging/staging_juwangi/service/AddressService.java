package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Address;
import com.staging.staging_juwangi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address add (Address add){
        Address address = new Address();
        address.setNama(add.getNama());
        address.setEmail(add.getEmail());
        address.setPhone(add.getPhone());
        address.setTanggalLahir(add.getTanggalLahir());
        address.setAlamat(add.getAlamat());

        System.out.println("Sebelum save: " + address);
        Address saved = addressRepository.save(address);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public Address getById(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Address edit (Long id, Address address ){
        Address update = addressRepository.findById(id).orElseThrow(() ->new NotFoundException("Id not found"));
        update.setNama(address.getNama());
        update.setEmail(address.getEmail());
        update.setPhone(address.getPhone());
        update.setTanggalLahir(address.getTanggalLahir());
        update.setAlamat(address.getAlamat());
        return addressRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            addressRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
