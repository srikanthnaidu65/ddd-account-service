package com.ddd.account.threetier.controller.viewmodel;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class AccountRequest {

    private AddressRequest addressRequest;

    private String CustomerId;

    public AccountRequest() {
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "addressRequest=" + addressRequest +
                ", CustomerId='" + CustomerId + '\'' +
                '}';
    }
}
