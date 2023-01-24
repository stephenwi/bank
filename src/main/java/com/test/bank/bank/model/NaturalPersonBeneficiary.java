package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class NaturalPersonBeneficiary {

    @JsonProperty("fiscalCode1")
    private String fiscalCode1;
    @JsonProperty("fiscalCode2")
    private String fiscalCode2;
    @JsonProperty("fiscalCode3")
    private String fiscalCode3;
    @JsonProperty("fiscalCode4")
    private String fiscalCode4;
    @JsonProperty("fiscalCode5")
    private String fiscalCode5;
}
