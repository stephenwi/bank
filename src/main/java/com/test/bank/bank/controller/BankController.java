package com.test.bank.bank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bank.bank.model.Transfert;
import com.test.bank.bank.service.Bankservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

    private final Bankservice bankservice;

    @GetMapping("balance")
    public ResponseEntity<Double> accountBalance(@RequestParam(name = "accountId") String accountId) {
        return ResponseEntity.ok(bankservice.getAccountBalance(accountId));
    }

    @GetMapping(value = "transactions", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity accountTransactions(@RequestParam(name = "accountId") String accountId,
                                                      @RequestParam(name = "fromAccountingDate") String fromAccountingDate,
                                                      @RequestParam(name = "toAccountingDate") String toAccountingDate){

        return ResponseEntity.ok(bankservice.getAccountTransactions(accountId, fromAccountingDate, toAccountingDate));
    }

    @PostMapping(value = "transfert", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity makeTransfert(@RequestParam(name = "accountId") String accountId, @RequestBody String stringTransfertobject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Transfert transfert = objectMapper.readValue(stringTransfertobject, Transfert.class);
        return ResponseEntity.ok(bankservice.transfertOperation(accountId, transfert));
    }
}
