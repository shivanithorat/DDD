package com.tw.ddd_workshop.domain.bank;

public class Account {
    private Address address;

    public Account(Address address) {
        this.address = address;
    }

    public Address updateAddress(Address address) {
        this.address = address;
        return this.address;
    }

    public Address getAddress() {
        return address;
    }
}
