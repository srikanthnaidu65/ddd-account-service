package com.ddd.account.threetier.applicationservice;

import com.ddd.account.domain.Account;
import com.ddd.account.domain.AccountId;
import com.ddd.account.domain.Address;
import com.ddd.account.threetier.repository.AccountRepository;
import com.ddd.account.domain.events.CustomerAddressUpdatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@Service
public class AccountAppService {

    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public AccountAppService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //@Transactional
    public Account createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        //commit transaction
        restTemplate.put("http://localhost:8082/customers/" + account.getCustomerIdAsString() + "/accounts/" + account.getAccountIdAsString(),
                null, new HashMap<>());
        //for non 200 http status scenario roll back above transaction
        return savedAccount;
    }

    //@Transactional
    public Account updateAddress(UUID accountId, Address address) {
        Account account = accountRepository.find(new AccountId(accountId));
        account.updateAddress(address);
        return accountRepository.save(account);
    }

    public void sendEventToKafka() {
        System.out.println("here = " + "here kafka");
        kafkaTemplate.send("customer-topic", new CustomerAddressUpdatedEvent(UUID.randomUUID(), new Address("Pune")));
    }
}
