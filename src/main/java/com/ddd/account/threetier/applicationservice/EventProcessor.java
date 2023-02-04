package com.ddd.account.threetier.applicationservice;

import com.ddd.account.domain.Account;
import com.ddd.account.domain.events.CustomerAddressUpdatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@Component
@KafkaListener(id = "someId", topics = "customer-topic")
public class EventProcessor {

    @KafkaHandler
    public void handleCustomerAddressUpdatedEvent(CustomerAddressUpdatedEvent customerAddressUpdatedEvent) {
        System.out.println("Received customerAddressUpdatedEvent = " + customerAddressUpdatedEvent);
        //Fetches all account from repository matching customerId in CustomerAddressChangedEvent
        //updates address of each account
        Account account = null;
        //Get all Account aggregates related to this Customer
        // account.updateAddress(address);
    }
}

// Saga  = business transaction =
// 2 different atomic database transaction ( 1 in each microservice)
// Choreographed Saga
// Orchestrated Saga
// Software Architecture The Hard Parts - Neal ford.
