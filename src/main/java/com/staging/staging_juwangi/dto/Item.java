package com.staging.staging_juwangi.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.staging.staging_juwangi.model.Invoice;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private String product;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "kuantitas")
    private Long kuantitas;

    @Column(name = "harga")
    private Double harga;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonBackReference
    private Invoice invoice;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Long getKuantitas() {
        return kuantitas;
    }
    public void setKuantitas(Long kuantitas) {
        this.kuantitas = kuantitas;
    }

    public Double getHarga() {
        return harga;
    }
    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
