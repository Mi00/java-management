package com.mio.management.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Invoices")
public class Invoice {
    @Id
    private String id;
    private String number;
    private Date sellDate;
    private Seller seller;
    private Buyer buyer;
    private double totalNetto;
    @Indexed(direction = IndexDirection.ASCENDING)
    private double totalBrutto;
    private double totalVat;
    private boolean isPaid;
    private List<InvoiceProduct> invoiceProducts;

    protected Invoice() {
        this.invoiceProducts = new ArrayList<>();
    }

    public Invoice(String number, Date sellDate, Seller seller, Buyer buyer, double totalBrutto, double totalNetto, double totalVat, List<InvoiceProduct> invoiceProducts, boolean isPaid){
        this.number = number;
        this.sellDate = sellDate;
        this.seller = seller;
        this.buyer = buyer;
        this.totalBrutto = totalBrutto;
        this.totalNetto = totalNetto;
        this.totalVat = totalVat;
        this.invoiceProducts = invoiceProducts;
        this.isPaid = isPaid;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public Seller getSeller() {
        return seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public double getTotalNetto() {
        return totalNetto;
    }

    public double getTotalBrutto() {
        return totalBrutto;
    }

    public double getTotalVat() {
        return totalVat;
    }

    public List<InvoiceProduct> getInvoiceProducts() {
        return invoiceProducts;
    }

    public boolean getIsPaid(){
        return isPaid;
    }
}
