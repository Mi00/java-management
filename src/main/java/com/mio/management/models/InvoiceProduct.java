package com.mio.management.models;

public class InvoiceProduct {
    private String name;
    private String discountKind;
    private int discount;
    private double priceNetto;
    private double priceBrutto;
    private double priceVat;

    public InvoiceProduct(String name, String discountKind, int discount, double priceNetto, double priceBrutto, double priceVat) {
        this.name = name;
        this.discountKind = discountKind;
        this.discount = discount;
        this.priceNetto = priceNetto;
        this.priceBrutto = priceBrutto;
        this.priceVat = priceVat;
    }

    public String getName() {
        return name;
    }

    public String getDiscountKind() {
        return discountKind;
    }

    public int getDiscount() {
        return discount;
    }

    public double getPriceNetto() {
        return priceNetto;
    }

    public double getPriceBrutto() {
        return priceBrutto;
    }

    public double getPriceVat() {
        return priceVat;
    }
}
