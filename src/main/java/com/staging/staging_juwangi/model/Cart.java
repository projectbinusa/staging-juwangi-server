package com.staging.staging_juwangi.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama" ,nullable = false)
    private String nama;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "harga", nullable = false)
    private Float harga;

    @Column(name = "stok" )
    private Long stok;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "gambar")
    private String gambar;

    private int kuantitas;

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

    public Float getHarga() {
        return harga;
    }
    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public Long getStok() {
        return stok;
    }
    public void setStok(Long stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
}
