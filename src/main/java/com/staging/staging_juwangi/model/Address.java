package com.staging.staging_juwangi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AddressId;

    private String address;
    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;


    @Column(name = "phone")
    private Long phone;

    @Column(name = "alamat")
    private String alamat;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonBackReference
    @JsonIgnore
    private Invoice invoice;

    public Address() {}

    public Address(String address, Invoice invoice) {
        this.address = address;
        this.invoice = invoice;
    }

    public Long getAddressId() {
        return AddressId;
    }
    public void setAddressId(Long addressId) {
        AddressId = addressId;
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

    public void setEmail(String enail) {
        this.email = enail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
