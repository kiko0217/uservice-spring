package com.uservice.user;

public record CustomerRegistrationRequest(
  String firstName,
  String lastName,
  String email
) {

}
