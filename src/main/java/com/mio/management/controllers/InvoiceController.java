package com.mio.management.controllers;

import com.mio.management.db.InvoiceRepository;
import com.mio.management.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/all")
    public List<Invoice> getAll(){
        List<Invoice> invoices = this.invoiceRepository.findAll();

        return invoices;
    }
}
