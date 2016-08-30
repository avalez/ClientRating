package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rating")
public class RatingService {
    @Autowired
    BlacklistServiceProxy blacklistService;

    @Autowired
    FinancialRecordsServiceProxy financialRecordsService;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public String getClientRating(@PathVariable("customerId") Integer customerId) {
        CustomerStatus customerStatus = blacklistService.getCustomerStatus(customerId);
        if(customerStatus == CustomerStatus.BLACKLISTED) {
            return "0";
        } else {
            return String.valueOf(FinancialHistoryRating.values().length - financialRecordsService.getHistoryRating(customerId).ordinal());
        }
    }
}
