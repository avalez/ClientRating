package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinancialRecordsServiceProxy {
    @Autowired
    FinancialRecordsServiceClient financialRecordsService;

    public FinancialHistoryRating getHistoryRating(Integer customerId) {
        return FinancialHistoryRating.valueOf(financialRecordsService.getRating(customerId));
    }
}
