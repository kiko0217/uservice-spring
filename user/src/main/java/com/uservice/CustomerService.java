package com.uservice;

import org.springframework.stereotype.Service;

import com.uservice.client.fraud.FraudCheckResponse;
import com.uservice.client.fraud.FraudClient;
import com.uservice.client.notification.NotificationClient;
import com.uservice.client.notification.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService{
  private final CustomerRepository customerRepository;
  private final NotificationClient notificationClient;
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
    notificationClient.sendNotification(
      new NotificationRequest(
        customer.getId(),
        customer.getEmail(),
        String.format("Hi %s, welcomer to uservice...", customer.getFirstName())
      )
    );
  }
}
