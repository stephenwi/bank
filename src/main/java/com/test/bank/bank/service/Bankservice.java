package com.test.bank.bank.service;

import com.google.gson.Gson;
import com.test.bank.bank.model.Transfert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bankservice {

    private static final String BASE_URL = "https://sandbox.platfr.io";
    //private static final String ACCOUNT_ID = "14537780";

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Auth-Schema", "S2S");
        headers.set("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        return headers;
    }

    private Map<String, Object> getDataPayload(String payloadBody) {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(payloadBody, HashMap.class);
        Map<String, Object> data = (Map<String, Object>) map.get("payload");
        return data;
    }

    public double getAccountBalance(String accountId) {
        String url = BASE_URL+"/api/gbs/banking/v4.0/accounts/"+accountId+"/balance";

        HttpEntity entity = new HttpEntity("", this.getHttpHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String balance = getDataPayload(response.getBody()).get("balance").toString();
        //System.out.println(balance);
        return Double.parseDouble(balance);
    }

    public Object getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate) {
        String url = BASE_URL+"/api/gbs/banking/v4.0/accounts/"+accountId+"/transactions?fromAccountingDate="+fromAccountingDate+"&toAccountingDate="+toAccountingDate;
        HttpEntity entity = new HttpEntity("", this.getHttpHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        Object transactionList = getDataPayload(response.getBody()).get("list");
        System.out.println(transactionList);
        return transactionList;
    }

    public Object transfertOperation(String accountId, Transfert transfert) {

        String url = BASE_URL+"/api/gbs/banking/v4.0/accounts/"+accountId+"/payments/money-transfers";
        HttpEntity entity = new HttpEntity(transfert, this.getHttpHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Transfert> resp = restTemplate.exchange(url, HttpMethod.POST, entity, Transfert.class); //(url, HttpMethod.POST, entity, transfert);
        Object response = getDataPayload(resp.getBody().toString());
        System.out.println(response);
        return response;
    }
}
