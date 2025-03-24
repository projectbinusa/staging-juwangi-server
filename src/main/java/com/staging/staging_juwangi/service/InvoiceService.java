package com.staging.staging_juwangi.service;

import com.staging.staging_juwangi.model.Invoice;
import com.staging.staging_juwangi.model.Orders;
import com.staging.staging_juwangi.repository.InvoiceRepository;
import com.staging.staging_juwangi.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

//    @Autowired
//    private OrdersRepository ordersRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public Invoice create (Invoice create ) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(create.getInvoiceId());
        invoice.setStatus(create.getStatus());
        invoice.setFromAddress(create.getFromAddress());
        invoice.setToAddress(create.getToAddress());
        invoice.setDate(create.getDate());
        invoice.setDueDate(create.getDueDate());
        invoice.setProduct(create.getProduct());
        invoice.setDeskripsi(create.getDeskripsi());
        invoice.setKuantitas(create.getKuantitas());
        invoice.setHarga(create.getHarga());
        invoice.setTotal(create.getTotal());

//        Optional < Orders> ordersOptional = ordersRepository.findById(create.getId());
//        if (ordersOptional.isPresent()) {
//            Orders orders = ordersOptional.get();
//
//            invoice.setFromAddress(orders.getNama());
//            invoice.setToAddress(orders.getNama());
//        } else {
//            throw new RuntimeException("orders dengan id " + create.getId() + "tidak di temukan ");
//        }

        Invoice saved = invoiceRepository.save(invoice);
        return saved;
    }
}
