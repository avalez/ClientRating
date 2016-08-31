package com.oracle.msa.sample.clientrating.records;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

//@Component
public class FinancialRecordsProxy {
    @Value("${recordsServiceURL}")
    private String recordsServiceURL;

    private RestTemplate rest = new RestTemplate();

    public FinancialHistoryRating getHistoryRating(Integer customerId) {
        return FinancialHistoryRating.valueOf(rest.getForEntity(recordsServiceURL, String.class, customerId).getBody());
    }
}
