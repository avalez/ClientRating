package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.stereotype.Component;

@Component
public class FinancialRecordsServiceFallback implements FinancialRecordsServiceClient {

	@Override
	public String getRating(Integer customerId) {
		return FinancialHistoryRating.A_PLUS.name();
	}

}
