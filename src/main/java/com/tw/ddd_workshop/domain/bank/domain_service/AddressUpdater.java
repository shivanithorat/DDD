package com.tw.ddd_workshop.domain.bank.domain_service;

import com.tw.ddd_workshop.domain.bank.Account;
import com.tw.ddd_workshop.domain.bank.Address;
import com.tw.ddd_workshop.domain.bank.Customer;

import java.util.stream.Stream;

public class AddressUpdater {

    public static void updateAddress(Customer customer, Address newAddress) {
        for(Account account: customer.getAccounts()) {
            account.updateAddress(newAddress);
        }
        customer.setAddress(newAddress);
    }
}
