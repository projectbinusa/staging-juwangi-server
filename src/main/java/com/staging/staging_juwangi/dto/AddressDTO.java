package com.staging.staging_juwangi.dto;

import com.staging.staging_juwangi.model.Address;


public class AddressDTO {
        private Long AddressId;
        private String address;
        private String nama;
        private String email;
        private Long phone;
        private String alamat;

        public AddressDTO(Address address) {
            this.AddressId = address.getAddressId();
            this.address = address.getAddress();
            this.nama = address.getNama();
            this.email = address.getEmail();
            this.phone = address.getPhone();
            this.alamat = address.getAlamat();
        }

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
