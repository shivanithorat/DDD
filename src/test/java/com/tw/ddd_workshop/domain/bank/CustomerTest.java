package com.tw.ddd_workshop.domain.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void addressChangeTest() {
        Account account3 = new Account(new Address("Mumbai"));
        Account account1 = new Account(new Address("Pune"));
        Account account2 = new Account(new Address("Jaipur"));
        Customer customer = new Customer(List.of(account1, account2, account3), new Address("Pune"));
        Address expectedAddress = new Address("NY");
        customer.updateAddress(expectedAddress);
        List<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            Assertions.assertEquals(expectedAddress.getCity(),account.getAddress().getCity());
        }
        Assertions.assertEquals(expectedAddress.getCity(), customer.getAddress().getCity());
    }

}