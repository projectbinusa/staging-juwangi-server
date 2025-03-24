package com.staging.staging_juwangi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Invoice_id")
    private Long InvoiceId;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @Column(name = "due_date")
    private Date dueDate;


    @Column(name = "from_address")
    private String fromAddress;

    @Column(name = "to_address")
    private String toAddress;

    @Column(name = "product")
    private String product;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "kuantitas")
    private Long kuantitas;

    @Column(name = "harga")
    private Float harga;

    @Column(name = "total")
    private Float total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        InvoiceId = invoiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date duoDate) {
        this.dueDate = duoDate;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

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

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
