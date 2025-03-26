package com.staging.staging_juwangi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.staging.staging_juwangi.dto.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoiceId" , unique = true, nullable = false)
    private Long invoiceId;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @Column(name = "due_date")
    private Date dueDate;

    @OneToMany(mappedBy = "invoice" ,cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Address> fromAddress =new ArrayList<>();

    @OneToMany(mappedBy = "invoice" ,cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Address> toAddress = new ArrayList<>();

//    @Column(name = "from_address")
//    private String fromAddress;
//
//    @Column(name = "to_address")
//    private String toAddress;

    @OneToMany(mappedBy = "invoice" , cascade = CascadeType.ALL ,orphanRemoval = true)
    @JsonManagedReference
    private List<Item> items = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        invoiceId = invoiceId;
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

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

//    public String getFromAddress() {
//        return fromAddress;
//    }
//
//    public void setFromAddress(String fromAddress) {
//        this.fromAddress = fromAddress;
//    }
//
//    public String getToAddress() {
//        return toAddress;
//    }
//
//    public void setToAddress(String toAddress) {
//        this.toAddress = toAddress;
//    }

    public List<Item> getItems()
    {return items;}

    public void setItems(List<Item> items) {
        this.items = items;
        if (items != null) {
            items.forEach(item -> item.setInvoice(this));
        }
    }

    public List<Address> getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(List<Address> fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<Address> getToAddress() {
        return toAddress;
    }
    public void setToAddress(List<Address> toAddress) {
        this.toAddress = toAddress;
    }
}
