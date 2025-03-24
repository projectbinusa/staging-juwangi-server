package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice ,Long> {
}
