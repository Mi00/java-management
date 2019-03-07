package com.mio.management.controllers;

import com.mio.management.db.InvoiceRepository;
import com.mio.management.models.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public void insert(@RequestBody Invoice invoice){
        this.invoiceRepository.insert(invoice);
    }

    @PostMapping
    public void update(@RequestBody Invoice invoice){
        this.invoiceRepository.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.invoiceRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Invoice> getById(@PathVariable("id") String id){
        Optional<Invoice> invoice = this.invoiceRepository.findById(id);

        return invoice;
    }

    @GetMapping("/ispaid/{isPaid}")
    public List<Invoice> getByIsPaid(@PathVariable("isPaid") boolean isPaid){
        List<Invoice> invoices;
        if (isPaid){
            invoices = this.invoiceRepository.findByIsPaidIsTrue();
        } else {
            invoices = this.invoiceRepository.findByIsPaidIsFalse();
        }

        return invoices;
    }

    @GetMapping("/number/{number}")
    public List<Invoice> getByNumber(@PathVariable("number") String number){
        List<Invoice> invoices = this.invoiceRepository.findByNumber(number);

        return invoices;
    }

    @GetMapping("/buyer/{name}")
    public List<Invoice> getByBuyerName(@PathVariable("name") String name){
        List<Invoice> invoices = this.invoiceRepository.findByBuyerName(name);

        return invoices;
    }
}
