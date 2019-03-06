package com.mio.management.models;

public class Buyer {
    private String name;
    private String nip;
    private String address;

    public Buyer(String name, String nip, String address) {
        this.name = name;
        this.nip = nip;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public String getAddress() {
        return address;
    }
}
