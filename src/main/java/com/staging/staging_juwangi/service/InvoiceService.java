package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.dto.Item;
import com.staging.staging_juwangi.model.Address;
import com.staging.staging_juwangi.model.Invoice;
import com.staging.staging_juwangi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice create) {
        Invoice add = new Invoice();
        add.setInvoiceId(create.getInvoiceId());
        add.setStatus(create.getStatus());
        add.setDate(create.getDate());
        add.setDueDate(create.getDueDate());

        List<Address> fromlist = create.getFromAddress().stream()
                .map(addr -> new Address(addr.getAddress(), add))
                .collect(Collectors.toList());
        add.setFromAddress(fromlist);

        List<Address> toList = create.getToAddress().stream()
                .map(addr -> new Address(addr.getAddress(), add))
                .collect(Collectors.toList());
        add.setToAddress(toList);

        List<Item> itemList =  create.getItems().stream().map(i -> {
                Item item = new Item();
                item.setProduct(i.getProduct());
                item.setDeskripsi(i.getDeskripsi());
                item.setKuantitas(i.getKuantitas());
                item.setHarga(i.getHarga());
                item.setInvoice(add);
                return item;
                }).collect(Collectors.toList());

            add.setItems(itemList);
            Invoice saved = invoiceRepository.save(add);

            return saved;





//        try{
//            Invoice invoice = new Invoice();
//            invoice.setInvoiceId(create.getInvoiceId());
//            invoice.setStatus(create.getStatus());
//            invoice.setFromAddress(create.getFromAddress());
//            invoice.setToAddress(create.getToAddress());
//            invoice.setDate(create.getDate());
//            invoice.setDueDate(create.getDueDate());
//
//            List<Item> itemList =  create.getItems().stream().map(i -> {
//                Item item = new Item();
//                item.setProduct(i.getProduct());
//                item.setDeskripsi(i.getDeskripsi());
//                item.setKuantitas(i.getKuantitas());
//                item.setHarga(i.getHarga());
//                item.setInvoice(invoice);
//                return item;
//                }).collect(Collectors.toList());
//
//            invoice.setItems(itemList);
//            Invoice saved = invoiceRepository.save(invoice);
//
//            return saved;
//        }catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Gagal membuat Invoice" + e.getMessage());
//        }

    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
