package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class LegalPersonBeneficiary {

    @JsonProperty("fiscalCode")
    private String fiscalCode;
    @JsonProperty("legalRepresentativeFiscalCode")
    private String legalRepresentativeFiscalCode;
}
