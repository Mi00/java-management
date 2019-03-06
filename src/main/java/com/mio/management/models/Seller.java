package com.mio.management.models;

public class Seller {
    private String name;
    private String address;
    private String nip;
    private String accountNumber;

    public Seller(String name, String address, String nip, String accountNumber) {
        this.name = name;
        this.address = address;
        this.nip = nip;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNip() {
        return nip;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
