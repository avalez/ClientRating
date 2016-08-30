package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FinancialRecordsServiceProxy {
    @Value("${recordsServiceURL}")
    private String recordsServiceURL;

	private RestTemplate rest = new RestTemplate();

    public FinancialHistoryRating getHistoryRating(Integer customerId) {
        return FinancialHistoryRating.A_PLUS; //valueOf(rest.getForEntity(recordsServiceURL, String.class, customerId).getBody());
    }
}
