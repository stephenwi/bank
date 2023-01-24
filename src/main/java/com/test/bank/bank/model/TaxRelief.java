package com.test.bank.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class TaxRelief {

    @JsonProperty("taxReliefId")
    private String taxReliefId;
    @JsonProperty("isCondoUpgrade")
    private String isCondoUpgrade;
    @JsonProperty("creditorFiscalCode")
    private String creditorFiscalCode;
    @JsonProperty("beneficiaryType")
    private String beneficiaryType;
    @JsonProperty("naturalPersonBeneficiary")
    private NaturalPersonBeneficiary naturalPersonBeneficiary;
    @JsonProperty("legalPersonBeneficiary")
    private LegalPersonBeneficiary legalPersonBeneficiary;
}
