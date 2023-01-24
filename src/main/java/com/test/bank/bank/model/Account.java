package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    @JsonProperty("accountCode")
    private String accountCode;
    @JsonProperty("bicCode")
    private String bicCode;
}
