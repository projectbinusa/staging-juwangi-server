package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.model.Invoice;
import com.staging.staging_juwangi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @PostMapping("/create")
    public Invoice create (@RequestBody Invoice create) {
        return invoiceService.create(create);
    }
}
