package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class Transfert {

    @JsonProperty("creditor")
    private Creditor creditor;
    @JsonProperty("executionDate")
    private String executionDate;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isUrgent")
    private String isUrgent;
    @JsonProperty("isInstant")
    private String isInstant;
    @JsonProperty("feeType")
    private String feeType;
    @JsonProperty("feeAccountId")
    private String feeAccountId;
    @JsonProperty("taxRelief")
    private TaxRelief taxRelief;
}
