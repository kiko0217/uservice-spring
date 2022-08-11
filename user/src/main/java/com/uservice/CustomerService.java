package com.uservice;

import org.springframework.stereotype.Service;

import com.uservice.client.fraud.FraudCheckResponse;
import com.uservice.client.fraud.FraudClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService{
  private final CustomerRepository customerRepository;
  private final FraudClient fraudClient;
  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();
    customerRepository.saveAndFlush(customer);
    FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
    if(fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }
  }
}
