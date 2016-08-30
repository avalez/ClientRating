package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlacklistServiceProxy {
    @Value("${blacklistServiceURL}")
    private String blacklistServiceURL;

	private RestTemplate rest = new RestTemplate();

    public CustomerStatus getCustomerStatus(Integer customerId) {
        return CustomerStatus.valueOf(rest.getForEntity(blacklistServiceURL, String.class, customerId).getBody());
    }
}
