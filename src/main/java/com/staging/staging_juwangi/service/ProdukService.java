package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.exception.NotFoundException;
import com.staging.staging_juwangi.model.Produk;
import com.staging.staging_juwangi.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProdukService {
    @Autowired
    ProdukRepository produkRepository;

    public ProdukService(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;

    }
    public Produk add(Produk add) {
        Produk produk = new Produk();
        produk.setNama(add.getNama());
        produk.setKategori(add.getKategori());
        produk.setHarga(add.getHarga());
        produk.setStok(add.getStok());
        produk.setDeskripsi(add.getDeskripsi());
        produk.setGambar(add.getGambar());

        System.out.println("Sebelum save: " + produk);
        Produk saved = (Produk) produkRepository.save(produk);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public Produk getById(Long id){
        return produkRepository.findById(id).orElseThrow(() -> new NotFoundException("id Not Found"));
    }


    public List<Produk> getAllBarang() {
        return produkRepository.findAll();
    }

//    public List<Produk> getAllMakanan() {
//        return produkRepository.findByKategori("electronik");
//    }


//    public List<Produk> getBarangByNama_barang(String nama) {
//        if (nama == null || nama.isEmpty()) {
//            return produkRepository.findAll();
//        }
//        return produkRepository.findByNama_barang(nama);
//    }

//    public void buyProduk(Long id , int jumlah) throws Throwable {
//        Produk barang = (Produk) produkRepository.findById(id)
//                .orElseThrow(() ->new IllegalArgumentException("Barang tidak di temukan"));
//        if (barang.getStok() < jumlah) {
//            throw new IllegalArgumentException("Stok Barang tidak mencukupi!");
//        }
//        barang.setStok(barang.getStok() - jumlah); {
//            produkRepository.save(barang);
//        };
//    }

    public Produk edit(Long id ,Produk user){
        Produk update = produkRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNama(user.getNama());
        update.setStok(user.getStok());
        update.setDeskripsi(user.getDeskripsi());
        update.setKategori(user.getKategori());
        update.setGambar(user.getGambar());
        update.setHarga(user.getHarga());
        return produkRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            produkRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }

}
