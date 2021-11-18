package com.tw.ddd_workshop.domain.bank;

import com.tw.ddd_workshop.domain.bank.domain_service.AddressUpdater;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accounts = new ArrayList<>();
    private Address address;

    public Customer(List<Account> accounts, Address address) {
        this.accounts = accounts;
        this.address = address;
    }

    public void updateAddress(Address address) {
        AddressUpdater.updateAddress(this, address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Address getAddress() {
        return address;
    }
}
