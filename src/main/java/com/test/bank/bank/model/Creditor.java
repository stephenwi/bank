package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class Creditor {

    @JsonProperty("name")
    private String name;
    @JsonProperty("account")
    private Account account;
    @JsonProperty("address")
    private Address address;
}
