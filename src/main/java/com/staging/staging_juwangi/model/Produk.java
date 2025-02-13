package com.staging.staging_juwangi.model;

import javax.persistence.*;

@Entity
@Table(name = "produk")
public class Produk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama" ,nullable = false)
    private String nama;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "harga", nullable = false)
    private String harga;

    @Column(name = "stok" ,nullable = false)
    private Long Stok;

    @Column(name = "deskripsi")
    private String Deskripsi;

    @Column(name = "gambar")
    private String Gambar;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }
    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Long getStok() {
        return Stok;
    }
    public void setStok(Long stok) {
        this.Stok = stok;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
       this.Deskripsi = deskripsi;
    }

    public String getGambar() {
        return Gambar;
    }
    public void setGambar(String gambar) {
        this.Gambar = gambar;
    }
}

