package com.ddd.account.threetier.controller.resource;

import com.ddd.account.domain.Account;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class AccountResource {
    private UUID accountId;
    private AddressData addressData;

    public AccountResource() {
    }

    public static AccountResource from(Account account) {
        AccountResource accountResource = new AccountResource();
        accountResource.setAccountId(account.getAccountId().getAccountIdUUID());

        accountResource.setAddressData(AddressData.from(account.getAddress()));
        return accountResource;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }
}
